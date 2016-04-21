 import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
  public class ViewMDB extends JFrame{
  
  
	private static final long serialVersionUID = -7278579983787154086L;
	
	private DatabaseModel theModel;
	

	private	JFrame frame = new JFrame ("MDB");	
 
	private	JMenuBar mediaMB = new JMenuBar();
  
  private	JLabel mediaType = new JLabel (" Media Type ");
  private	JLabel selection = new JLabel(" Selection");
  public	JList  mediaOutput = new JList(); 
  
  //add the mediaType label and the radio buttons to this panel
  private JPanel mediaTypeJP = new JPanel(); 
  
  //add the Selection label and MediaOutput  JList to selectPanel       
  private JPanel selectPanel = new JPanel ();
  
  	
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
  	
  	
  	
  	private void makeGUI (){
  		//Add selection list and MediaOutput the selectPanel 
  		selectPanel.setLayout(new GridLayout(2,4));
  		selectPanel.add(selection);
  		selectPanel.add(mediaOutput);
  		
  		//Make sure only 1 button is selected
  			ButtonGroup buttons = new ButtonGroup();
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
  		frame.add(mediaMB);
  		
  		
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
  			
  		}
  	}
  	
  	public void registerSelectionListener(ActionListener al){ //TODO: register the listener for the radio button menu
  		
  	}
  	
  	public void registerPieChartListener(ActionListener al){ //TODO: register the listener for the Display -> Pie Chart option
  		
  	}
  	
  	public void registerHistogramListener(ActionListener al){ //TODO: register the listener for Histogram option
  		
  	}
  	
  	public void registerDeleteListener(ActionListener al){ //TODO: register the listener for the Edit -> Delete option
  		
  	}
  	
  	public void registerClearListener(ActionListener al){ //TODO: register the listener for the Edit -> Clear option
  		
  	}
  	
  	public void registerAddListener(ActionListener al){ //TODO: register the listener for the Edit -> Add option
  		
  	}
  	
  	public void registerEditListener(ActionListener al){ //TODO: register the listener for the Edit -> Edit Entry
  		
  	}
  	
  	public void registerClearAllListener(ActionListener al){ //TODO: take a guess
  		
  	}
  	
  	public void registerExportListener(ActionListener al){ //TODO: register the listener for the File => Export
  		
  	}
  	
  	public void registerImportListener(ActionListener al){ //TODO: register the listener for File -> Import
  		
  	}
  	
  	public void registerSaveListener(ActionListener al){ //TODO: File -> Save
  		
  	}
  	
  	public void registerLoadListener(ActionListener al){ //TODO: File -> Load
  		
  	}
  	
  }
