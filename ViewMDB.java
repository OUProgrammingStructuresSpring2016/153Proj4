import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.ArrayList;


























































































































































import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
public class ViewMDB extends JFrame implements ActionListener, Serializable{


	private static final long serialVersionUID = -7278579983787154086L;

	private DatabaseModel theModel;


	private	JFrame frame = new JFrame ("MDB");	

	private	JMenuBar mediaMB = new JMenuBar();

	private	JLabel mediaType = new JLabel (" Filter:");
	private	JLabel selection = new JLabel("Selection");
	public	JList<Object>  mediaOutput; 
	public DefaultListModel<Object> listModel = new DefaultListModel<Object>();

	//add the mediaType label and the radio buttons to this panel
	private JPanel mediaTypeJP = new JPanel(); 

	//add the Selection label and MediaOutput  JList to selectPanel       
	private JPanel selectPanel = new JPanel();


	public ButtonGroup buttons = new ButtonGroup();
	
	/**Radio buttons for the GUI */
	public	JRadioButton media = new JRadioButton("Media");
	public	JRadioButton movies = new JRadioButton("Movies");
	public	JRadioButton series = new JRadioButton("Series");
	public	JRadioButton episodes = new JRadioButton("Episodes");
	public	JRadioButton makers = new JRadioButton("Makers");
	public	JRadioButton actors = new JRadioButton("Actors");
	public	JRadioButton directors = new JRadioButton("Directors");
	public	JRadioButton producers = new JRadioButton("Producers");

	/** Components for the File menu */
	private	JMenu file = new JMenu("File");
	private	JMenuItem load = new JMenuItem("Load");
	private	JMenuItem save = new JMenuItem("Save");
	private	JMenuItem exit = new JMenuItem("Exit");
	private	JMenuItem export = new JMenuItem("Export");
	private	JMenuItem importS = new JMenuItem("Import");


	/** Components for the Edit menu */

	private	JMenu editMenu = new JMenu("Edit ");
	private	JMenuItem add = new JMenuItem("Add");
	private	JMenuItem edit = new JMenuItem("Edit Entry");
	private	JMenuItem delete = new JMenuItem("Delete");
	private	JMenuItem clear  = new JMenuItem("Clear");
	private	JMenuItem clearALL = new JMenuItem("Clear All");



	/** Components for Display Menu */

	private	JMenu displayMenu = new JMenu ("Display");
	private	JMenuItem pieChart = new JMenuItem("Pie Chart");
	private	JMenuItem histogram = new JMenuItem("Histogram");

	public ViewMDB(){
		mediaOutput = new JList<Object>(listModel);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	


	public void makeGUI(){
		//Add selection list and MediaOutput the selectPanel 
		selectPanel.setLayout(new GridLayout(2,4));
		selectPanel.add(selection);
		selectPanel.add(mediaOutput);
		
		//make sure only 1 button is chosen
		buttons.add(media);
		buttons.add(movies);
		buttons.add(series);
		buttons.add(episodes);
		buttons.add(makers);
		buttons.add(actors);
		buttons.add(directors);
		buttons.add(producers);
		//add mediaType label  and the radio buttons to mediaTypeJP


		mediaTypeJP.setLayout(new GridLayout(0,1));
		mediaTypeJP.add(mediaType);
		mediaTypeJP.add(media);
		mediaTypeJP.add(movies);
		mediaTypeJP.add(series);
		mediaTypeJP.add(episodes);
		mediaTypeJP.add(makers);
		mediaTypeJP.add(actors);
		mediaTypeJP.add(directors);
		mediaTypeJP.add(producers);



		//File menu
		file.add(load);
		file.add(save);
		file.add(importS);
		file.add(export);
		file.add(exit);


		//Edit menu
		editMenu.add(add);
		editMenu.add(edit);
		editMenu.add(delete);
		editMenu.add(clear);
		editMenu.add(clearALL);


		//Display menu 
		displayMenu.add(pieChart);
		displayMenu.add(histogram);

		//add elements to GUI

		frame.setLayout(new GridLayout(0,1));
		frame.setJMenuBar(mediaMB);


		mediaMB.add(file);
		mediaMB.add(editMenu);
		mediaMB.add(displayMenu);
		frame.add(mediaTypeJP);

		JPanel selectionListPanel = new JPanel();
		selectionListPanel.setLayout(new GridLayout(1,2));
		selectionListPanel.add(mediaTypeJP);
		selectionListPanel.add(selectPanel);

		frame.add(selectionListPanel);
		frame.setSize(500, 600);

		frame.setVisible(true);


	}

	public void setModel(DatabaseModel model){
		theModel = model;
		if(theModel != null){
			theModel.addActionListener(this);
		}
	}

	public void populateListModel(int radioButtonSelection){

		switch(radioButtonSelection){
		case 0: // Media
			for(Movie m: theModel.mdb.movieDatabase){  // Add movies
				listModel.addElement(m);
			}
			for(TVSeries s: theModel.mdb.tvDatabase){ // Add series
				listModel.addElement(s);
				for(TVEpisode ep: s.getEpisodes()){ // Add episodes
					listModel.addElement(ep);
				}
			}
			break;
		case 1: // Moooovie
			for(Movie m: theModel.mdb.movieDatabase){ 
				listModel.addElement(m);
			}
			break;
		case 2: // TeeVee Siri's
			for(TVSeries s: theModel.mdb.tvDatabase){ 
				listModel.addElement(s);
			}
			break;
		case 3: // Episodes
			for(TVSeries s: theModel.mdb.tvDatabase){ 
				for(TVEpisode ep: s.getEpisodes()){
					listModel.addElement(ep);
				}
			}
			break;
		case 4: // Maedia Maekres
			ArrayList<MediaPerson> people = new ArrayList<MediaPerson>(theModel.mpdb.mpdb.values());
			for(MediaPerson m: people){
				listModel.addElement(m);
			}
			break;
		case 5: // Actors
			ArrayList<MediaPerson> peoples = new ArrayList<MediaPerson>(theModel.mpdb.mpdb.values());
			for(MediaPerson m: peoples){
				if(m.getNumMoviesActed() != 0 || m.getNumSeriesActed() != 0)
				listModel.addElement(m);
			}
			break;
		case 6: // Directors
			ArrayList<MediaPerson> peoples1 = new ArrayList<MediaPerson>(theModel.mpdb.mpdb.values());
			for(MediaPerson m: peoples1){
				if(m.getNumMoviesDirected() != 0 || m.getNumSeriesDirected() != 0)
				listModel.addElement(m);
			}
			break;
		case 7: // Producers
			ArrayList<MediaPerson> peoples2 = new ArrayList<MediaPerson>(theModel.mpdb.mpdb.values());
			for(MediaPerson m: peoples2){
				if(m.getNumMoviesProduced() != 0 || m.getNumSeriesProduced() != 0)
				listModel.addElement(m);
			}
			break;
		}
		
		repaint();
	}

	public void registerMediaRB(ActionListener al){ 
		media.addActionListener(al);
	}

	public void registerMovieRB(ActionListener al){ 
		movies.addActionListener(al);
	}

	public void registerSeriesRB(ActionListener al){ 
		series.addActionListener(al);
	}

	public void registerEpisodesRB(ActionListener al){ 
		episodes.addActionListener(al);
	}

	public void registerMakersRB(ActionListener al){ 
		makers.addActionListener(al);
	}

	public void registerActorsRB(ActionListener al){
		actors.addActionListener(al);
	}

	public void registerDirectorsRB(ActionListener al){
		directors.addActionListener(al);
	}

	public void registerProducersRB(ActionListener al){ 
		producers.addActionListener(al);
	}

	public void registerPieChartListener(ActionListener al){ 
		pieChart.addActionListener(al);
	}

	public void registerHistogramListener(ActionListener al){ 
		histogram.addActionListener(al);
	}

	public void registerDeleteListener(ActionListener al){
		delete.addActionListener(al);
	}

	public void registerClearListener(ActionListener al){ 
		clear.addActionListener(al);
	}

	public void registerAddListener(ActionListener al){ 
		add.addActionListener(al);
	}

	public void registerEditListener(ActionListener al){ 
		edit.addActionListener(al);
	}

	public void registerClearAllListener(ActionListener al){
		clearALL.addActionListener(al);
	}

	public void registerExportListener(ActionListener al){ 
		export.addActionListener(al);
	}

	public void registerImportListener(ActionListener al){ 
		importS.addActionListener(al);
	}

	public void registerSaveListener(ActionListener al){ 
		save.addActionListener(al);
	}

	public void registerLoadListener(ActionListener al){ 
		load.addActionListener(al);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int j=-1;
		
		if(media.isSelected())
			j=0;
		else if(movies.isSelected())
			j=1;
		else if(series.isSelected())
			j=2;
		else if(episodes.isSelected())
			j=3;
		else if(makers.isSelected())
			j=4;
		else if(actors.isSelected())
			j=5;
		else if(directors.isSelected())
			j=6;
		else if(producers.isSelected())
			j=7;
		populateListModel(j);
		repaint();
	}


}
