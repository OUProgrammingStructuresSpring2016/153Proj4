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

	public static void main(String[] args) throws IOException {

		MediaDatabase mdb = new MediaDatabase();
		MediaPersonDatabase mpdb = new MediaPersonDatabase();
		
		BufferedReader inputReader = new BufferedReader(
				new InputStreamReader(System.in) );
		
		question1:while(true)
		{
			System.out.println("Read (t)ext or (b)inary data?");
			
			String binOrTxt = inputReader.readLine();
			
			switch (binOrTxt)
			{
			case "t":
				break question1;
			case "b":
				System.out.println("Enter the name of the binary file.");
				try {
					mpdb = new MediaPersonDatabase(inputReader.readLine());
				} catch (ClassNotFoundException e) {
					System.out.println("ERROR: File not found. Ensure the file name was typed correctly and that the file exists.");
					continue;
				}
				break question1;
			default:
				System.out.println("Please use the options indicated in parentheses.");
				break;
			}
		}

		
		System.out.println("Enter the name of the text file, with .txt extension, containing the movie data.");
		
		String fileName = inputReader.readLine();
		
		//TODO REMOVE THIS
		fileName = "StarTrekMovies.txt";
				
		/** The FileReader to be wrapped by the BufferedReader */
		FileReader fr = new FileReader(fileName);

		/**
		 * The reader to parse the text files that will comprise the entries of
		 * the database
		 */
		BufferedReader br = new BufferedReader(fr);
		
		//reads in the Movie file to mdb
		readMoviesToMDb(br, mdb);
		
		System.out.println("Enter the name of the text file, with .txt extension, containing the TV series data.");

		fileName = inputReader.readLine();
		
		//TODO REMOVE THIS
		fileName = "StarTrekTV.txt";
		
		fr = new FileReader(fileName);
		
		br = new BufferedReader(fr);
		
		//reads in the TV file to mdb
		readTVToMDb(br, mdb);
		
		fr.close();
		
		System.out.println("Enter the name of the text file, with .txt extension, containing the actor data.");

		fileName = inputReader.readLine();
		
		//TODO REMOVE THIS
		fileName = "SomeActors.txt";
		
		fr = new FileReader(fileName);
		
		br = new BufferedReader(fr);

		//reads in Actors to mpdb
		readPeopleToMDb(br, mpdb, "ACTING");
		
		fr.close();
		
		System.out.println("Enter the name of the text file, with .txt extension, containing the director data.");

		fileName = inputReader.readLine();
		//TODO REMOVE THIS
		fileName = "SomeDirectors.txt";
		fr = new FileReader(fileName);
		
		br = new BufferedReader(fr);
		
		//reads in Directors to mpdb
		readPeopleToMDb(br, mpdb, "DIRECTING");
		
		fr.close();
		
		System.out.println("Enter the name of the text file, with .txt extension, containing the producer data.");

		fileName = inputReader.readLine();
		//TODO REMOVE THIS
		fileName = "SomeProducers.txt";
		fr = new FileReader(fileName);
		
		br = new BufferedReader(fr);
		
		//reads in Producer file into mpdb
		readPeopleToMDb(br, mpdb, "PRODUCING");
		
		fr.close();
		
		
		
		mdb.sortDatabase();
		
		String matchInput = ""; // instantiated to quiet compiler. To be overwritten below before use.
		String yearsToSearch = "";
		String includeTitles = "";
		String titleToSearch = "";
		String sortInput = "";
		boolean includeEpTitles = false;
		
		// the text to output for outputting to a text file.
		String personTextOutput = "";
		

		mop:while(true) {
			mpdb.clearResultsList();
			System.out.println("Search (m)edia or (p)eople?");
			String mediaOrPeople = inputReader.readLine();
			switch(mediaOrPeople) {
			case "m":
				break mop;
			case "p":
				eop:while(true) {
					System.out.println("Search for (e)xact or (p)artial matches?");
					String partialOrExact = inputReader.readLine();
					switch(partialOrExact) {
					case "p":
						System.out.println("Please enter a name to search for: ");
						String name = inputReader.readLine();
						ArrayList<MediaPerson> partialMatches = mpdb.searchPartial(name);	
						personTextOutput += "SEARCHED PEOPLE \nPARTIAL NAME: " + name + "\n================================================================================ \n";
						System.out.println("SEARCHED PEOPLE");
						System.out.println("PARTIAL NAME: " + name);
						System.out.println("================================================================================");
						for(MediaPerson person: partialMatches){
							System.out.println(person.getProfession());
							personTextOutput += person.getProfession();
						}
					gob:while(true){	
						System.out.println("Save search results? (y/n)");
						String ssr = inputReader.readLine();
						 if(ssr.equals("y")){
							System.out.println("Save as (t)ext file or (b)inary file?");
							String ynSave = inputReader.readLine();
							if(ynSave.equals("t")){
								System.out.println("What would you like to name the text file?");
									MediaPersonDatabase.outputToTextFile(inputReader.readLine(), personTextOutput);	
									System.out.println("Completed.");
									break gob;
							}
							else if(ynSave.equals("b")){
								System.out.println("What would you like to name the binary file?");
								mpdb.outputToBinaryFile(inputReader.readLine());
								System.out.println("Completed.");
								break gob;
							}
							else continue gob;
						 }
						 else break gob;
					}
						break eop;
						
					case "e":
						System.out.println("Please enter a name to search for: ");
						MediaPerson personFound = mpdb.searchExact(inputReader.readLine());
						if(personFound == null) {
							while(true) {
								System.out.println("Person not Found. Continue (y/n)?");
								String cnt = inputReader.readLine();
								switch(cnt) {
								case "y":
									continue mop;
								case "n":
									System.exit(0);
								default: 
									System.out.println("Please enter a valid response (y or n).");
									break;
								}
							}	
						}
							
						tog: while(true) {
							System.out.println("Display (t)ext or (g)raph?");
							String textOrGraph = inputReader.readLine();
							switch(textOrGraph)
							{
								case "t":
									personTextOutput += "SEARCHED PEOPLE \nEXACT NAME: " + personFound.getName() + "\n================================================================================";
									System.out.println("SEARCHED PEOPLE");
									System.out.println("EXACT NAME: " + personFound.getName());
									System.out.println("================================================================================");
									System.out.println(personFound.worksToString());
									personTextOutput += "\n" + personFound.worksToString();				
									System.out.println("Save search results? (y/n)");
									String tob = inputReader.readLine();
									 if(tob.equals("y")){
										System.out.println("Save as (t)ext file or (b)inary file?");
										String ynSave = inputReader.readLine();
										if(ynSave.equals("t")){
											System.out.println("What would you like to name the text file?");
												MediaPersonDatabase.outputToTextFile(inputReader.readLine(), personTextOutput);	
												System.out.println("Completed.");
										}
										else if(ynSave.equals("b")){
											System.out.println("What would you like to name the binary file?");
											mpdb.outputToBinaryFile(inputReader.readLine());
											System.out.println("Completed.");
										}
										else continue tog;
									}
									else
										continue mop;
									break tog;
								case "g":
									
									while(true) {
										System.out.println("Display (p)ie chart or (h)istogram?");
										String pieOrHistogram = inputReader.readLine();
										switch(pieOrHistogram) {
										case "p":
											drawPie(personFound);
											break tog;
										case "h":
											drawHistogram(personFound);
											break tog;
										default:
											System.out.println("Please enter a valid input (p or h).");
											break;
										}

									}
								default:
									System.out.println("Please enter a valid input (t or g).");
									break;
							}

						}
						
						break eop;
					default: 
						System.out.println("Please enter a valid response (p or e).");
						break;
					}
					
				}
			break ;
			default: 
				System.out.println("Please enter a valid response (m or p).");
				break;
			}
			
		}


		
		while(true){ // loops until user exits
			
			System.out.println("Search (m)ovies, (s)eries, or (b)oth?");
			
			// which databases to search
			String dbInput = inputReader.readLine();
			
			if(!dbInput.equals("m")&& !dbInput.equals("s")&& !dbInput.equals("b") ){ // if invalid input
				System.out.println("Please enter a valid response (m, s, or b).");
				continue;
			}
			
			System.out.println("Search  (t)itle, (y)ear, or (b)oth?");
			
			// which parameters to search the databases for
			String searchInput = inputReader.readLine();
			
			if(!searchInput.equals("t") && !searchInput.equals("y") && !searchInput.equals("b")){ // if invalid input
				System.out.println("nter a valid response (t, y, or b). Returning to beginning.");
				continue;
			}
			
			if(!searchInput.equals("y")){ // if t or b was chosen
				System.out.println("Search for (e)xact or (p)artial title matches?");
				matchInput = inputReader.readLine();
				if(!matchInput.equals("e") && !matchInput.equals("p")){ // if invalid input
					System.out.println("Please enter a valid response (e or p). Returning to beginning.");
					continue;
				}
			}
			
			if( !dbInput.equals("m") && !searchInput.equals("y")){ // user answered either s or b on first question and t or b to the second
				System.out.println("Include episode titles in search and output? (y/n)");
				includeTitles = inputReader.readLine();
				if(!includeTitles.equals("y") && !includeTitles.equals("n") ){ // if invalid input
					System.out.println("Please enter valid response (y or n). Returning to beginning.");
					continue;
				}
				includeEpTitles = includeTitles.equals("y");
			}
			
			if(!searchInput.equals("y")){ // if user answered t or b to second question
				System.out.println("Title to search for?");
				titleToSearch = inputReader.readLine();
			}
			
			if(!searchInput.equals("t")){
				System.out.println("Year (single) to search for?");
				yearsToSearch = inputReader.readLine();
			}
			


			
			System.out.println("Sort by (t)itle or (y)ear?");
			sortInput = inputReader.readLine();
			if(!sortInput.equals("t") && !sortInput.equals("y")){
				System.out.println("Please enter a valid input (t or y). Returning to beginning.");
				continue;
			}
			
			String output = "SEARCHED ";
			
			if(dbInput.equals("b")){
				if(includeEpTitles)
					output += "MOVIES, TV SERIES, AND TV EPISODES";
				else
					output += "MOVIES AND TV SERIES";
				
				if(searchInput.equals("p"))
					output += "\nPARTIAL TITLE: " + titleToSearch;
				else
					output += "\nEXACT TITLE: " + titleToSearch;
				
				if(yearsToSearch.isEmpty())
					output += "\nYEAR: Any";
				else
				output += "\nYEAR: " + yearsToSearch;
		
				if(sortInput.equals("y"))
					output += "\nSORTED BY YEAR";
				else
					output += "\nSORTED BY TITLE";
			}
			else if(dbInput.equals("m")){
				
				output += "MOVIES \n";
				
				if(matchInput.equals("p"))
					output += "PARTIAL TITLE: " + titleToSearch;
				else
					output += "EXACT TITLE: " + titleToSearch;
				
				output += "\nYEAR: " + yearsToSearch;
				
				if(sortInput.equals("y"))
					output += "\nSORTED BY YEAR";
				else
					output += "\nSORTED BY TITLE";
			}
			else{
				if(includeEpTitles)
					output += "TV SERIES AND TV EPISODES";
				else
					output += "TV SERIES";
				if(matchInput.equals("p"))
					output += "\nPARTIAL TITLE: " + titleToSearch;
				else
					output += "\nEXACT TITLE: " + titleToSearch;
				
				output += "\nYEAR: " + yearsToSearch;
				
				if(sortInput.equals("y"))
					output += "\nSORTED BY YEAR";
				else
					output += "\nSORTED BY TITLE";
			}
			
			output += "\n===============================================================================";
			
			System.out.println(output);
			
				switch(dbInput){
				case "m":
					switch(searchInput){
					case "t":
						switch(matchInput){
						case "e":
							mdb.searchMovieTitleExact(titleToSearch); // m, t, e
							break;
						case "p":
							mdb.searchMovieTitlePartial(titleToSearch); // m, t, p
							break;
						}
						break;
					case "y":
						mdb.searchMovieYear(yearsToSearch); // m, y
						break;
					case "b":
						mdb.searchMovieBoth(titleToSearch, yearsToSearch); // m, b
						break;
					}
					break;
				case "s":
					switch(searchInput){
					case "t":
						switch(matchInput){
						case "e":
							mdb.searchTVTitleExact(titleToSearch, includeEpTitles); // s, t, e
							break;
						case "p":
							mdb.searchTVTitlePartial(titleToSearch, includeEpTitles); // s, t, p
							break;
						}
						break;
					case "y":
						mdb.searchTVYear(yearsToSearch); // s, y
						break;
					case "b":
						mdb.searchTVBoth(titleToSearch, yearsToSearch, matchInput, includeEpTitles); // s, b
						break;
						
					}
					break;
				case "b":
					switch(searchInput){
					case "t":
						switch(matchInput){
						case "e":
							mdb.searchMovieTitleExact(titleToSearch);			// b, t, e
							mdb.searchTVTitleExact(titleToSearch, includeEpTitles);
							break;
						case "p":
							mdb.searchMovieTitlePartial(titleToSearch); 	  // b, t, p
							mdb.searchTVTitlePartial(titleToSearch, includeEpTitles);
							break;
						}
						break;
					case "y":
						mdb.searchMovieYear(yearsToSearch); // b, y
						mdb.searchTVYear(yearsToSearch);
						break;
					case "b":
						mdb.searchMovieBoth(titleToSearch, yearsToSearch); // b, b
						mdb.searchTVBoth(titleToSearch, yearsToSearch, matchInput, includeEpTitles);
						break;
					}
					break;
				}
				
				// attempts to sort the database by year before printing
				if(sortInput.equals("y"))
					mdb.sortResultsByYear();
				
				System.out.println(mdb.resultListToString());
			
			System.out.println("Save search results as text file? (y/n)");
			if(inputReader.readLine().equals("y")){
				System.out.println("What would you like to name the text file?");
				mdb.outputToFile(sortInput.equals("y"), inputReader.readLine(), (output + mdb.resultListToString()) );
			}
			
			mdb.clearResultsList();
			
			System.out.println("Would you like to continue? (y/n)");
			if(inputReader.readLine().equals("n")){
				br.close();
				return;
			}
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

		String line = br.readLine();

		longRead:while (line != null) {
			
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
		frame.setSize(500, 500);
		frame.setTitle(person.getName());
	//	pieChart pc = new pieChart(person);
	//	frame.add(pc);
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
		frame.setSize(1000, 500);
		frame.setTitle(person.getName());
		histogram hs = new histogram(person);
		frame.add(hs);
		frame.setVisible(true);
	}
	
}
