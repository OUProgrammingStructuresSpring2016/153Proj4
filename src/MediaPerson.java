import java.util.ArrayList;


public class MediaPerson{

	private String name;
	
	private String profession;
	
	private ArrayList<String> works;
	
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
	 */
	public void addWork(String work){
		works.add(work);
	}
	/**
	 * @return The String representing this MediaPerson's works, as per project specifications
	 */
	public String worksToString(){
		//TODO: Fix according to project standards
		return works.toString();
	}
	
	/**
	 * @return The String representing this MediaPerson, including works, as per project specifications
	 */
	public String toString(){
		//TODO: Fix according to project standards
		return name + " " + profession + " " + worksToString();
	}
	
}
