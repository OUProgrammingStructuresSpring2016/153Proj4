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
 * This class is the view for the Edit menu option.
 * It will allow the user to make a change to an entry in the JList when they 
 * hit the EDIT menu item
 *
 */

public class EditView extends JFrame implements ActionListener {
	/**Button to confirm user wants to make a chance to title or year */ 
	public JButton confirm = new JButton ("Confirm");
	
	/**Button to cancel changes */
	public JButton cancel = new JButton ("Cancel");
	
	/** JPanel to add buttons into */ 
	protected JPanel buttons = new JPanel();
	
	//JPanel to add the Title label and textbox into 
	private JPanel jpTitles = new JPanel (); 
	protected JLabel  lblTitle = new JLabel("Title: ");
	public JTextField tfTitle = new JTextField (); 
	
	//JPanel to add the Year's textbox and label  
	private JPanel jpYear = new JPanel ();
	protected JLabel jlYear = new JLabel("Year: ");
	public JTextField tfYear = new JTextField();
	
	JFrame  frame = new JFrame();
	JPanel frameJP = new JPanel();
	/** 
	 * Constructor for Movies and Series 
	 */
	public EditView(){
	
		buttons.setLayout(new GridLayout(4,2));
		buttons.add(confirm);
		buttons.add(cancel);
		
		//Title related fields
		jpTitles.setLayout(new GridLayout(0,1));
		
			
			//Year related fields
		jpYear.setLayout(new GridLayout(0,1));
		
		
		
		
		
		frameJP.setLayout(new GridLayout(0,1));
	
		//set the title
		setTitle("Media Entry View)");
		
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
		setVisible(false);
		
	}
	
	/**
	 * Registration for Confirm Button
	 * @param al ActionListener for this button 
	 */
	public void registerConfirmButtonListener(ActionListener al){ 
		confirm.addActionListener(al);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
