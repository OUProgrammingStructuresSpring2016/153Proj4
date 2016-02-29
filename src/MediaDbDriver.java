import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 19, 2016
 * <P>
 * Drives user interaction with a media database through the console.
 * </P>
 * @version 1.0
 */
public class MediaDbDriver {

	public static void main(String[] args) {

		/** Creates a new media database */
		MediaDatabase mdb;
		
		/** The FileReader to be wrapped by the BufferedReader */
		FileReader fr;
		
		/** The reader to parse the text files that will comprise the
		 	entries of the database */
		BufferedReader br;
		
		/** The name of the text file to be specified by the user */
		String fileName;

	}
	/**
	 * Reads a text file containing only movies into the media database.
	 * @param fileName	The name of the .txt file containing movie information
	 * @param br		The buffered reader to parse the .txt file.
	 */
	public static void readMoviesToMDb(String fileName, BufferedReader br, MediaDatabase db) throws IOException {
		
		String line = br.readLine();
		
		while (line != null) {
			
			// Data with which to construct the new Movie further below.
			String[] temp;
			String tempYear;
			String tempInfo = "";

			if (line.indexOf("(") == line.lastIndexOf("(")) { 	// i.e., if only
																// 1 pair of
																// parentheses,
																// no addtl info
				temp = line.split("\\("); 

				tempYear = (temp[1].substring(0, 4)); // (the release year)

				db.addMedia(new Movie(temp[0], tempYear, tempInfo));

			} else { // if there is any other amount of additional info

				int leftParens = 0; // The index of the left parenthesis
									// which MUST contain the year

				if (line.contains("(1")) 	// Finds where the first parenthesis
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
						line.lastIndexOf(")") + 1); 					 // additional info

				tempYear = (line.substring(leftParens + 1, leftParens + 5));

				String tempTitle = line.substring(0, leftParens - 1);

				db.addMedia(new Movie(tempTitle, tempYear, tempInfo));

			}

			line = br.readLine();
		}		
	}

	/**
	 * Reads a text file containing only TV series and episodes into the media database.
	 * @param fileName	The name of the .txt file containing TV information
	 * @param br		The buffered reader to parse the .txt file.
	 * @throws IOException 
	 */
	public static void readTVToMDb(String fileName, BufferedReader br, MediaDatabase db) throws IOException {
		
		String currentLine = br.readLine();
		TVSeries newSeries;
		
		while(currentLine != null){
			
			// checks to see if the current line is a new TV Series to add.
			// NOTE: Assumes the first line of the text file is a TV Series, not an episode.
			if(currentLine.contains("-?") || currentLine.contains("-1") || currentLine.contains("-2") ){
				
				int endOfTitleIndex = currentLine.indexOf("\"", 1);
				
				// ignore first quotation mark and find the second to determine title
				String ntitle = currentLine.substring(1, endOfTitleIndex);
				
				String nyear = currentLine.substring(endOfTitleIndex+1, currentLine.lastIndexOf(")"));
				
				int runYearIndex = currentLine.lastIndexOf("-");	
				
				String nrunYears = currentLine.substring(runYearIndex-4, runYearIndex+5);
				
				newSeries = new TVSeries(ntitle, nyear, nrunYears);
				
				db.addMedia(newSeries);
				
			}
			else{ // implies current line is a TV Episode belonging to the current TV Series
				
				String epData = currentLine.substring(currentLine.indexOf("{"));
				
				String epYear = currentLine.substring(currentLine.length()-5);
				
				if(epData.contains("{{")){ // if episode was suspended
					
					String epTitle = epData.substring(epData.indexOf("{"), epData.lastIndexOf("}")+1 );
					
					newSeries.addEpisode(new TVEpisode(epTitle, "", "????"));
					
				}
				
				else if(epData.contains("#") ){ // if episode contains an episode and season number
					
					String epTitle = epData.substring(0, epData.indexOf("(")-1);
					
					String seasonEpNums = epData.substring(epData.lastIndexOf("(")+1, epData.lastIndexOf(")") );
					
					newSeries.addEpisode(new TVEpisode(epTitle, seasonEpNums, epYear));
					
				}
				else{ // if no season nums
					
					
					
				}
				
				
				
				newSeries.addEpisode();
				
			}
			
			
			currentLine = br.readLine();
		}
		
	}
}
