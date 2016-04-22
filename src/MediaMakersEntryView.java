package hereAretheENTRYVIEWS;

import java.awt.event.ActionListener;
/**
 * The view for the Media Makers when someone hits ADD and has a media maker selected (actor,director,producer)
 */
public class MediaMakersEntryView extends EntryView implements ActionListener {

	/**Constructor for this class */
		public MediaMakersEntryView (){
			lblTitle.setText("Name: ");
			jlYear.setText("Profession: ");
			setTitle("Media Maker Entry View");
			
		}
}
