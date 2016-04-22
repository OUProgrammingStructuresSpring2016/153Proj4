import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * View for the Episode Entry when someone presses ADD and has Episodes selected
 */
public class EpisodeEntryView extends EntryView implements ActionListener {

	/**JPanel to hold the Episode Number */ 
	private JPanel jpEpisodeNum = new JPanel();
	/** Label for the episode Num text Box*/
	private	JLabel jlEpiNum = new JLabel("Episode Number: ");
	/**Text box to hold the episode # */
	public JTextField tfEpiNum = new JTextField();
	
	/**Label for the Series text box */
	private JLabel jlSeries = new JLabel ("Series: ");
	/** textbox to hold series name */
	public JTextField seriesTF = new JTextField();
	
	/** Constructor for episode edit view */
	public EpisodeEntryView (){
		setTitle("Episode Entry View");
		
		jpEpisodeNum.setLayout(new GridLayout(2,4, 5, 7));
		jpEpisodeNum.add(jlEpiNum);
		jpEpisodeNum.add(tfEpiNum);
		
		jpEpisodeNum.add(jlSeries);
		jpEpisodeNum.add(seriesTF);
		
		frameJP.add(jpEpisodeNum, BorderLayout.CENTER);
		
		frameJP.add(buttons, BorderLayout.SOUTH);
		add(frameJP);
		
		setLocationRelativeTo(null); //Makes it appear in the center of screen
		setVisible(true);
		
	}
}
