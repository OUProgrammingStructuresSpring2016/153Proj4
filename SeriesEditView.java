import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Series Edit view for when user hits the edit option to edit an entry of Series
 * type
 */
public class SeriesEditView extends EditView implements ActionListener {

	private static final long serialVersionUID = 2429465296237902343L;
	
	public JTextField tfRY;

	/**Constructor for Series Edit view */
	public SeriesEditView(){
		setTitle("Series Edit View");
		
		//JPanel to add in the Running years of a series
		JPanel jpRY = new JPanel();
		jpRY.setLayout(new GridLayout(0,1));
		JLabel jlRY = new JLabel("Running Years: ");
		tfRY = new JTextField();
		
		//Add the Running year label and textfield to the JPanel
		jpRY.add(jlRY);
		jpRY.add(tfRY);
		
		//add the jpRY to the frameJP
		frameJP.add(jpRY, BorderLayout.CENTER);
		frameJP.add(buttons, BorderLayout.SOUTH);
		setLocation(100,200);
		
	}
	
}