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
public class TVEpisode implements Comparable<TVEpisode>{
	
	/** Stores the name of the episode. */
	private String episodeName;
	
	/** Stores the season and episode number of the episode. */
	private String seasonAndEpisodeNums;
	
	/** Stores the year that the episode aired on. */
	private String yearAired;
	
	/** Stores name of the TV series. */
	private String tvSeriesName;
	
	/** Constructs a new TV episode object given all of the necessary information. 
	 * 
	 * @param epName Name of the episode.
	 * @param seasonNums The season of the episode.
	 * @param year  The year the episode aired.
	 * @param tvSeriesName The TV series that the episode is a part of. 
	 * 
	 * */
	public TVEpisode(String epName, String seasonNums, String year, String tvSeriesName){
		this.episodeName= epName;
		this.seasonAndEpisodeNums = seasonNums;
		this.yearAired= year;
		this.tvSeriesName = tvSeriesName;
	}
	
	/**
	 * @return Gives the episode name.
	 */
	public String getEpisodeName(){	
		return this.episodeName;
	}
	
	/**
	 * @return Gives the year the episode aired.
	 */
	public String getYearAired(){
		return this.yearAired;
	}
	
	/** 
	 * @return The episode information as a string. 
	 * */
	public String toString(){
		//if(!seasonAndEpisodeNums.isEmpty())
			return  ("EPISODE: " + tvSeriesName + ": " + episodeName + " (" + yearAired + ")");
		
		//return  episodeName + " " + yearAired;
	}

/**
 * @return compares episode names.
 */
	public int compareTo(TVEpisode arg0) {
		return episodeName.compareTo(arg0.getEpisodeName());
	}
	
}
