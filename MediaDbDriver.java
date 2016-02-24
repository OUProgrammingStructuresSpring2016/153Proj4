import java.io.BufferedReader;
import java.io.FileReader;

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
	public static void readMoviesToMDb(String fileName, BufferedReader br) {

	}

	/**
	 * Reads a text file containing only TV series and episodes into the media database.
	 * @param fileName	The name of the .txt file containing TV information
	 * @param br		The buffered reader to parse the .txt file.
	 */
	public static void readTVToMDb(String fileName, BufferedReader br) {

	}
}
