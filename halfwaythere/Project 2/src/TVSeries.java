import java.util.ArrayList;

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
public class TVSeries extends Media{

	/** Stores the data for the running years of the show (e.g., "1990-2001") */
	private String runningYears;
	
	/** Stores the entirety of the TV series's episodes. */
	private ArrayList<TVEpisode> episodes;
	
	
	/** Constructs a new TVSeries given its title, release year, and its running years. */
	
	public TVSeries(String title, String year, String runningYears){
		super(title, year);
		this.runningYears = runningYears;
		this.episodes = new ArrayList<TVEpisode>();
	}
	
	/** Used to construct a series without TVEpisodes so that only TVEpisodes
	 *	that match a search are included. Used in line 149 of MediaDatabase, for
	 *	example. 
	 */
	public TVSeries(TVSeries e, boolean specialCase){
		super(e.getTitle(), e.getYear());
		this.runningYears = e.getRunningYears();
		this.episodes = new ArrayList<TVEpisode>();
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
	//	System.out.println(newEp); // test line.
	}
	
	
	public ArrayList<TVEpisode> searchForEpisodeTitlePartial(String title){
		
		ArrayList<TVEpisode> results = new ArrayList<TVEpisode>();
		
		for(int i=0; i<episodes.size(); i++){
			if(episodes.get(i).getEpisodeName().contains(title)){
				results.add(episodes.get(i));
			}	
		}
		
		return results;
		
	}
	
public ArrayList<TVEpisode> searchForEpisodeTitleExact(String title){
		
		ArrayList<TVEpisode> results = new ArrayList<TVEpisode>();
		
		for(int i=0; i<episodes.size(); i++){
			if(episodes.get(i).getEpisodeName().equals(title)){
				results.add(episodes.get(i));
			}	
		}
		
		
		return results;
		
	}

public ArrayList<TVEpisode> searchForEpisodeYear(String year){
	
	ArrayList<TVEpisode> results = new ArrayList<TVEpisode>();
	
	for(int i=0; i<episodes.size(); i++){
		if(episodes.get(i).getYearAired().contains(year)){
			results.add(episodes.get(i));
		}	
	}
	
	return results;
}
	
	/**
	 * @return     The TVSeries object, complete with episodes.
	 */
	public String toString(){
		
		String allEps = "";
		
		for(TVEpisode e : episodes){
			allEps += e.toString() + "\n";
		}
		
		allEps = allEps.trim();
		
		return "SERIES: " + title + " " + year + " " + runningYears + "\n" + allEps;
	}
	
}