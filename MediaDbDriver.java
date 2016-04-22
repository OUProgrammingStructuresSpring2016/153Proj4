/**
 * Project #3 CS 2334, Section 010 March 28, 2016
 * <P>
 * Drives user interaction with a media database through the console.
 * </P>
 * 
 * @version 1.0
 */
public class MediaDbDriver {
	

	public static void main(String[] args) {
		
		DatabaseModel model;
		
		ViewMDB databaseView = new ViewMDB();
		MediaDatabase mdb = new MediaDatabase();
		MediaPersonDatabase mpd = new MediaPersonDatabase(); 
		model = new DatabaseModel(mdb, mpd);
		SeriesEditView seriesView = new SeriesEditView();
		EpisodeEditView episodeView = new EpisodeEditView();
		MovieEditView moView = new MovieEditView();
		MediaMakerEditView mView = new MediaMakerEditView();
		ExportView exView = new ExportView();
		ImportView imView = new ImportView();
		BinaryIOView ioView = new BinaryIOView();
		
		
		
		MediaController controller = new MediaController(databaseView, model, seriesView, episodeView, moView, mView, exView, ioView, imView);

		databaseView.setModel(model);
		controller.setModel(model);
		controller.setView(databaseView);
		
		databaseView.makeGUI();
		
	}

}
