
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

	/**
	 * The view for when someone is loading or importing a file
	 */
public class ImportView extends JFrame implements ActionListener{

	/**Confirms user's option */
	public Button confirm = new Button("Confirm");
	
	/**Cancel's user's input */
	public Button cancel = new Button("Cancel");
	
	/**Butto group to keep the button options together */
	ButtonGroup buttons = new ButtonGroup();	
	
	/**Media types and makers for the user to pick */
//	public	JRadioButton media = new JRadioButton("Media");
	public JRadioButton movies = new JRadioButton("Movies");
	public JRadioButton series = new JRadioButton("Series");
//	public JRadioButton episodes = new JRadioButton("Episodes");
//	public JRadioButton makers = new JRadioButton("Makers");
	public JRadioButton actors = new JRadioButton("Actors");
	public JRadioButton directors = new JRadioButton("Directors");
	public JRadioButton producers = new JRadioButton("Producers");
	
	public JComboBox fileCB;
	
	/** 
	 * Constructor for import view
	 */
	public ImportView (){
		setTitle("Import/Load View");
		 
		//JPanel to hold the confirm and cancel buttons 
		JPanel ccButtons = new JPanel ();
		ccButtons.add(confirm,BorderLayout.WEST);
		ccButtons.add(cancel, BorderLayout.EAST);
		
		
		//File options
		String [] fileString = {"SomeActors.txt","SomeDirectors.txt","SomeProducers.txt","StarTrekMovies.txt","StarTrek.txt"};
		
		//Buttons to allow the user to pick what type of media they are uploading 
	
		
		//Make sure only 1 button is picked
//		buttons.add(media);
		buttons.add(movies);
		buttons.add(series);
//		buttons.add(episodes);
//		buttons.add(makers);
		buttons.add(actors);
		buttons.add(directors);
		buttons.add(producers);
		
		//JPanel to hold the buttons
		JPanel buttonJP = new JPanel();
		buttonJP.setLayout(new GridLayout(0,1));
		   	buttonJP.add(movies); 	buttonJP.add(series);	//	buttonJP.add(episodes);
			buttonJP.add(actors);		buttonJP.add(directors);	buttonJP.add(producers);
		
		//JPanel to hold the label, combo box, and buttonJP
		JPanel jpImport = new JPanel();
		jpImport.setLayout(new GridLayout(3,2));
		
		JLabel jlInput = new JLabel("Which file would you like to pick?");
		
		//Create the combo box and add the fileString to it 
		fileCB = new JComboBox(fileString);
		fileCB.setSelectedIndex(4);
		fileCB.addActionListener(this);
		
		//Add the elements to the 
		jpImport.add(jlInput);
		jpImport.add(fileCB);
		jpImport.add(buttonJP);
		
		add(jpImport);
		add(ccButtons,BorderLayout.SOUTH);
		
		setSize(350,400);
		
		
	}
	
	@Override
	  public void actionPerformed(ActionEvent e) {
        
		
        
    }
	
	public void registerConfirmButtonListener(ActionListener al){
		confirm.addActionListener(al);
	}

}