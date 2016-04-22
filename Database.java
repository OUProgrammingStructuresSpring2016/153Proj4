/**
 * Wrapper class for MediaDatabase and MediaPersonDatabase classes.
 * In order to refer to these MediaDatabase and MediaPersonDatabase methods,
 * use Database.mdb.method() 
 */
public class Database {
	/** Media database that will be added to the main database */
	public MediaDatabase mdb;
	/** Media person database that will be added to the main database */
	public MediaPersonDatabase mpdb;
	
	/**Constructor for the media database
	 * 
	 *@param mdb Media database to use
	 *@param mpdb Media person database to use 
	 */ 
	public Database(MediaDatabase mdb, MediaPersonDatabase mpdb){
		this.mdb = mdb;
		this.mpdb = mpdb;
	}
}
