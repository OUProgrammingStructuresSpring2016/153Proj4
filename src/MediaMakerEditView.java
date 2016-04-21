import java.awt.event.ActionListener;


/** 
 * Edit view for media makers when user picks a media maker(Actor,director, producer)
 * and the Edit option.
 *
 */
public class MediaMakerEditView extends EditView implements ActionListener {
	/**
	 * Constructor for Media Maker edit view  
	 */
	 
	public MediaMakerEditView(){
		lblTitle.setText("Name: ");
		jlYear.setText("Profession:  ");
		setTitle("Media Maker Edit View");
	}
	
}
