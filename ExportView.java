
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This view will prompt the user 
 *if they want to save their results as binary or text
 */
public class ExportView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 6701408341898552527L;

	/** Frame for this view */
	private Frame exportF = new Frame("Export");

	/**JPanel to hold the elements for this frame */
	private JPanel jpExport = new JPanel();
	
	/**Label that will ask the user a question */
	private JLabel jlExport = new JLabel("How would you like to save your results?");
	
	/**Button for if user wants to save as a text file */
	public Button  bText = new Button("Text");
	
	/**Button for if user wants to save as binary file */
	public Button bBinary = new Button ("Binary");
	
	/**Cancel button */
	public Button bCancel = new Button ("Cancel");
	
	/**Constructor for Export View */
	public ExportView(){
		jpExport.setLayout(new GridLayout(4,2, 5, 15));
		
		jpExport.add(jlExport);
		jpExport.add(bText);
		jpExport.add(bBinary);
		jpExport.add(bCancel);
		add(jpExport);
		setSize(300,300);
		setLocationRelativeTo(null);
		
	}

/** Action performed when button is pressed */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void registerTextButtonListener(ActionListener al){
		bText.addActionListener(al);
	}
	
	public void registerBinaryButtonListener(ActionListener al){
		bBinary.addActionListener(al);
	}
	
	
}