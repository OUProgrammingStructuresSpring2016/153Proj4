import java.io.Serializable;
import java.util.Comparator;

/**
 * Project #3
 * CS 2334, Section 010
 * Mar 28, 2016
 * <P>
 * An object representing an abstract media object to be extended into actual
 * media objects (TV series and movies).
 * </P>
 * @version 1.0
 */

public abstract class Media implements Comparable<Media>, Serializable{

	private static final long serialVersionUID = 8891247205789573333L;

	/** Stores the title of the media. */
	protected String title;
	
	/** Stores the year the media was released. */
	protected String year;
	
	/** Creates a new instance of a media object using a title and year.
	 *  @param	title	The title of the new media object
	 *  @param	year	The release year of the new media object
	 */
	public Media(String title, String year){
		this.title = title;
		this.year = year;
	}
	
	/**
	 * @return	Title of the media.
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * @return	Release year of the media.
	 */
	public String getYear(){
		return this.year;
	}
	
	/**
	 * @param	title	The new title for the media.
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 * @param	year	The new year for the media.
	 */
	public void setYear(String year){
		this.year = year;
	}
	/**
	 * @param	otherMedia	The other media to compare to.
	 * @return	The String comparison of the Media's titles.
	 */
	public int compareTo(Media otherMedia) {	
		return this.title.compareTo(otherMedia.getTitle());	
	}
	
	static class YearComparator implements Comparator<Media>{

		/**
		 * @param	med1	The first media to be compared
		 * @param	med2	The second media to be compared
		 * @return	The int comparison of the Medias' years
		 */
		public int compare(Media med1, Media med2) {
			
			try{ // turn year into int, then compare the ints
				return Integer.compare(Integer.parseInt(med1.getYear().substring(0,4)), Integer.parseInt(med2.getYear().substring(0, 4)));
			}
			catch(NumberFormatException e){ // i.e., one Media's year == "????"
				if(med1.getYear().contains("?"))
					return 1;
				else if(med2.getYear().contains("?"))
					return -1;
				else 
					return 0;
			}
			
		}

	}


}
