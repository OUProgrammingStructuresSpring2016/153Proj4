import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class Database implements Serializable, Comparable, Comparator{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7268724220221522022L;
	//private fields for Database Class
	//holds the media makers in a map
	LinkedHashMap<String, MediaMakers> makers;
	//ArrayList that holds all the media accessible 
	ArrayList<Media> media;
	
	//constructor for database class
	public Database() {
	}

	
	/**
	 * Adds a new media object. Mutator method
	 * @param 	media		New media object.
	 */
	public void addMedia(Media media) {

	}

	
	/**
	 * Searches for a media object with the exact title
	 * @param 	title		title to be searched for
	 */
	public ArrayList<Media> searchMovieTitleExact(String title) {
		return null;
	}

	
	/**
	 * Searches for a media object with the partial title
	 * @param 	title		title to be searched for
	 */
	public ArrayList<Media> searchMovieTitlePartial(String title) {
		return null;
	}

	
	/**
	 * Searches for a media object with the exact year
	 * @param 	year		year to be searched for
	 */
	public ArrayList<Media> searchMovieYear(String year) {
		return null;
	}

	
	/**
	 * Searches for a media object with the exact title and year
	 * @param 	title		title to be searched for
	 * @param	year		year to be searched for
	 */
	public ArrayList<Media> searchMovieBoth(String title, String year) {
		return null;
	}

	
	/**
	 * Searches for a media object with the exact title
	 * @param 	title		title to be searched for
	 */
	public ArrayList<Media> searchTVTitleExact(String title, boolean includeEpTitles) {
		return null;
	}

	
	/**
	 * Searches for a media object with the partial title
	 * @param 	title		title to be searched for
	 */
	public ArrayList<Media> searchTVTitlePartial(String title){
		return null;
	}

	
	/**
	 * Searches for a media object with the exact year
	 * @param 	year		year to be searched for
	 */
	public ArrayList<Media> searchTVYear(String year) {
		return null;
	}

	
	/**
	 * Searches for a media object with the exact title and year
	 * @param 	title		title to be searched for
	 * @param	year		year to be searched for
	 */
	public ArrayList<Media> searchTVBoth(String title, String year, boolean includeEpTitles) {
		return null;
	}
	
	
	/**
	 * Searches for a media maker object with the exact title
	 * @param 	title		title to be searched for
	 */
	public ArrayList<MediaMakers> searchMediaMakers(String title) {
		return null;
	}

	
	/**
	 *reads in a file 
	 */
	public void readFile() {
	}
	/**
	 *writes a file with the desired format
	 */
	public void writeFile() {
	}


	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
