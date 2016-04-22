import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Edit View for Episode entries when user presses edit menu option */
public class EpisodeEditView extends EditView implements ActionListener {
	/** jPANEL TO HOLD EPISODENUMBER INFO */
	private JPanel jpEpisodeNum = new JPanel();
	/**jLABEL FOR the episode textfield. It will hold the Episode number */
	private JLabel jlEpiNum = new JLabel("Episode Number: ");
	/**Textfield to hold the episode number */
	public JTextField tfEpiNum = new JTextField();
	
	/** Constructor for episode edit view */
	public EpisodeEditView (){
		setTitle("Episode Edit View");
		
		jpEpisodeNum.setLayout(new GridLayout(0,1));
		jpEpisodeNum.add(jlEpiNum);
		jpEpisodeNum.add(tfEpiNum);
		frameJP.add(jpEpisodeNum, BorderLayout.CENTER);
		
		frameJP.add(buttons, BorderLayout.SOUTH);
		add(frameJP);
		
		setLocationRelativeTo(null); //Makes it appear in the center of screen
		setVisible(false);
		
	}
}
