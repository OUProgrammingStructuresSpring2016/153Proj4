import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Edit View for Episode entries when user presses edit menu option */
public class EpisodeEditView extends EditView implements ActionListener {
	/** JPanel to hold the elements of the for the Episode View */
	private JPanel jpEpisodeNum = new JPanel();
	
	/**  JLabel for the Episode Num text field */
	private 	JLabel jlEpiNum = new JLabel("Episode Number: ");
	/**Text field to enter episode number info */
	public JTextField tfEpiNum = new JTextField();
	
	/** Label for the series textfield */
	private JLabel jlSeries = new JLabel ("Series: ");
	/**Text field to enter series title */
	public JTextField seriesTF = new JTextField();
	
	/** Constructor for episode edit view */
	public EpisodeEditView (){
		setTitle("Episode Edit View");
		
		//Add the elements into the JPanel. These will have the episode number label and episode  num textfield
		jpEpisodeNum.setLayout(new GridLayout(2,4, 5, 7));
		jpEpisodeNum.add(jlEpiNum);
		jpEpisodeNum.add(tfEpiNum);
		
		//Add These will be the series the episode belongs to
		jpEpisodeNum.add(jlSeries);
		jpEpisodeNum.add(seriesTF);
		
		//Add the elements to the frameJP
		frameJP.add(jpEpisodeNum, BorderLayout.CENTER);
		//addButtons to the frameJP
		frameJP.add(buttons, BorderLayout.SOUTH);
		
		add(frameJP);
		
		setLocationRelativeTo(null); //Makes it appear in the center of screen
	
		
	}
	

}
