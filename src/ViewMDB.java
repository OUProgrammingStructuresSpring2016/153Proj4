package src;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/** 
 * View for the Media Database 
 */
public class ViewMDB extends JFrame{

/** Frame that will hold everything in the database */
private	JFrame frame = new JFrame ("MDB");	

/**Menu bar that will hold the different menu items */
private	JMenuBar mediaMB = new JMenuBar();

/**  Label for the media type JPanel that will hold the buttons */
private	JLabel mediaType = new JLabel (" Media Type ");

/** Label for the JList that will display the selected media/maker */
private	JLabel selection = new JLabel(" Selection");

/** Jlist that will display the selected Media type selected */
private	JList  mediaOutput = new JList(); 

/** JPanel that will hold the mediaType label and the radio buttons */
private JPanel mediaTypeJP = new JPanel(); 

/** Selection label and MediaOutput  JList will be held in this panel */
private JPanel selectPanel = new JPanel ();

	
	/** Radio buttons for the GUI   Should be self explanatory*/
private	JRadioButton media = new JRadioButton("Media");
private	JRadioButton movies = new JRadioButton("Movies");
private	JRadioButton series = new JRadioButton("Series");
private	JRadioButton episodes = new JRadioButton("Episodes");
private	JRadioButton makers = new JRadioButton("Makers");
private	JRadioButton actors = new JRadioButton("Actors");
private	JRadioButton directors = new JRadioButton("Directors");
private	JRadioButton producers = new JRadioButton("Producers");
	
	/** Components for the File menu */
private	JMenu file = new JMenu("File");
private	JMenuItem load = new JMenuItem("Load");
private	JMenuItem save = new JMenuItem("Save");
private	JMenuItem exit = new JMenuItem("Exit");
	
	/** Components for the Edit menu */
private	JMenu editMenu = new JMenu("Edit ");
private	JMenuItem add = new JMenuItem("Add");
private	JMenuItem edit = new JMenuItem("Edit");
private	JMenuItem delete = new JMenuItem("Delete");
private	JMenuItem clear  = new JMenuItem("Clear");
private	JMenuItem clearALL = new JMenuItem("Clear All");
	
	/** Components for Display Menu */
private	JMenu displayMenu = new JMenu ("Display");
private	JMenuItem pieChart = new JMenuItem("Pie Chart");
private	JMenuItem histogram = new JMenuItem("Histrogram");
	
	
	/**Creates the GUI for the  Media Database View */
	private void makeGUI(){
		//Add selection list and MediaOutput the selectPanel 
		selectPanel.setLayout(new GridLayout(2,4));
		selectPanel.add(selection);
		selectPanel.add(mediaOutput);
		
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
		
		//Add menu items to the menu bar
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
	
}
