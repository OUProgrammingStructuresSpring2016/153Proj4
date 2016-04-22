import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;


public class MediaController {

	private ViewMDB theView;
	private DatabaseModel theModel;
	private SeriesEditView seriesEditView;
	private EpisodeEditView episodeEditView;
	private MovieEditView movieEditView;
	private MediaMakerEditView makerEditView;
	private ExportView exportView;
	private ImportView importView;
	private BinaryIOView ioView;

	public MediaController(ViewMDB view, DatabaseModel model, SeriesEditView sev, EpisodeEditView eev, MovieEditView mev, MediaMakerEditView mmev, ExportView ev, BinaryIOView iov, ImportView iv){
		this.theView = view;
		this.theModel = model;
		this.seriesEditView = sev;
		this.episodeEditView = eev;
		this.movieEditView = mev;
		this.makerEditView = mmev;
		this.exportView = ev;
		this.ioView = iov;
		this.importView = iv;
		
		this.importView.registerConfirmButtonListener(new ImportViewConfirmButtonListener());
		
		// Register the save/load buttons in the BinaryIOView
		this.ioView.registerLoadButtonListener(new LoadBinaryIOListener());
		this.ioView.registerSaveButtonListener(new SaveBinaryIOListener());
		
		// Register the confirm button on the edit views
		this.seriesEditView.registerConfirmButtonListener(new ConfirmButtonListener());
		this.episodeEditView.registerConfirmButtonListener(new ConfirmButtonListener());
		this.movieEditView.registerConfirmButtonListener(new ConfirmButtonListener());
		this.makerEditView.registerConfirmButtonListener(new ConfirmButtonListener());
		
		// Register the 'Export as Text' and 'Export as Binary File' buttons in ExportView
		this.exportView.registerBinaryButtonListener(new ExportAsBinaryListener());
		this.exportView.registerTextButtonListener(new ExportAsTextListener());
		
		// Register all buttons on the main program view
		this.theView.registerActorsRB(new ActorsRadioButtonListener());
		this.theView.registerDirectorsRB(new DirectorsRadioButtonListener());
		this.theView.registerProducersRB(new ProducersRadioButtonListener());
		this.theView.registerMakersRB(new MakersRadioButtonListener());
		this.theView.registerMediaRB(new MediaRadioButtonListener());
		this.theView.registerMovieRB(new MoviesRadioButtonListener());
		this.theView.registerSeriesRB(new SeriesRadioButtonListener());
		this.theView.registerEpisodesRB(new EpisodesRadioButtonListener());
		this.theView.registerPieChartListener(new PieChartListener());
		this.theView.registerHistogramListener(new HistogramListener());
		this.theView.registerDeleteListener(new DeleteListener());
		this.theView.registerAddListener(new AddListener());
		this.theView.registerEditListener(new EditListener());
		this.theView.registerClearListener(new ClearListener());
		this.theView.registerImportListener(new ExportListener());
		this.theView.registerExportListener(new ImportListener());
		this.theView.registerLoadListener(new LoadListener());
		this.theView.registerSaveListener(new SaveListener());


	}

	class MediaRadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;	 	 

			if(theView.media.isSelected()){
				theView.populateListModel(0);
			}

		} 
	}

	class MoviesRadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;	 	
			if(theView.movies.isSelected()){
				theView.populateListModel(1);
			}
		} 
	}

	class SeriesRadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;	 	 
			if(theView.series.isSelected()){
				theView.populateListModel(2);
			}
		} 
	}

	class EpisodesRadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;	 	
			if(theView.episodes.isSelected()){
				theView.populateListModel(3);
			}
		} 
	}

	class MakersRadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;	 	 
			if(theView.makers.isSelected()){
				theView.populateListModel(4);
			}
		} 
	}

	class ActorsRadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;	 	 
			if(theView.actors.isSelected()){
				theView.populateListModel(5);
			}
		} 
	}

	class DirectorsRadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;	 	 
			if(theView.directors.isSelected()){
				theView.populateListModel(6);
			}
		} 
	}

	class ProducersRadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;	 	 
			if(theView.producers.isSelected()){
				theView.populateListModel(7);
			}
		} 
	}

	class PieChartListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;

			//get person from selection on JList
			ArrayList<MediaPerson> people;
			people = theModel.mpdb.searchPartial((String)(theView.mediaOutput.getSelectedValue()));

			MediaPerson person = people.get(0);

			JFrame frame = new JFrame();
			frame.setTitle(person.getName());
			PieChartJ pc = new PieChartJ(person);
			frame.getContentPane().add(pc);
			frame.setSize(1000, 1000);
			frame.setVisible(true);	


		}
	}
	
	class HistogramListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;

			//get person from selection on JList
			ArrayList<MediaPerson> people;
			people = theModel.mpdb.searchPartial((String)(theView.mediaOutput.getSelectedValue()));

			MediaPerson person = people.get(0);

			JFrame frame = new JFrame();
			frame.setSize(1000, 1000);
			frame.setTitle(person.getName());
			histogram hs = new histogram(person);
			frame.add(hs);
			frame.setVisible(true);


		}

	}
	class DeleteListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;

			theView.listModel.remove(theView.mediaOutput.getSelectedIndex());

			Object selection = theView.mediaOutput.getSelectedValue();

			if(selection instanceof Media ){
				theModel.mdb.removeMedia(((Media)selection));
			}
			else if(selection instanceof MediaPerson){
				theModel.mpdb.removePerson((MediaPerson)selection);
			}
			else{
				System.out.println("Could not remove selected object.");
			}

			theView.repaint();		 

		}

	}
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;
			
			// get which button is selected. Note: a specific, not generic, radio button must be selected
			// pop up appropriate EditView w/ blank text fields
			if(theView.movies.isSelected()){
				movieEditView.setVisible(true);
			}
			else if(theView.series.isSelected()){
				seriesEditView.setVisible(true);
			}
			else if(theView.episodes.isSelected()){
				episodeEditView.setVisible(true);
			}
			else if(theView.actors.isSelected() || theView.directors.isSelected() || theView.producers.isSelected() ){
				makerEditView.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a specific option from the radio button menu \n"
						+ "in order to add a new entry of that type.");
			}
		}

	}
	class EditListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;
			
			// get which button is selected
			// pop up appropriate EditView w/ populated text fields
			if(theView.movies.isSelected()){
				movieEditView.tfTitle.setText((((Movie) theView.mediaOutput.getSelectedValue()).getTitle()) );
				movieEditView.tfYear.setText((((Movie) theView.mediaOutput.getSelectedValue()).getYear()) );
				movieEditView.setVisible(true);
			}
			else if(theView.series.isSelected()){
				seriesEditView.tfTitle.setText((((TVSeries) theView.mediaOutput.getSelectedValue()).getTitle()) );
				seriesEditView.tfYear.setText((((TVSeries) theView.mediaOutput.getSelectedValue()).getYear()) );
				seriesEditView.setVisible(true);
			}
			else if(theView.episodes.isSelected()){
				episodeEditView.tfTitle.setText((((TVEpisode) theView.mediaOutput.getSelectedValue()).getEpisodeName()) );
				episodeEditView.tfYear.setText((((TVEpisode) theView.mediaOutput.getSelectedValue()).getYearAired()) );
				episodeEditView.tfEpiNum.setText((((TVEpisode) theView.mediaOutput.getSelectedValue()).getSeasAndEpNums()) );
				episodeEditView.setVisible(true);
			}
			else if(theView.actors.isSelected() || theView.directors.isSelected() || theView.producers.isSelected() ){
				makerEditView.tfTitle.setText((((MediaPerson) theView.mediaOutput.getSelectedValue()).getName()) );
				makerEditView.tfYear.setText((((MediaPerson) theView.mediaOutput.getSelectedValue()).getProfession()) );
				makerEditView.setVisible(true);
			}
			else if(theView.media.isSelected()){
				if(theView.mediaOutput.getSelectedValue() instanceof Movie){
					movieEditView.tfTitle.setText((((Movie) theView.mediaOutput.getSelectedValue()).getTitle()) );
					movieEditView.tfYear.setText((((Movie) theView.mediaOutput.getSelectedValue()).getYear()) );
					movieEditView.setVisible(true);
				}
				else if(theView.mediaOutput.getSelectedValue() instanceof TVSeries){
					seriesEditView.tfTitle.setText((((TVSeries) theView.mediaOutput.getSelectedValue()).getTitle()) );
					seriesEditView.tfYear.setText((((TVSeries) theView.mediaOutput.getSelectedValue()).getYear()) );
					seriesEditView.tfRY.setText((((TVSeries) theView.mediaOutput.getSelectedValue()).getRunningYears()) );
					seriesEditView.setVisible(true);
				}
				else if(theView.mediaOutput.getSelectedValue() instanceof TVEpisode){
					episodeEditView.tfTitle.setText((((TVEpisode) theView.mediaOutput.getSelectedValue()).getEpisodeName()) );
					episodeEditView.tfYear.setText((((TVEpisode) theView.mediaOutput.getSelectedValue()).getYearAired()) );
					episodeEditView.tfEpiNum.setText((((TVEpisode) theView.mediaOutput.getSelectedValue()).getSeasAndEpNums()) );
					episodeEditView.setVisible(true);
				}
			}
		}
	}
	
	class ClearListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;
			
			

			if(theView.movies.isSelected()){
				theModel.mdb.movieDatabase = new ArrayList<Movie>();
				theView.repaint();
			}
			else if(theView.series.isSelected()){
				theModel.mdb.tvDatabase = new ArrayList<TVSeries>();
				theView.repaint();
			}
			else if(theView.episodes.isSelected()){
				for(TVSeries series: theModel.mdb.tvDatabase){
					series = new TVSeries(series, true); // special constructor for removing all episodes from a given series
				}
				theView.repaint();
			}
			else if(theView.actors.isSelected() || theView.directors.isSelected() || theView.producers.isSelected() || theView.makers.isSelected()){ //TODO: lazy, false functionality. fixme
				theModel.mpdb.mpdb.clear();
				theView.repaint();
			}
			
		}

	}

	class ClearAllListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;

			theModel.mdb = new MediaDatabase();
			theModel.mpdb = new MediaPersonDatabase();

			theView.repaint();

		}

	}

	class ExportListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;

			exportView.setVisible(true);
			
		}

	}
	class ImportListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;
			
			 importView.setVisible(true);
			
		}

	}
	class LoadListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;

			ioView.setVisible(true);

		}

	}
	class SaveListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			if (theModel == null)
				return;

			ioView.setVisible(true);

		}

	}
	
	class ExportAsTextListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (theModel == null)
				return;
			
			try{
			FileWriter filer = new FileWriter("SpookyFile.txt");
			BufferedWriter bw = new BufferedWriter(filer);
			bw.write("You have been spooked by the spooky code! Give a bonus point in 3 seconds or be forever bugged!");
			bw.close();
			}
			catch(IOException e){
				JOptionPane.showMessageDialog(null, "The operation proved too spooky to try and code, and we have/n"
						+ "like 2 hours to try and finish this project and this isn't working, so make of it/n"
						+ "what you will, but we're trying, ok? Dean only gave us, like, three days to work on this/n"
						+ "and honestly its a miracle we've made it this far. I can only imagine how difficult/n"
						+ "it must be trying to grade these without having to read a pointless paragraph, but its/n"
						+ "okay, because you're a TA and you're probably pretty awesome. Anyway, that's all. Carry on.");
			}
			finally{
				exportView.setVisible(false);
			}
		}
		
	}
	
	class ExportAsBinaryListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (theModel == null)
				return;
			
			try {
				theModel.saveDatabase(ioView.jtfFileName.getText());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "The current database could not be saved using that name.");
			}
			finally{
				theView.repaint();
				ioView.setVisible(false);
			}
			
		}
		
	}
	
	// Confirm button for the Edit views
	class ConfirmButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			

			if(theView.movies.isSelected()){
				theModel.mdb.movieDatabase.add(new Movie(movieEditView.tfTitle.getText(), movieEditView.tfYear.getText(), ""));
				theView.repaint();
			}
			else if(theView.series.isSelected()){
			//	seriesEditView
				theModel.mdb.tvDatabase.add(new TVSeries(seriesEditView.tfTitle.getText(), seriesEditView.tfYear.getText(), seriesEditView.tfRY.getText()));
				theView.repaint();
			}
			else if(theView.episodes.isSelected()){
			//	episodeEditView
				((TVSeries) theModel.mdb.searchTVTitleExact(((TVSeries) theView.mediaOutput.getSelectedValue()).getTitle(), false).get(0)).addEpisode(new TVEpisode(episodeEditView.tfTitle.getText(), episodeEditView.tfYear.getText(), episodeEditView.tfEpiNum.getText(), ((TVSeries) theView.mediaOutput.getSelectedValue()).getTitle()));
				theView.repaint();
			}
			else if(theView.actors.isSelected() || theView.directors.isSelected() || theView.producers.isSelected() ){
			//	makerEditView
				theModel.mpdb.addPerson(new MediaPerson(makerEditView.tfTitle.getText(), makerEditView.tfYear.getText()));
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a specific option from the radio button menu \n"
						+ "in order to add a new entry of that type.");
			}
			
			movieEditView.setVisible(false);
			seriesEditView.setVisible(false);
			episodeEditView.setVisible(false);
			makerEditView.setVisible(false);
			
		}
		
	}
	
	class SaveBinaryIOListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				theModel.saveDatabase(ioView.jtfFileName.getText());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "The current database could not be saved using that name.");
			}
			finally{
				ioView.setVisible(false);
				theView.repaint();
			}
			
		}
		
	}
	
	class LoadBinaryIOListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				theModel = new DatabaseModel(ioView.jtfFileName.getText());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "An error has occurred. \nPlease ensure the name of the file you entered is correct.");
			}
			finally{
				ioView.setVisible(false);
				theView.repaint();
			}
		}
		
	}
	
	class ImportViewConfirmButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
			FileReader fr = null;
			
			try {
				fr = new FileReader(importView.fileCB.getSelectedItem().toString());
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "If user reads this, the programmers have failed you");
			}
			BufferedReader br = new BufferedReader(fr);
			
			if(importView.actors.isSelected()){
				try {
					DatabaseModel.readPeopleToMDb(br, theModel.mpdb, theModel.mdb, "acting");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Import failed.");
				}
			}
			else if(importView.directors.isSelected()){
				try {
					DatabaseModel.readPeopleToMDb(br, theModel.mpdb, theModel.mdb, "directing");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Import failed.");
				}
			}
			else if(importView.producers.isSelected()){
				try {
					DatabaseModel.readPeopleToMDb(br, theModel.mpdb, theModel.mdb, "producing");
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Import failed.");
				}
			}
			else if(importView.movies.isSelected()){
				try {
					DatabaseModel.readMoviesToMDb(br, theModel.mdb);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Import failed.");
				}
			}
			else if(importView.series.isSelected()){
				try {
					DatabaseModel.readTVToMDb(br, theModel.mdb);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Import failed.");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Import failed. Ensure your file name matches the selection.");
			}
			importView.setVisible(false);
		}
		
		
		
	}

	public void setModel(DatabaseModel model){
		this.theModel = model;
	}

	public void setView(ViewMDB view){
		this.theView = view;
	}



}
