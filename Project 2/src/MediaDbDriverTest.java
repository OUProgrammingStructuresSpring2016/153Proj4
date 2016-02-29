import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class MediaDbDriverTest extends TestCase {

	public void testSearchFunction1() {
		MediaDatabase db = new MediaDatabase();
		List<Movie> test1 = db.searchMovieTitleExact("Test Title");
		List<Media> test1Check = new ArrayList<Media>();
		test1Check.add(new Movie("Test Title", null, null));
		assertEquals(test1.toString(), test1Check.toString());
	}

	public void testSearchFunction2() {
		MediaDatabase db = new MediaDatabase();
		List<Movie> test1 = db.searchMovieTitlePartial("Test Title");
		List<Movie> test1Check = new ArrayList<Movie>();
		test1Check.add(new Movie("Test Title", null, null));
		assertEquals(test1.toString(), test1Check.toString());
	}

	public void testSearchFunction3() {
		MediaDatabase db = new MediaDatabase();
		List<Movie> test1 = db.searchMovieYear("1990");
		List<Movie> test1Check = new ArrayList<Movie>();
		test1Check.add(new Movie("Test Title", null, null));
		assertEquals(test1.toString(), test1Check.toString());
	}
	
	public void testSearchFunction4(){
		MediaDatabase db = new MediaDatabase();
		List<Movie> test1 = db.searchMovieBoth("Test Title", "1990");
		List<Movie> test1Check = new ArrayList<Movie>();
		test1Check.add(new Movie("Test Title", null, null));
		assertEquals(test1.toString(), test1Check.toString() );
		}
	
	public void testSearchFunction5(){
		MediaDatabase db = new MediaDatabase();
		List<TVSeries> test1 = db.searchTVTitleExact("Test Title", false);
		List<TVSeries> test1Check = new ArrayList<TVSeries>();
		test1Check.add(new TVSeries("Test Title", null, null));
		assertEquals(test1.toString(), test1Check.toString() );
		}
	
	public void testSearchFunction6(){
		MediaDatabase db = new MediaDatabase();
		List<TVSeries> test1 = db.searchTVTitlePartial("Test Title", false);
		List<TVSeries> test1Check = new ArrayList<TVSeries>();
		test1Check.add(new TVSeries("Test Title", null, null));
		assertEquals(test1.toString(), test1Check.toString() );
		}
	
	public void testSearchFunction7(){
		MediaDatabase db = new MediaDatabase();
		List<TVSeries> test1 = db.searchTVBoth("Test Title", false);
		List<TVSeries> test1Check = new ArrayList<TVSeries>();
		test1Check.add(new TVSeries("Test Title", null, null));
		assertEquals(test1.toString(), test1Check.toString() );
		}
	
	
}
