package hereAretheENTRYVIEWS;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
 * Entry View for when a user has a radio button selected and
 *pressed the ADD menu item to add it to the list.
 */

public class EntryView extends JFrame implements ActionListener {
	/**Button to confirm user wants to make a chance to title or year */ 
	public JButton confirm = new JButton ("Confirm");
	
	/**Button to cancel changes */
	public JButton cancel = new JButton ("Cancel");
	
	/** JPanel to add buttons into */ 
	protected JPanel buttons = new JPanel();
	
	/** JPanel to add the title elements of a work */
	protected JPanel jpTitles = new JPanel (); 
	/**JLabel to label the title text box */
	protected JLabel  lblTitle = new JLabel("Title: ");
	/** the textfield where users will provide a title*/
	public JTextField tfTitle = new JTextField (); 
	
	/** JPanel to add the year elements */
	protected JPanel jpYear = new JPanel ();
	/** JLabel to label the Year's textbox */
	protected JLabel jlYear = new JLabel("Year: ");
	/** Jtextfield to add in the year */
	public JTextField tfYear = new JTextField();
	
	//JFrame  frame = new JFrame();
	
	/**JPanel to add all the elements into before adding to the frame*/
	JPanel frameJP = new JPanel();
	
	
	/** 
	 * Constructor for Entry View 
	 */
	public EntryView(){
	
		buttons.setLayout(new GridLayout(4,2));
		buttons.add(confirm);
		buttons.add(cancel);
		
		//Title related fields
		jpTitles.setLayout(new GridLayout(0,1));
		
			
			//Year related fields
		jpYear.setLayout(new GridLayout(0,1));
		
		
		
		
		
		frameJP.setLayout(new GridLayout(0,1));
	
		//set the title
		setTitle("Entry View");
		
		//add the  title elements to the jpTitles, then add the jpTitles to the frame JPanel
		jpTitles.add(lblTitle);
		jpTitles.add(tfTitle);
		frameJP.add(jpTitles, BorderLayout.NORTH);
	
		//add the year elements to the jpYear, then add jpYear to the frameJP
		jpYear.add(jlYear);
		jpYear.add(tfYear);
		frameJP.add(jpYear,BorderLayout.CENTER);
		
		
		//Add the botton the the Jpanel for the Frame , then add the JPanel to the frame
		frameJP.add(buttons, BorderLayout.SOUTH);
		add(frameJP);
	
		//Set size, location, and visibility of the Edit View
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	//TODO Double check what daniel named the action Listener
	public void registerConfirmB (ActionListener al) {
		confirm.addActionListener(al);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
