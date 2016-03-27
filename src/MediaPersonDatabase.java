import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

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
		for(Map.Entry<String, MediaPerson> entry: mpdb.entrySet()){
				if(entry.getKey().contains(name)){
					resultList.add(entry.getValue()); 
				}
		}
		
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
	
	public void inputBinaryFile(String fileName) throws IOException{
		byte[] buffer = new byte[1000];
        FileInputStream inputStream =  new FileInputStream(fileName);
        inputStream.read(buffer);
        inputStream.close();        
	}
	
	/**
	 * Outputs the result list into a binary file for use in loading future databases.
	 * @param filename The name to give the new binary file.
	 * @throws IOException 
	 */
	public void outputToBinaryFile(String fileName, String textToOutput) throws IOException{
		FileOutputStream filer = new FileOutputStream(fileName);
		ObjectOutputStream bw = new ObjectOutputStream(filer);
		bw.writeObject(textToOutput);
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
	public void resultListToString(){
		for(MediaPerson person: resultList){
			System.out.println(person.toString());
		}
	}
	

	

}
