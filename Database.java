/**
 * Wrapper class for MediaDatabase and MediaPersonDatabase classes.
 * In order to refer to these MediaDatabase and MediaPersonDatabase methods,
 * use Database.mdb.method() 
 */
public class Database {
	
	public MediaDatabase mdb;
	public MediaPersonDatabase mpdb;
	
	public Database(MediaDatabase mdb, MediaPersonDatabase mpdb){
		this.mdb = mdb;
		this.mpdb = mpdb;
	}
}
