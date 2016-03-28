import java.io.Serializable;
import java.util.ArrayList;


/**
 * Project #3
 * CS 2334, Section 010
 * Mar 28, 2016
 * <P>
 * A simple object to represent a person who makes media, including
 * actors, directors, and producers.
 * </P>
 * @version 1.0
 */
public class MediaPerson implements Serializable{

	private static final long serialVersionUID = -5852249412583906111L;

	private String name;
	
	private String profession;
	
	private ArrayList<String> works;
	
	private int moviesActed= 0, moviesDirected= 0, moviesProduced= 0, seriesActed= 0, seriesDirected= 0, seriesProduced = 0;
	
	/**
	 * Constructs a new instance of MediaPerson.
	 * @param name	The name to give the MediaPerson
	 * @param profession	The job(s) of the MediaPerson
	 */
	MediaPerson(String name, String profession){
		this.name = name;
		this.profession = profession;
		works = new ArrayList<String>();
	}
	/**
	 * @return This MediaPerson's name
	 */
	public String getName(){
		return name;
	}
	/**
	 * @param name The new name to give this MediaPerson
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * @return This MediaPerson's profession(s)
	 */
	public String getProfession(){
		return profession;
	}
	
	/**
	 * @param profession The new profession(s) to give this MediaPerson
	 */
	public void setProfession(String profession){
		this.profession = profession;
	}
	
	/**
	 * @return The ArrayList containing this MediaPerson's works
	 */
	public ArrayList<String> getWorks(){
		return works;
	}
	
	/**
	 * Adds a work to that the MediaPerson created/participated in.
	 * Also tallies the number of works and what role the person has.
	 */
	public void addWork(String work, String typeOfWork, String role){	
		
		//sw1 is the label to switch out of the inner switch statement
		sw1:switch(typeOfWork){
		case "movie":
			switch(role){
			case "ACTING": moviesActed++; break sw1;
			case "DIRECTING": moviesDirected++; break sw1;
			case "PRODUCING": moviesProduced++; break sw1;
			default: System.out.println("ERROR: check MediaPerson method addWork() and ensure you use correct formatting."); break;
			}
		case "series":
			switch(role){
			case "ACTING": seriesActed++; break sw1;
			case "DIRECTING": seriesDirected++; break sw1;
			case "PRODUCING": seriesProduced++; break sw1;
			default: System.out.println("ERROR: check MediaPerson method addWork() and ensure you use correct formatting."); break;
			}
		}
			
		works.add(work);
	}
	
	/**
	 * Adds a "divider" String into the works ArrayList to separate works based on role the person played (act, direct, produce)
	 * for simpler output and use.
	 * @param role The role to use as the divider in the works ArrayList<String>.
	 */
	public void addWorkDivider(String role){
		works.add(role);
	}
	
	public int getNumMoviesActed(){
		return moviesActed;
	}
	
	public int getNumMoviesDirected(){
		return moviesDirected;
	}
	
	public int getNumMoviesProduced(){
		return moviesProduced;
	}
	
	public int getNumSeriesActed(){
		return seriesActed;
	}
	
	public int getNumSeriesDirected(){
		return seriesDirected;
	}
	
	public int getNumSeriesProduced(){
		return seriesProduced;
	}
	
	/**
	 * @return The String representing this MediaPerson's works, as per project specifications
	 */
	public String worksToString(){
		String output = "";
		
		for(int i=0; i<works.size(); i++){
			output += works.get(i) + "\n";
		}

		output += "--------------------------------------------------------------------------------";
		
		return output;
	}
	
	/**
	 * @return The String representing this MediaPerson, including works, as per project specifications
	 */
	public String toString(){
//TODO:
		return name + "\n" + worksToString() + "\n";
	}
	/**
	 * Finds all of this person's works created in a specific year, then counts up how many of each credit (acting, dir, producing) there are for that particular year.
	 * @param year
	 * @return AL<Integer> in following order: year, movies acted, movies directed, movies produced, series acted, series directed, series produced.
	 */
	ArrayList<Integer> getCredits(Integer year){
		Integer mAct=0, mDir=0, mProd=0, sAct=0, sDir=0, sProd=0;
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		returnList.add(year);
		
		for(String w: works){
			if(w.contains(year.toString())){
				if(w.contains("MOVIE:") || w.contains("MOVIE (")){ // is a movie
					if(works.indexOf(w) < works.indexOf("DIRECTOR"))
						mAct++;
					else if(works.indexOf(w) > works.indexOf("PRODUCER"))
						mProd++;
					else
						mDir++;
				}
				else{ // is a series
					if(works.indexOf(w) < works.indexOf("DIRECTOR"))
						sAct++;
					else if(works.indexOf(w) > works.indexOf("PRODUCER"))
						sProd++;
					else
						sDir++;
				}
			}
		}
		returnList.add(mAct);
		returnList.add(mDir);
		returnList.add(mProd);
		returnList.add(sAct);
		returnList.add(sDir);
		returnList.add(sProd);
		
		return returnList;
	}
}
