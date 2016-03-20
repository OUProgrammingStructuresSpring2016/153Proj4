import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class MediaPersonDatabase implements Serializable{

	private LinkedHashMap<String, MediaPerson> mpdb;// = new LinkedHashMap<String, MediaPerson>();
	
	private ArrayList<MediaPerson> resultList;
	
	/**
	 * Constructs a new, empty MediaPersonDatabase.
	 */
	public MediaPersonDatabase(){
		
	}
	/**
	 * Constructs a MediaPersonDatabase based upon a binary file.
	 * @param filename The file name of the binary file to be used
	 */
	public MediaPersonDatabase(String filename){
		
	}
	
	/**
	 * Adds a MediaPerson to the database.
	 * @param p The new MediaPerson to add to the database.
	 */
	public void addPerson(MediaPerson p){
		
	}
	
	/**
	 * Searches the LinkedHashMap of MediaPerson(s) linearly to find all names containing the given token.
	 * @param name The partial name to search the database for.
	 * @return All MediaPerson(s) whose name contains the given token.
	 */
	public ArrayList<MediaPerson> searchPartial(String name){
		
	}
	
	/**
	 * Finds the MediaPerson whose name exactly matches the given token.
	 * @param name The token to use to search the LinkedHashMap as a key for.
	 * @return All MediaPerson(s) whose name matches the given token.
	 */
	public ArrayList<MediaPerson> searchExact(String name){
		
	}
	
	/**
	 * Outputs the result list into a text file with the given file name.
	 * @param filename The name to give the new text file.
	 */
	public void outputToTextFile(String filename){
		
	}
	
	/**
	 * Outputs the result list into a binary file for use in loading future databases.
	 * @param filename The name to give the new binary file.
	 */
	public void outputToBinaryFile(String filename){
		
	}
	/**
	 * Clears the resultList for a fresh use.
	 */
	public void clearResultsList(){
		
	}
	
	/**
	 * @return The properly formatted String of MediaPerson(s), as outlined in project guidelines.
	 */
	public String resultListToString(){
		
	}
	
	public inputBinaryFile(String fileName){
		
	}
	

}
