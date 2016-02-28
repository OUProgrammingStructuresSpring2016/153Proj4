import java.util.Comparator;

/**
 * Project #2
 * CS 2334, Section 010
 * Feb 19, 2016
 * <P>
 * A comparator in order to organize Media based on their release year instead of title.
 * </P>
 * @version 1.0
 */
public class YearComparator implements Comparator<String> {
	
	/**
	 * Compares the int values of two media objects' release year.
	 */
	public int compare(String year, String year2){
		if(compare(year,year2) >0){
		//if there is a match
			return 1; 
		}
		if(compare(year,year2) < 0){
			//no match
			return -1;
		}
		else{
			return 0;
		}
		//TODO make  compare method with the release 
	}
	
}
