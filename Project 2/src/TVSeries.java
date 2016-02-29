import java.util.ArrayList;
import java.util.Comparator;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 19, 2016
 * <P>
 * Stores and allows access to data for a TV series, 
 * including the series's episodes.
 * </P>
 * @version 1.0
 */
public class TVSeries extends Media implements Comparator <String>{

	/** Stores the data for the running years of the show (e.g., "1990-2001") */
	private String runningYears;
	
	/** Stores the entirety of the TV series's episodes. */
	private ArrayList<TVEpisode> episodes;
	
	
	/** Constructs a new TVSeries given its title, release year, and its running years. */
	
	public TVSeries(String title, String year, String runningYears){
		this.title = title;
		this.year = year;
		this.runningYears = runningYears;
	}
	
	/**
	 * @return 	The String containing the information for the series' running years.
	 */
	public String getRunningYears(){
		return runningYears;
	}
	
	/**
	 * @return 	The ArrayList of all the episodes in the series.
	 */
	public ArrayList<TVEpisode> getEpisodes(){
		return episodes;
	}
	
	/**
	 * Sets the running years as the given String.
	 * @param newYears
	 */
	public void setRunningYears(String newYears){
		this.runningYears = newYears;
	}
	
	/**
	 * @param newEp The episode to add to the TV series list.
	 */
	public void addEpisode(TVEpisode newEp){
		episodes.add(newEp);
	}
	
	/**
	 * @return     gives a string of the title, year, and running years of the series
	 */
	public String toString(){
		return title + " " + year + " " + runningYears;
	}
	
}
