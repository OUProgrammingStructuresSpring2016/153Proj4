
/*
 * 
 * DISCLAIMER:
 * Most of this code was borrowed from my Project 1 
 * Movie Class and is being reused here in Project 2
 * as the same exact class. 
 * 
 */
public class Movie extends Media {

	//private data for movie class
	//made that year with same title
	private String romanNumeral;
	//format of the movie
	private String format;
	
	//constructor for the Movie Class
	public Movie(){
		
	}
	
	/**
	 * Sets the movie Name. Mutator method
	 * <P>
	 * Algorithm:<br>
	 * 1. Sets the name of the Movie to movieTitle. <br>
	 * </P>
	 * @param 	movieTitle		Name of the movie
	 */
	public void setMovieTitle(String movieTitle){
	}
	
	/**
	 * Sets the year it was released 
	 * along with Roman numeral indicating 
	 * if any other movie with the same year was made. Mutator method
	 * <P>
	 * Algorithm:<br>
	 * 1. Sets the year of the movie and Roman numeral. <br>
	 * 2. Sets to "????" if not present. <br>
	 * </P>
	 * @param 	RomanNumeral	The year released and Roman numeral.
	 */
	public void setRomanNumeral(String romanNumeral){
	}
	
	/**
	 * Sets the format that the movie was released in. Mutator method
	 * <P>
	 * Algorithm:<br>
	 * 1. Sets the format of the movie. <br>
	 * 2. Sets to "????" if not present. <br>
	 * </P>
	 * @param 	format	The format the movie was released in. 
	 */
	public void setFormat(String format){
	}
	
	/**
	 * Sets the year the movie was released. Mutator method
	 * <P>
	 * Algorithm:<br>
	 * 1. Sets the year of the movie. <br>
	 * 2. Sets to "????" if not present. <br>
	 * </P>
	 * @param 	yearReleased	Year movie was released in. 
	 */
	public void setYearReleased(String yearReleased){
	}
	
	
	/**
	 * Gets the movie title. Accessor method
	 * <P>
	 * Algorithm:<br>
	 * 1. Gets the title of the Movie. <br>
	 * </P>
	 * @return  String			The movie's title
	 */
	public String getMovieTitle(){
		return null;
	}
	
	/**
	 * Gets the year it was released 
	 * along with Roman numeral indicating 
	 * if any other movie with the same year was made. Accessor method
	 * <P>
	 * Algorithm:<br>
	 * 1. Gets the year released and Roman numeral.<br>
	 * </P>
	 * @return  String		Year released and Roman numeral.
	 */
	public String getRomanNumeral(){
		return null;
	}
	
	/**
	 * Gets the format of the movie. Accessor method
	 * <P>
	 * Algorithm:<br>
	 * 1. Gets the movie's format.<br>
	 * </P>
	 * @return  String		Format of the requested movie. 
	 */
	public String getFormat(){
		return null;
	}
	
	/**
	 * Gets year the movie was released. Accessor method
	 * <P>
	 * Algorithm:<br>
	 * 1. Gets the release year of the movie.<br>
	 * </P>
	 * @return  String		Year released. 
	 */
	public String getYearReleased(){
		return null;
		
	}

}

