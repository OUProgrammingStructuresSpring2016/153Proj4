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
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Project #3 CS 2334, Section 010 Mar 28, 2016
 * <P>
 * Creates, searches, and saves searches of a media database containing movies
 * and TV series.
 * </P>
 * 
 * @version 1.0
 */
public class MediaDatabase implements Serializable{

	private static final long serialVersionUID = 3927560263599205482L;

	/** The database to contain all of the Movie data. */
	public List<Movie> movieDatabase;

	/** The database to contain all of the TV data. */
	public List<TVSeries> tvDatabase;

	/**
	 * The list to return with search results from the various search methods
	 * below.
	 */
	private List<Media> resultList = new ArrayList<Media>();

	/** Constructs an empty database. */
	public MediaDatabase() {
		movieDatabase = new ArrayList<Movie>();
		tvDatabase = new ArrayList<TVSeries>();
	}
	
	/**
	 * Constructs a MediaDatabase from an existing binary file.
	 * @param filename The name of the binary file to be loaded.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public MediaDatabase(String filename) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);
		movieDatabase = (List<Movie>) ois.readObject();
		ois.close();
	}

	/**
	 * @param newMedia
	 *            The new media object to add to the database.
	 */
	public void addMedia(Media newMedia) {

		if (newMedia instanceof Movie) {
			movieDatabase.add((Movie) newMedia);
		} else { // instance of TVSeries
			tvDatabase.add((TVSeries) newMedia);
		}

	}

	/**
	 * Searches for one movie whose title exactly matches the given input token.
	 * 
	 * @param title
	 *            The exact token to search the movie database titles for.
	 * @return The list of movies matching the exact token.
	 */
	public List<Media> searchMovieTitleExact(String title) {

		int indexOfMovie = Collections.binarySearch(movieDatabase, new Movie(
				title, "", ""));

		if (indexOfMovie < 0) {
			return resultList;
		}

		resultList.add(movieDatabase.get(indexOfMovie));
		return resultList;

	}

	/**
	 * Searches for all movies whose titles contain the given input token.
	 * 
	 * @param title
	 *            The token to search the movie database titles for.
	 * @return The list of movies containing the token.
	 */
	public List<Media> searchMovieTitlePartial(String title) {
		for (int i = 0; i < movieDatabase.size(); i++) {
			if (movieDatabase.get(i).getTitle().contains(title)) {
				resultList.add(movieDatabase.get(i));
			}
		}
		if(resultList.isEmpty())
			System.out.println("No matches found.");
		
		return resultList;
	}

	/**
	 * Searches for all movies whose release years match the given input token.
	 * 
	 * @param year
	 *            The token to search the movie database years for.
	 * @return The list of movies whose years match the input token.
	 */
	public List<Media> searchMovieYear(String year) {
		for (int i = 0; i < movieDatabase.size(); i++) {
			if (movieDatabase.get(i).getYear().contains(year)) {
				resultList.add(movieDatabase.get(i));
			}
		}
		return resultList;
	}

	/**
	 * Searches for all movies whose titles and years match the given inputs.
	 * 
	 * @param title
	 *            The exact token to search the movie database for.
	 * @param year
	 *            The token to search the movie database years for.
	 * @return The list of movies matching both inputs.
	 */
	public List<Media> searchMovieBoth(String title, String year) {

		searchMovieTitlePartial(title);
		
		for(int g=0; g<movieDatabase.size(); g++){
			if(!movieDatabase.get(g).getYear().contains(year))
				resultList.remove(movieDatabase.get(g));
		}
		
		if(resultList.isEmpty())
			System.out.println("No matches found.");
		
		return resultList;
	}

	/**
	 * Searches for all TV series (and possibly episode titles) whose titles
	 * exactly match the given input token.
	 * 
	 * @param title
	 *            The exact token to search the TV series database for.
	 * @param includeEpTitles
	 *            Determines whether to include episode titles in the search.
	 * @return The list of TV series matching the exact token.
	 */
	public List<Media> searchTVTitleExact(String title, boolean includeEpTitles) {

		if (!includeEpTitles) { // if we do not include episode titles in search
			int indexOfSeries = Collections.binarySearch(tvDatabase,
					new TVSeries(title, "", ""));
			if (indexOfSeries >= 0) {
				resultList.add(tvDatabase.get(indexOfSeries));
				return resultList;
			} else {
				System.out.println("No TV series found.");
				return resultList;
			}
		} else { // include Episode titles in the search
			for (TVSeries e : tvDatabase) { // searches all episode titles
				if (!e.searchForEpisodeTitleExact(title).isEmpty()) {
					TVSeries tempSeries = new TVSeries(e, true);
					tempSeries.addEpisode(e.searchForEpisodeTitleExact(title)
							.get(0)); // Since there should only be one matching
					resultList.add(tempSeries);
					return resultList;
				}
				else{
					System.out.println("No matches found.");
					return resultList;
				}
			}
			// if no matching episode titles, then search series titles instead
			int indexOfSeries = Collections.binarySearch(tvDatabase,
					new TVSeries(title, "", ""));
			if (indexOfSeries >= 0) {
				resultList.add(tvDatabase.get(indexOfSeries));
				return resultList;
			}

		}

		return resultList;

	}

	/**
	 * Searches for all TV series (and possibly episode titles) whose titles
	 * contain the given input token.
	 * 
	 * @param title
	 *            The token to search the TV series database for.
	 * @param includeEpTitles
	 *            Determines whether to include episode titles in the search.
	 * @return The list of TV series containing the token.
	 */
	public List<Media> searchTVTitlePartial(String title,
			boolean includeEpTitles) {

		if (!includeEpTitles) { // not including episode titles in the search
			for (TVSeries o : tvDatabase) {
				if (o.getTitle().contains(title)) {
					resultList.add(o);
				}
			}
			if(resultList.isEmpty())
				System.out.println("No matches found.");
			
			return resultList;
		}
		else { // including episode titles
			for (TVSeries o : tvDatabase) {

				if (o.getTitle().contains(title)) { // adds all series if series title matches
					resultList.add(o);
				}
				else{ // else we have to search all the episode titles and exclude non-matches
				
					ArrayList<TVEpisode> matches = o.searchForEpisodeTitlePartial(title);

					if (!matches.isEmpty()) { 									// adds all episodes containing
						TVSeries tempSeries = new TVSeries(o, true); 			// matches to a new, initially
						for (int count = 0; count < matches.size(); count++) 	// empty TVSeries of the same name
							tempSeries.addEpisode(matches.get(count));			// as the original
					}
				}
			}
			if(resultList.isEmpty())
				System.out.println("No matches found.");
		return resultList;
		}
	}

	/**
	 * Searches for all TV series whose release year matches the input.
	 * 
	 * @param year	The year to search the database for.
	 * @return The list of TV series matching the input.
	 */
	public List<Media> searchTVYear(String year) {
		
		if(year.length()>4){
			searchMultiYear(year);
		}
		
		else{
			
		for (int i = 0; i < tvDatabase.size(); i++) {
			
			if (tvDatabase.get(i).getYear().contains(year) || (tvDatabase.get(i).getYear().substring(0,4).compareTo(year) < 0 && tvDatabase.get(i).getYear().substring(5, tvDatabase.get(i).getYear().length()).compareTo(year) > 0) ) { // if series aired during given year, add whole series
				resultList.add(tvDatabase.get(i));
			}
			else{ // otherwise, search each episode in the current series for matching year
				ArrayList<TVEpisode> matches = new ArrayList<TVEpisode>();
				matches = tvDatabase.get(i).searchForEpisodeYear(year); // searches all episode titles
					if (!matches.isEmpty()) {
						TVSeries tempSeries = new TVSeries(tvDatabase.get(i), true);
						for(int l=0; l<matches.size(); l++){ // add all matching
						tempSeries.addEpisode(matches.get(l));	
						}
						resultList.add(tempSeries);
						return resultList;
					}
				
				}
		}
		}
		return resultList;
		
	}

	/**
	 * Searches for all TV series (and possibly episode titles) whose titles
	 * exactly match the given input token.
	 * 
	 * @param title The exact token to search the TV series database for.
	 * @param year	The token representing the year to search for.
	 * @param partialOrExact	Whether to include partial matches or only exact matches.
	 * @param includeEpTitles Determines whether to include episode titles in the search.
	 * @return The list of TV series matching the exact token.
	 */
	public List<Media> searchTVBoth(String title, String year, String partialOrExact, boolean includeEpTitles) {
		
		searchTVYear(year);
		
		List<Media> titleMatchList = new ArrayList<Media>();
		
		for(int x=0; x<resultList.size(); x++){
			titleMatchList.add(new TVSeries((TVSeries) resultList.get(x)));
		}
		
		clearResultsList();

		
		if(partialOrExact.equals("p"))
			searchTVTitlePartial(title, includeEpTitles);
		else
			searchTVTitleExact(title, includeEpTitles);
		
		return resultList;
	}

	/**
	 * Clears the resultList ArrayList for reuse.
	 */
	public void clearResultsList() {

		resultList = new ArrayList<Media>();

	}
	
	/**
	 * @return	The contents of the resultList ArrayList as per project standards.
	 */
	public String resultListToString(){
		
		String output = "";
		
		for(int q=0; q<resultList.size(); q++){
			output += resultList.get(q) + "\n";
		}
		
		return output;
		
	}

	/**
	 * Writes the output of the search function to a text file, allowing the
	 * user to save searches for future reference.
	 * 
	 * @param doSortByYear Determines whether the list will be sorted by title or by year.
	 * @param fileName	The name of the new file to be written.
	 * @param textToOutput	The contents that should be written to the new text file.
	 * @throws IOException If File not found.
	 */
	public void outputToFile(boolean doSortByYear, String fileName, String textToOutput) throws IOException {
		
		FileWriter filer = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(filer);
		
		if (doSortByYear) {
			Media.YearComparator comp = new Media.YearComparator();
			resultList.sort(comp);
		}
		// no else statement needed, already sorted by title
		bw.write(textToOutput);
		bw.write("\n");
		bw.write(resultListToString() );
		bw.close();
		
		return;
	}
	
	/**
	 * Sorts the database (Movie and TVSeries ArrayLists) based on title.
	 */
	public void sortDatabase() {
		Collections.sort(movieDatabase);
		Collections.sort(tvDatabase);
	}
	
	/**
	 * Sorts the database (Movie and TVSeries ArrayLists) based on title.
	 */
	public void sortResultsByYear(){
		Collections.sort(resultList, new Media.YearComparator());
	}
	
	/**
	 * Outputs a search result from resultList into a binary file. (Note: not for importing database, but for importing search results.)
	 * @param filename The name to give the new binary file.
	 * @throws IOException
	 */
	public void outputToBinaryFile(String filename) throws IOException{
		FileOutputStream filer = new FileOutputStream(filename);
		ObjectOutputStream bw = new ObjectOutputStream(filer);
		bw.writeObject(resultList);
		bw.close();
	}
	
	/**
	 * Searches for media items when given multiple years to search through
	 * 
	 * @param year User given year to search for 
	 * @return list of results for multi year search.
	 */
		public List<Media> searchMultiYear(String year){
		
			
				for (int i = 0; i < tvDatabase.size(); i++) {
					if (year.contains("-") == true){
							String [] splitLine = year.split("-");
							int  year1 = Integer.parseInt(splitLine[0]); 
							int year2 = Integer.parseInt( splitLine[1]);
						
							int givenYear =(Integer.parseInt(tvDatabase.get(i).getYear().substring(1, 5)));
							
						if ((givenYear >= year1 && givenYear <= year2) || (givenYear <= year1  && givenYear>= year2) )   { // if series aired during given year, add whole series
								resultList.add(tvDatabase.get(i));
							}
							
					}
			
					else if( year.contains(",") == true){
					 String []splitComma = year.split(",");
			for( int count  = 0; splitComma.length > count; count++){
						
					if(	tvDatabase.get(i).getYear().contains(splitComma[count]) || (tvDatabase.get(i).getYear().substring(0,4).compareTo(splitComma[count]) < 0 && tvDatabase.get(i).getYear().substring(5, tvDatabase.get(i).getYear().length()).compareTo(splitComma[count]) > 0)) {//||tvDatabase.get(i).getYear().contains(year2) || (tvDatabase.get(i).getYear().substring(0,4).compareTo(year2) < 0 && tvDatabase.get(i).getYear().substring(5, tvDatabase.get(i).getYear().length()).compareTo(year2) > 0)){
							resultList.add(tvDatabase.get(i));
						}
						
						else{ // otherwise, search each episode in the current series for matching year
							ArrayList<TVEpisode> matches = new ArrayList<TVEpisode>();
							matches = tvDatabase.get(i).searchForEpisodeYear(year); // searches all episode titles
								if (!matches.isEmpty()) {
									TVSeries tempSeries = new TVSeries(tvDatabase.get(i), true);
									for(int l=0; l<matches.size(); l++){ // add all matching
									tempSeries.addEpisode(matches.get(l));	
									}
									resultList.add(tempSeries);
									return resultList;
								}
							
							}
					}
					}
			
				} 
			return resultList;
	   }//end of searchMultiYear
}