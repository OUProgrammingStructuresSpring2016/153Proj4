import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class MediaDbDriverTest extends TestCase {

	public void testSearchFunction1(){
		MediaDatabase db = new MediaDatabase();
		db.addMedia(new Movie("Test Title", "1990", null));
		ArrayList<Media> test1 = db.searchMovieTitleExact("Test Title");
		ArrayList<Media> test1Check = new ArrayList<Media>();
		test1Check.add(new Movie("Test Title", "1990", null));
		assertEquals(test1.toString(), test1Check.toString());
	}

	public void testSearchFunction2() {
		MediaDatabase db = new MediaDatabase();
		db.addMedia(new Movie("Test Title", "1990", null));
		db.addMedia(new Movie("Test", "1969", null));
		ArrayList<Media> test1 = db.searchMovieTitlePartial("Test");
		ArrayList<Media> test1Check = new ArrayList<Media>();
		test1Check.add(new Movie("Test Title", "1990", null));
		test1Check.add(new Movie("Test", "1969", null));
		assertEquals(test1.toString(), test1Check.toString());
	}

	public void testSearchFunction3() {
		MediaDatabase db = new MediaDatabase();
		db.addMedia(new Movie("null", "1990", null));
		List<Media> test1 = db.searchMovieYear("1990");
		List<Movie> test1Check = new ArrayList<Movie>();
		test1Check.add(new Movie(null,"1990", null));
		assertEquals(test1.toString(), test1Check.toString());
	}
	
	public void testSearchFunction4(){
		MediaDatabase db = new MediaDatabase();
		db.addMedia(new Movie("Test Title", "1990", null));
		List<Media> test1 = db.searchMovieBoth("Test Title", "1990");
		List<Movie> test1Check = new ArrayList<Movie>();
		test1Check.add(new Movie("Test Title", "1990", null));
		assertEquals(test1.toString(), test1Check.toString() );
		}
	
	public void testSearchFunction5(){
		MediaDatabase db = new MediaDatabase();
		db.addMedia(new TVSeries("Title", "1996", null));
		List<Media> test1 = db.searchTVTitleExact("Title", false);
		List<TVSeries> test1Check = new ArrayList<TVSeries>();
		test1Check.add(new TVSeries("Title", "1996", null));
		assertEquals(test1.toString(), test1Check.toString() );
		}
	
	public void testSearchFunction6(){
		MediaDatabase db = new MediaDatabase();
		db.addMedia(new TVSeries("Title", "1996", null));
		List<Media> test1 = db.searchTVTitlePartial("Title", false);
		List<TVSeries> test1Check = new ArrayList<TVSeries>();
		test1Check.add(new TVSeries("Title", "1996", null));
		assertEquals(test1.toString(), test1Check.toString());
		}

	public void testSearchFunction7() {
		MediaDatabase db = new MediaDatabase();
		db.addMedia(new TVSeries("Title", "1996", null));
		List<Media> test1 = db.searchTVYear("1996");
		List<TVSeries> test1Check = new ArrayList<TVSeries>();
		test1Check.add(new TVSeries("Title", "1996", null));
		assertEquals(test1.toString(), test1Check.toString());
	}
	
	public void testSearchFunction8(){
		MediaDatabase db = new MediaDatabase();
		List<Media> test1 = db.searchTVBoth("Test Title", "1990", false);
		List<TVSeries> test1Check = new ArrayList<TVSeries>();
		test1Check.add(new TVSeries("Test Title", null, null));
		assertEquals(test1.toString(), test1Check.toString() );
		}
	
	
}
