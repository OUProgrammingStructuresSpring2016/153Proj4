import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project #2 CS 2334, Section 010 Feb 19, 2016
 * <P>
 * Creates, searches, and saves searches of a media database containing movies
 * and TV series.
 * </P>
 * 
 * @version 1.0
 */
public class MediaDatabase {

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
			System.out.println("Movie not found.");
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
		searchMovieYear(year);

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
		return resultList;
		}
	}

	/**
	 * Searches for all TV series whose release year matches the input.
	 * 
	 * @param title
	 *            The year to search the database for.
	 * @return The list of TV series matching the input.
	 */
	public List<Media> searchTVYear(String year) {
		for (int i = 0; i < tvDatabase.size(); i++) {
			if (tvDatabase.get(i).getYear().contains(year)) {
				resultList.add(tvDatabase.get(i));
			}
		}
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
	public List<Media> searchTVBoth(String title, String year, boolean includeEpTitles) {
		
		searchTVTitlePartial(title, includeEpTitles);
		searchTVYear(year);
		
		return resultList;
	}

	public void clearResultsList() {

		resultList = new ArrayList<Media>();

	}

	/**
	 * Writes the output of the search function to a text file, allowing the
	 * user to save searches for future reference.
	 * 
	 * @param doSortByYear
	 *            Determines whether the list will be sorted by title or by
	 *            year.
	 * @throws IOException 
	 */
	public void outputToFile(boolean doSortByYear) throws IOException {
		if (doSortByYear) {
			FileOutputStream fileOutputStream = new FileOutputStream(
					"userFile.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					fileOutputStream);
			objectOutputStream.writeObject(resultList);
			objectOutputStream.close();
		}
		return;
	}

	public void sortDatabase() {
		Collections.sort(movieDatabase);
		Collections.sort(tvDatabase);
	}
}