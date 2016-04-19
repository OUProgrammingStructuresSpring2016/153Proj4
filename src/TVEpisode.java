/**
 * Project #3
 * CS 2334, Section 010
 * Mar 28, 2016
 * <P>
 * A simple object to represent an episode of a TV series, including
 * episode name, episode number, and the year the episode was aired.
 * </P>
 * @version 1.0
 */
public class TVEpisode implements Comparable<TVEpisode>{
	
	/** Stores the name of the episode. */
	private String episodeName;
	
	/** Stores the season and episode number of the episode. */
	private String seasonAndEpisodeNums;
	
	/** Stores the year that the episode aired on. */
	private String yearAired;
	
	private String tvSeriesName;
	
	/**
	 * @param epName		The name of the episode
	 * @param seasonNums	The season/episode numbers
	 * @param year			The release year of the episode
	 * @param tvSeriesName	The name of the TV series to which this episode belongs
	 */
	public TVEpisode(String epName, String seasonNums, String year, String tvSeriesName){
		this.episodeName= epName;
		this.seasonAndEpisodeNums = seasonNums;
		this.yearAired= year;
		this.tvSeriesName = tvSeriesName;
	}
	
	/**
	 * @return	The name of the episode
	 */
	public String getEpisodeName(){	
		return this.episodeName;
	}
	
	/**
	 * @return	The year the TVEpisode was released
	 */
	public String getYearAired(){
		return this.yearAired;
	}
	
	/** toString method, because you'll never know when you need it */
	public String toString(){

			return  ("EPISODE: " + tvSeriesName + ": " + episodeName + " (" + yearAired + ")");
		
	}
	
	/**
	 * @param	ep	the TVEpisode object to be compared
	 * @return	The String comparison of the two episode titles
	 */
	public int compareTo(TVEpisode ep) {
		return episodeName.compareTo(ep.getEpisodeName());
	}
	
}
