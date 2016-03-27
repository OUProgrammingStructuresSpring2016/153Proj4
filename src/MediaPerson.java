import java.util.ArrayList;


public class MediaPerson{

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
			case "actor": moviesActed++; break sw1;
			case "director": moviesDirected++; break sw1;
			case "producer": moviesProduced++; break sw1;
			default: System.out.println("ERROR: check MediaPerson method addWork() and ensure you use correct formatting."); break;
			}
		case "series":
			switch(role){
			case "actor": seriesActed++; break sw1;
			case "director": seriesDirected++; break sw1;
			case "producer": seriesProduced++; break sw1;
			default: System.out.println("ERROR: check MediaPerson method addWork() and ensure you use correct formatting."); break;
			}
		}
			
		works.add(work);
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

		return name + "\n" + worksToString();
	}
	
}
