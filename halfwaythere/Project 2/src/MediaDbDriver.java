import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Project #2 CS 2334, Section 010 Feb 19, 2016
 * <P>
 * Drives user interaction with a media database through the console.
 * </P>
 * 
 * @version 1.0
 */
public class MediaDbDriver {

	public static void main(String[] args) throws IOException {
		
		/** Creates a new media database */
		MediaDatabase mdb = new MediaDatabase();
		
		BufferedReader inputReader = new BufferedReader(
				new InputStreamReader(System.in) );
		
		System.out.println("Enter the name of the text file, with .txt extension, containing the movie data.");
		
		String fileName = inputReader.readLine();

		/** The FileReader to be wrapped by the BufferedReader */
		FileReader fr = new FileReader(fileName);

		/**
		 * The reader to parse the text files that will comprise the entries of
		 * the database
		 */
		BufferedReader br = new BufferedReader(fr);
		
		readMoviesToMDb(br, mdb);
		
		System.out.println("Enter the name of the text file, with .txt extension, containing the TV series data.");

		fileName = inputReader.readLine();
		
		fr = new FileReader(fileName);
		
		br = new BufferedReader(fr);
		
		readTVToMDb(br, mdb);
		
		fr.close();
		
		mdb.sortDatabase();
		
		
		
		String matchInput = ""; // instantiated to quiet compiler. To be overwritten below before use.
		String yearInput = "";
		String includeTitles = "";
		String titleToSearch = "";
		String yearsToSearch = "";
		String sortInput = "";
		
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
				System.out.println("Please enter a valid response (t, y, or b). Returning to beginning.");
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
					System.out.println("Please enter valid input (y or n). Returning to beginning.");
					continue;
				}
			}
			
			if(!searchInput.equals("y")){ // if user answered t or b to second question
				System.out.println("Title to search for?");
				titleToSearch = inputReader.readLine();
			}
			
			if(!searchInput.equals("t")){
				System.out.println("Year (or years) to search for?");
				yearsToSearch = inputReader.readLine();
			}
			
			
			System.out.println("Sort by (t)itle or (y)ear?");
			sortInput = inputReader.readLine();
			
			
			
			
			
			
			
			
			
			
			mdb.clearResultsList();
			
		}
		
		
		
		

	}

	/**
	 * Reads a text file containing only movies into the media database.
	 * 
	 * @param fileName
	 *            The name of the .txt file containing movie information
	 * @param br
	 *            The buffered reader to parse the .txt file.
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
	 * @param fileName
	 *            The name of the .txt file containing TV information
	 * @param br
	 *            The buffered reader to parse the .txt file.
	 * @throws IOException
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

				int endOfTitleIndex = currentLine.indexOf("\"", 1);

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

				String epYear = currentLine.substring(currentLine.length() - 5);

				if (epData.contains("{{")) { // if episode was suspended

					String epTitle = epData.substring(epData.indexOf("{"),
							epData.lastIndexOf("}") + 1);

					newSeries.addEpisode(new TVEpisode(epTitle, "", "????"));

				}

				else if (epData.contains("{(")) { // if episode contains no
													// title, but season/ep
													// numbers

					String seasonEpNums = epData.substring(
							epData.lastIndexOf("(") + 1,
							epData.lastIndexOf(")"));

					newSeries
							.addEpisode(new TVEpisode("", seasonEpNums, epYear));

				} else if (epData.contains("#")) { // episode has ALL info

					String epTitle = epData.substring(1,
							epData.lastIndexOf("(") - 1);

					String seasonNums = epData.substring(
							epData.lastIndexOf("(") + 1,
							epData.lastIndexOf(")"));

					newSeries.addEpisode(new TVEpisode(epTitle, seasonNums,
							epYear));

				} else { // episode has no season/episode number

					String epTitle = epData.substring(1,
							epData.lastIndexOf("}"));

					newSeries.addEpisode(new TVEpisode(epTitle, "", epYear));

				}

			}

			currentLine = br.readLine();
		}

	}
}
