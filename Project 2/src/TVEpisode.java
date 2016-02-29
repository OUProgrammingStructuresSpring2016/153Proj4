import java.util.Comparator;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 19, 2016
 * <P>
 * A simple object to represent an episode of a TV series, including
 * episode name, episode number, and the year the episode was aired.
 * </P>
 * @version 1.0
 */
public class TVEpisode implements Comparator <String>{
	
	/** Stores the name of the episode. */
	private String episodeName;
	
	/** Stores the season and episode number of the episode. */
	private String seasonAndEpisodeNums;
	
	/** Stores the year that the episode aired on. */
	private String yearAired;
	
	/** Constructs a new TV episode object given all of the necessary information. */
	public TVEpisode(String epName, String seasonNums, String year){
		this.episodeName= epName;
		this.seasonAndEpisodeNums = seasonNums;
		this.yearAired= year;
	}
	
	/** toString method, because you'll never know when you need it */
	public String toString(){
		//TODO verify this prints correctly
		return episodeName +" ("+yearAired + ") " + seasonAndEpisodeNums + " "+ yearAired;
	}
	
/**
 * Compares a string from the episode (name, year aired, or season and episode Name)  on the list
 * with a name,year, or Season  & name  provided by user input
 * @return gives a number based on  comparing both 
 */
	public int compare(String tvEp1, String tvEp2) {
		if(compare(tvEp1,tvEp2) > 0 ){
		 //If  object we are comparing is greater than the object on the list
			return 1;
		}
		if (compare(tvEp1,tvEp2) < 0){
			//there was no match 
			return -1;
		}
		else{
			//if both objects are the same
			return 0; 
		}
	}
	

}


