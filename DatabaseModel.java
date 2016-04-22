import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Model for the database 
 */
public class DatabaseModel extends Database implements Serializable{
	
	private static final long serialVersionUID = -380182387196408449L;
	
	

	//ArrayList of ActionListeners to be registered later on
	ArrayList<ActionListener> actionListenerList; 
	
	/** Constructor for the Database model
	 * 
	 *@param mdb Media database to pass through the model 
	 *@param mpdb media Person database to pass through the model 
	 */
	 
	public DatabaseModel(MediaDatabase mdb, MediaPersonDatabase mpdb){
		super(mdb, mpdb);
	}
	
	/**
	 * Database model taking from a file name 
	 *@param fileName name of the file to add to the database 
	 *@throws IOException exception from In/Output
	 *@throws  ClassNotFoundException exception from possible class issues
	 */
	public DatabaseModel(String fileName) throws IOException, ClassNotFoundException{
		super(null, null);
		
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		DatabaseModel d = (DatabaseModel) ois.readObject();
		ois.close();
		
		this.mdb = d.mdb;
		this.mpdb = d.mpdb;
		
	}
	
	//methods that belong to the DatabaseModel Class
	/** Register an action event listener 
	*@param al ActionListener for the method
	*/
	public synchronized void addActionListener(ActionListener aL){
		if (actionListenerList == null) {
			actionListenerList = new ArrayList<ActionListener>();
		}
		actionListenerList.add(aL);
	}
	
	/** Remove an action event 
	*@param al ActionListener for thie method
	*/
	public synchronized void removeActionListener(ActionListener aL){
		if (actionListenerList != null && actionListenerList.contains(aL)) {
			actionListenerList.remove(aL);
		}
	}
	
	/** Process the event if something happens
	 * @param e ActionEvent for this method 
	 */
	public void processEvent(ActionEvent e){
		ArrayList<ActionListener> list;
		synchronized (this) {
			if (actionListenerList == null)
				return;
			// Do not worry about the cast warning here.
			list = (ArrayList<ActionListener>) actionListenerList.clone();
		}
		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	}
	
	/**
	 * Save the database 
	 * @param fileName Name of file to save 
	 * @throws IOException If file not found
	 */
	public void saveDatabase(String fileName) throws IOException{
		FileOutputStream filer = new FileOutputStream(fileName);
		ObjectOutputStream bw = new ObjectOutputStream(filer);
		bw.writeObject(this);
		bw.close();
	}
	
	/**
	 * Reads a text file containing only actors into the media database.
	 * @param br The buffered reader to parse the .txt file.
	 * @param db	The MediaPersonDatabase to put the new movies into.
	 * @param mdb Media Database to be used
	 * @param role The role of a person (actor,director, producer)
	 * @throws	IOException	If File not found
	 */
	public static void readPeopleToMDb(BufferedReader br,
			MediaPersonDatabase db, MediaDatabase mdb, String role) throws IOException {

		int workCounter = 0;

		String line = br.readLine();

		longRead:while (line != null) {
		
			workCounter = 0;
			
			while(line.length()==0){
				line = br.readLine();
				if(line == null) break longRead;
			}
				
			
			String lastName = "", firstName="";
			MediaPerson person = null;
			
			int c_idx=0;
			int n_idx=0;
			
			n_idx = line.indexOf(",");
			lastName = line.substring(c_idx, n_idx);
			c_idx = n_idx+2;
			n_idx = line.indexOf("\t");
			firstName = line.substring(c_idx,n_idx);
			person = new MediaPerson(firstName+" "+lastName,role);
			
			//check if the person is already entered
			MediaPerson test = db.searchExact(firstName+" "+lastName);
			if(test != null) person = test;
			

			switch(role){
			case "acting": person.setActingStartIndex(workCounter);
			break;
			case "directing": person.setDirectingStartIndex(workCounter);
			break;
			case "producing": person.setProducingStartIndex(workCounter);
			break;
			}

			
			while(line!=null && line.length()>0 ) {
	
				c_idx = n_idx;
				while(line.charAt(c_idx) =='\t') c_idx++;
				
				
				n_idx = line.indexOf("(",n_idx)-1;
				String title = line.substring(c_idx,n_idx);
				c_idx = n_idx+2;
				n_idx = line.indexOf(")",c_idx);
				String year = line.substring(c_idx,n_idx);
				c_idx = n_idx+2;
				n_idx = c_idx+1;
				String madeFor = "";
				if(n_idx<line.length()){
					if(line.substring(c_idx,n_idx).equals("(")){
						c_idx++; n_idx++;
						if(line.substring(c_idx,n_idx).equals("T")){
							madeFor=" (TV)";
						} else {
							madeFor=" (V)";
						}
					}
				}
				
				if(line.contains("{") && !line.contains("{{"))
				{
					person.addWork(new TVSeries(title, year, ""), "series", role);
					mdb.addMedia(new TVSeries(title, year, ""));
					workCounter++;
				} 
				else {
					person.addWork(new Movie(title, year, madeFor), "movie", role);
					workCounter++;
				}
				c_idx = 0; n_idx=0;
				line = br.readLine();
			}			
			
			if(person!=null && person != test)db.addPerson(person);
			
			line = br.readLine();

		}
	}
	
	/**
	 * Reads a text file containing only TV series and episodes into the media
	 * database.
	 * 
	 * @param br The buffered reader to parse the .txt file.
	 * @param db The database to read the TVSeries/TVEpisode's into.
	 * @throws IOException If file not found.
	 */
	public static void readTVToMDb(BufferedReader br,
			MediaDatabase db) throws IOException {

		String currentLine = br.readLine();
		TVSeries newSeries = new TVSeries("", "", "");

		while (currentLine != null) {

			// checks to see if the current line is a new TV Series to add.
			// NOTE: Assumes the first line of the text file is a TV Series, not
			// an episode.
			if (currentLine.contains("-?") || currentLine.contains("-1")
					|| currentLine.contains("-2")) {

				int endOfTitleIndex = currentLine.indexOf("\"", 2);

				// ignore first quotation mark and find the second to determine
				// title
				String ntitle = currentLine.substring(1, endOfTitleIndex);

				String nyear = currentLine.substring(endOfTitleIndex + 2,
						currentLine.lastIndexOf(")") + 1);

				int runYearIndex = currentLine.lastIndexOf("-");

				String nrunYears = currentLine.substring(runYearIndex - 4,
						runYearIndex + 5);

				newSeries = new TVSeries(ntitle, nyear, nrunYears);

				db.addMedia(newSeries);

			} else { // implies current line is a TV Episode belonging to the
						// current TV Series

				String epData = currentLine.substring(currentLine.indexOf("{"));

				String epYear = currentLine.substring(currentLine.length() - 4);

				if (epData.contains("{{")) { // if episode was suspended

					String epTitle = epData.substring(epData.indexOf("{"),
							epData.lastIndexOf("}") + 1);

					newSeries.addEpisode(new TVEpisode(epTitle, "", "????", newSeries.getTitle()));

				}

				else if (epData.contains("{(")) { // if episode contains no
													// title, but season/ep
													// numbers

					String seasonEpNums = epData.substring(
							epData.lastIndexOf("(") + 1,
							epData.lastIndexOf(")"));

					newSeries
							.addEpisode(new TVEpisode("{no title}", seasonEpNums, epYear, newSeries.getTitle()));

				} else if (epData.contains("#")) { // episode has ALL info

					String epTitle = epData.substring(1,
							epData.lastIndexOf("(") - 1);

					String seasonNums = epData.substring(
							epData.lastIndexOf("(") + 1,
							epData.lastIndexOf(")"));

					newSeries.addEpisode(new TVEpisode(epTitle, seasonNums,
							epYear, newSeries.getTitle()));

				} else { // episode has no season/episode number

					String epTitle = epData.substring(1,
							epData.lastIndexOf("}"));

					newSeries.addEpisode(new TVEpisode(epTitle, "", epYear, newSeries.getTitle()));

				}

			}

			currentLine = br.readLine();
		}
		
	}
	
	/**
	 * Reads a text file containing only movies into the media database.
	 * @param br The buffered reader to parse the .txt file.
	 * @param db	The MediaDatabase to put the new movies into.
	 * @throws	IOException	If File not found
	 */
	public static void readMoviesToMDb(BufferedReader br,
			MediaDatabase db) throws IOException {

		String line = br.readLine();

		while (line != null) {

			// Data with which to construct the new Movie further below.
			String[] temp;
			String tempYear;
			String tempInfo = "";

			if (line.indexOf("(") == line.lastIndexOf("(")) { // i.e., if only
																// 1 pair of
																// parentheses,
																// no addtl info
				temp = line.split("\\(");

				tempYear = (temp[1].substring(0, 4)); // (the release year)

				db.addMedia(new Movie(temp[0], tempYear, tempInfo));

			} else { // if there is any other amount of additional info

				int leftParens = 0; // The index of the left parenthesis
									// which MUST contain the year

				if (line.contains("(1")) // Finds where the first parenthesis
											// is at. This is where the year
											// must be located.

					leftParens = line.indexOf("(1");

				else if (line.contains("(2"))
					leftParens = line.indexOf("(2");
				else if (line.contains("(?"))
					leftParens = line.indexOf("(?");
				else { // If this happens, we're in trouble.
					System.out
							.println("ERROR: database entry in text file is incorrect. "
									+ "Please ensure //ALL// entries are correctly formatted.");
					return;
				}

				tempInfo = line.substring(line.indexOf(" ", leftParens), // Gathers
																			// ALL
						line.lastIndexOf(")") + 1); // additional info

				tempYear = (line.substring(leftParens + 1, leftParens + 5));

				String tempTitle = line.substring(0, leftParens - 1);

				db.addMedia(new Movie(tempTitle, tempYear, tempInfo));

			}

			line = br.readLine();
		}
	}
	
}
