/**
 * Project #3
 * CS 2334, Section 010
 * Mar 28, 2016
 * <P>
 * A simple object to represent a movie, including release year,
 * title, and any additional info (i.e., TV movie, etc.).
 * </P>
 * @version 1.0
 */
public class Movie extends Media{
	/** Stores data for a movie's additional info*/
	private String additionalInfo;
	
/**
 * Creates a movie object with a title, string, and the additional info
 * 
 * @param title		title of the movie
 * @param year		year the movie was released
 * @param additionalInfo		additional info of for the movie
 */
	public Movie(String title, String year, String additionalInfo){
		super(title, year);
		this.additionalInfo = additionalInfo;
	}
	
	/**
	 * 
	 * @return    returns the additional info of the movie
	 */
	public String getInfo(){
		return additionalInfo;
	}
	
	/**
	 * 
	 * @param additionalInfo   sets the additional info of the object to the  whole class's additionalInfo
	 */
	public void setInfo(String additionalInfo){
		this.additionalInfo = additionalInfo;
	}
	
	/**
	 * returns a string of the   title, year, and additional info, ending with the year again
	 */
	public String toString(){
		return "MOVIE: " + title +" " + "(" + year + ")";
 	}

	
}//end of class