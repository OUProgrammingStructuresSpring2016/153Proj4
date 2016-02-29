import java.util.Comparator;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 19, 2016
 * <P>
 * Stores and allows access to data for a general, non-descript media object (e.g. movies and TV shows).
 * </P>
 * @version 1.0
 */


public class Media implements Comparator <String>{

	/** Stores the title of the media. */
	protected String title;
	
	/** Stores the year the media was released. */
	protected String year;
	
	/**
	 * Default constructor for the Media class. It sets "" for the title and year.
	 */
	public Media (){
		//Creating a default constructor helped remove an error from the subclasses
		//when passing different parameters to them.
		this.title = "";
		this.year = "";
	}
	
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
	 * 
	 * @param media1	 String for a title,year, or ad.Info of a Media object. This will be media from the list of media objects
	 * @param media2	 String for title,year of ad.Info This string will come from user provided info
	 * @return				 Returns a number based on the comparison of the strings
	 */
	public int compare(String media1,String media2) {
		//TODO  verify this compares correctly 
		if(compare(media1, media2) > 0){
			return 1;
		}
		if (compare(media1,media2) < 0){
			//no match
			return -1;
		}
		else{
			//if there is no match when comparing
			return 0;
		}
	
	}
	
	
}//end of method
