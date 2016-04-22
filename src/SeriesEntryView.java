package hereAretheENTRYVIEWS;

import java.awt.event.ActionListener;
/** The entry view someone sees when they hit ADD and have Series selected */

public class SeriesEntryView extends EntryView implements ActionListener{

	/** Constructor for Series Entry view */
	public SeriesEntryView(){
		setTitle("Series Entry View");
		//JPanel to add in the Running years of a series
		JPanel jpRY = new JPanel();
		jpRY.setLayout(new GridLayout(0,1));
		JLabel jlRY = new JLabel("Running Years: ");
		JTextField tfRY = new JTextField();
		
		//Add the Running year label and textfield to the JPanel
		jpRY.add(jlRY);
		jpRY.add(tfRY);
		
		//add the jpRY to the frameJP
		frameJP.add(jpRY, BorderLayout.CENTER);
		frameJP.add(buttons, BorderLayout.SOUTH);
		setLocation(100,200);
		
	}
}
