<<<<<<< HEAD
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
=======
>>>>>>> a2d451c94836185cacd08487a4efc708c4c69b94
import java.util.ArrayList;
import java.util.List;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 19, 2016
 * <P>
 * Creates, searches, and saves searches of a media database containing
 * movies and TV series. 
 * </P>
 * @version 1.0
 */
public class MediaDatabase {
	
	/** The database to contain all of the media data. */
	public List<Media> database;
	
	/** The list to return with search results from the various search methods below. */
	private List<Movie> resultList = new ArrayList<Movie>();
	
	/** Constructs an empty database. */
	public MediaDatabase(){
		List<Media> database = new ArrayList<Media>();
	}
	/** The list to return with search results from the various search methods below. */
	List<TVSeries> list = new ArrayList<TVSeries>();
	
	/**
	 * @param	newMedia	The new media object to add to the database.
	 */
	public void addMedia(Media newMedia){
			database.add(newMedia);
	}
	
	/**
	 * Searches for all movies whose titles exactly match the given input token.
	 * @param	title	The exact token to search the movie database titles for.
	 * @return			The list of movies matching the exact token.
	 */
	public List<Movie> searchMovieTitleExact(String title){	
		for(int i = 0; i < database.size(); i++){
			if(database.get(i).getTitle().equals(title)){
				resultList.add((Movie) database.get(i));
			}
		}
		return resultList;
	}
	
	/**
	 * Searches for all movies whose titles contain the given input token.
	 * @param	title	The token to search the movie database titles for.
	 * @return			The list of movies containing the token.
	 */
	public List<Movie> searchMovieTitlePartial(String title){
		for(int i = 0; i < database.size(); i++){
			if(database.get(i).getTitle().contains(title)){
				resultList.add((Movie) database.get(i));
			}
		}
		return resultList;
	}
	
	/**
	 * Searches for all movies whose release years match the given input token.
	 * @param	year	The token to search the movie database years for.
	 * @return			The list of movies whose years match the input token.
	 */
	public List<Movie> searchMovieYear(String year){
		for(int i = 0; i < database.size(); i++){
			if(database.get(i).getYear().equals(year)){
				resultList.add((Movie) database.get(i));
			}
		}
		return resultList;
	}
	
	/**
	 * Searches for all movies whose titles and years match the given inputs.
	 * @param	title	The exact token to search the movie database for.
	 * @param	year	The token to search the movie database years for.
	 * @return			The list of movies matching both inputs.
	 */
	public List<Movie> searchMovieBoth(String title, String year){
		for(int i = 0; i < database.size(); i++){
			if(database.get(i).getTitle().equals(title)){
<<<<<<< HEAD
				if(database.get(i).getYear().equals(year)){
=======
				if(database.get(i).getYear().equals(title)){
>>>>>>> a2d451c94836185cacd08487a4efc708c4c69b94
					resultList.add((Movie) database.get(i));
				}
			}
		}
		return resultList;
	}
	
	/**
	 * Searches for all TV series (and possibly episode titles) whose titles exactly match the given input token.
	 * @param	title	The exact token to search the TV series database for.
	 * @param	includeEpTitles		Determines whether to include episode titles in the search.
	 * @return			The list of TV series matching the exact token.
	 */
	public List<TVSeries> searchTVTitleExact(String title, boolean includeEpTitles){
<<<<<<< HEAD
			for(int i = 0; i < database.size(); i++){
				if(database.get(i).getTitle().equals(title)){
					if(includeEpTitles){;
						list.add((TVSeries) database.get(i));
					}else{
						if(database.get(i).getEpisodeName().contains("{")){
							break;
						}
					}
				}
			}
=======
		List<TVSeries> list = new ArrayList<TVSeries>();
		
		if(includeEpTitles){
			for(int i = 0; i < database.size(); i++){
				if(database.get(i).getTitle().equals(title)){
					list.add((TVSeries) database.get(i));
				}
			}
		}else{
			for(int i = 0; i < database.size(); i++){
				if(database.get(i).getTitle().equals(title)){
					if((database.get(i)).getEpisodeName().contains("{")){
						list.add((TVSeries) database.get(i));
					}
				}
		}
>>>>>>> a2d451c94836185cacd08487a4efc708c4c69b94
	}
	
	/**
	 * Searches for all TV series (and possibly episode titles) whose titles contain the given input token.
	 * @param	title	The token to search the TV series database for.
	 * @param	includeEpTitles		Determines whether to include episode titles in the search.
	 * @return			The list of TV series containing the token.
	 */
	public List<TVSeries> searchTVTitlePartial(String title, boolean includeEpTitles){
		for(int i = 0; i < database.size(); i++){
			if(includeEpTitles){
				list.add((TVSeries) database.get(i));
			}else{
				if(database.get(i).getTitle().contains(title)){
				break;
				}
			}
		}
		return list;
	}

	/**
	 * Searches for all TV series whose release year matches the input.
	 * @param	title	The year to search the database for.
	 * @return			The list of TV series matching the input.
	 */
	public List<TVSeries> searchTVYear(String year){
		for(int i = 0; i < database.size(); i++){
			if(database.get(i).getTitle().contains(year)){
				list.add((TVSeries) database.get(i));
				}
			}
		return list;
	}
	/**
	 * Searches for all TV series (and possibly episode titles) whose titles exactly match the given input token.
	 * @param	title	The exact token to search the TV series database for.
	 * @param	includeEpTitles		Determines whether to include episode titles in the search.
	 * @return			The list of TV series matching the exact token.
	 */
	public List<TVSeries> searchTVBoth(String title, boolean includeEpTitles){
		for(int i = 0; i < database.size(); i++){
			if(database.get(i).getTitle().equals(title)){
				if(includeEpTitles){;
					list.add((TVSeries) database.get(i));
				}
			}
		}
		return list;
	}
	
	/**
	 * Writes the output of the search function to a text file, allowing
	 * the user to save searches for future reference.
	 * @param 	doSortByYear	Determines whether the list will be sorted by title or by year.
	 */
	public void outputToFile(boolean doSortByYear){
		if(doSortByYear){
			FileOutputStream fileOutputStream = new FileOutputStream("userFile.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(Media);
			objectOutputStream.close();
		}
		return;
	}
}
