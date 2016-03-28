import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project #3
 * CS 2334, Section 010
 * Mar 28, 2016
 * <P>
 * An object to represent a collection of MediaPeople, along with their works, that is
 * searchable, saveable, and loadable.
 * </P>
 * @version 1.0
 */
public class MediaPersonDatabase implements Serializable{


	private static final long serialVersionUID = 6316954717315158340L;
	
	private LinkedHashMap<String, MediaPerson> mpdb;
	private ArrayList<MediaPerson> resultList;
	
	/**
	 * Constructs a new, empty MediaPersonDatabase.
	 */
	public MediaPersonDatabase(){
		mpdb = new LinkedHashMap<String, MediaPerson>();
	}
	
	/**
	 * Constructs a MediaPersonDatabase based upon a binary file.
	 * This is what will be used when loading a file to construct a new database.
	 * @param filename The file name of the binary file to be used
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public MediaPersonDatabase(String filename) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);
		mpdb = (LinkedHashMap<String, MediaPerson>) ois.readObject();
		ois.close();
	}
	
	/**
	 * Adds a MediaPerson to the database.
	 * @param p The new MediaPerson to add to the database.
	 */
	public void addPerson(MediaPerson p){
		mpdb.put(p.getName() ,p);
	}
	
	/**
	 * Searches the LinkedHashMap of MediaPerson(s) linearly to find all names containing the given token.
	 * @param name The partial name to search the database for.
	 * @return All MediaPerson(s) whose name contains the given token.
	 */
	public ArrayList<MediaPerson> searchPartial(String name){
		resultList = new ArrayList<MediaPerson>();
		for(Map.Entry<String, MediaPerson> entry: mpdb.entrySet()){
				if(entry.getKey().contains(name)){
					MediaPerson person = new MediaPerson(name, entry.getValue().toString()); 
					resultList.add(person);
							
				}
		}
		resultList.toString();
		
		if(resultList.isEmpty())
			System.out.println("No matches found.");
		
		return resultList;
	}
	
	/**
	 * Finds the MediaPerson whose name exactly matches the given token.
	 * @param name The token to use to search the LinkedHashMap as a key for.
	 * @return All MediaPerson(s) whose name matches the given token.
	 */
	public MediaPerson searchExact(String name){
		resultList = new ArrayList<MediaPerson>();
		for(Map.Entry<String, MediaPerson> entry: mpdb.entrySet()){
			if(entry.getKey().equals(name)){
				//resultList.add(entry.getValue()); 
				return entry.getValue();
			}
		}
		
/*		if(resultList.isEmpty())
			System.out.println("No matches found.");
		
		return resultList;
		*/
		return null;
	}
	
	/**
	 * 
	 * @param fileName The name of the binary file containing `~SEARCH RESULTS~` to be read in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	public void inputBinaryFile(String fileName) throws IOException, ClassNotFoundException{

        FileInputStream inputStream =  new FileInputStream(fileName);
        ObjectInputStream objInput = new ObjectInputStream(inputStream);
        resultList = (ArrayList<MediaPerson>) objInput.readObject();
        inputStream.close();        
	}
	
	/**
	 * Outputs the result list into a binary file for use in loading future databases.
	 * @param filename The name to give the new binary file.
	 * @throws IOException 
	 */
	public void outputToBinaryFile(String fileName) throws IOException{
		FileOutputStream filer = new FileOutputStream(fileName);
		ObjectOutputStream bw = new ObjectOutputStream(filer);
		bw.writeObject(resultList);
		bw.close();
	}
	
	/**
	 * Outputs the result list into a text file with the given file name.
	 * @param filename The name to give the new text file.
	 * @throws IOException 
	 */
	public static void outputToTextFile(String fileName, String textToOutput) throws IOException{
		FileWriter filer = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(filer);
		bw.write(textToOutput);
		bw.close();
	}

	/**
	 * Clears the resultList for a fresh use.
	 */
	public void clearResultsList(){
		resultList.clear();
	}
	
	/**
	 * @return The properly formatted String of MediaPerson(s), as outlined in project guidelines.
	 */
	public String resultListToString(){
		String result = "";
		for(MediaPerson person: resultList){
			result += person.toString();
		}
		return result;
	}
	

	

}
