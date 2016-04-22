package hereAretheENTRYVIEWS;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import aaaaaaaaaaaaaaaaaaa.EditView;

public class EpisodeEntryView extends EntryView implements ActionListener {

	private JPanel jpEpisodeNum = new JPanel();
	private 	JLabel jlEpiNum = new JLabel("Episode Number: ");
	public JTextField tfEpiNum = new JTextField();
	
	private JLabel jlSeries = new JLabel ("Series: ");
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