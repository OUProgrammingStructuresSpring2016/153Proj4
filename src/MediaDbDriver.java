package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Project #3 CS 2334, Section 010 March 28, 2016
 * <P>
 * Drives user interaction with a media database through the console.
 * </P>
 * 
 * @version 1.0
 */
public class MediaDbDriver {
		/** Model for the database */
		private static DatabaseModel model;
		/** view for the database */
		private static ViewMDB databaseView;
		/**View for the selection */
		private static SelectionView  selectionView;
		/** Controlled of the media */
		private static MediaController controller; 

	
	/**Main method for this whole project 
	 *@param args Command arguments 
	 */
	public static void main(String[] args) {
		
		MediaDatabase mdb = new MediaDatabase();
		MediaPersonDatabase mpd = new MediaPersonDatabase(); 
		model = new DatabaseModel();
		databaseView = new ViewMDB();
		selectionView = new SelectionView();
		controller = new MediaController(databaseView, model);

		
		databaseView.setModel(model);
		selectionView.setModel(model);
		controller.setModel(model);
		controller.setView(databaseView);
		
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
	 * Reads a text file containing only actors into the media database.
	 * @param br The buffered reader to parse the .txt file.
	 * @param db	The MediaPersonDatabase to put the new movies into.
	 * @throws	IOException	If File not found
	 */
	public static void readPeopleToMDb(BufferedReader br,
			MediaPersonDatabase db, String role) throws IOException {

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
			}
			person.addWorkDivider(role.toUpperCase());

			
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
					workCounter++;
				} else {
					person.addWork(new Movie(title, year, madeFor), "movie", role);
					workCounter++;

					person.addWork("SERIES: "+title+" ("+year+")", "series", role);
				} else {
					person.addWork("MOVIE"+madeFor+": "+title+" ("+year+")", "movie", role);

				}
				c_idx = 0; n_idx=0;
				line = br.readLine();
			}			
			
			if(person!=null && person != test)db.addPerson(person);
			
			line = br.readLine();

		}
	}
	
	
	/**
	 * Draws a pie chart displaying media makers products
	 * 
	 * @param person the media maker to draw for
	 */
	public static void drawPie(MediaPerson person)
	{
		JFrame frame = new JFrame();
		frame.setTitle(person.getName());
		PieChartJ pc = new PieChartJ(person);
		frame.getContentPane().add(pc);
		frame.setSize(1000, 1000);
		frame.setVisible(true);	
		
	}
	
	/**
	 * Draws a histogram displaying media makers products
	 * 
	 * @param person the media maker to draw for
	 */
	public static void drawHistogram(MediaPerson person)
	{
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setTitle(person.getName());
		histogram hs = new histogram(person);
		frame.add(hs);
		frame.setVisible(true);
	}
	
}
