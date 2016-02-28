import java.util.Comparator;


public class Movie extends Media implements Comparator <String>{
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
		this.title = title;
		this.year = year;
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
		//TODO review this prints correctly
		return title + " (" + year + ") " + additionalInfo + " " + year;
 	}
	
}//end of class
