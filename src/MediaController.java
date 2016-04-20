import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class MediaController {
 
	private ViewMDB theView;
	private DatabaseModel theModel;
 
 public MediaController(ViewMDB ViewMDB,DatabaseModel DatabaseModel){
	 this.theView = ViewMDB;
	 this.theModel = DatabaseModel;
	 this.theView.registerSelectionListener(new SelectionListener());
	 this.theView.registerPieChartListener(new PieChartListener());
	 this.theView.registerHistogramListener(new HistogramListener());
	 this.theView.registerDeleteListener(new DeleteListener());
	 this.theView.registerAddListener(new AddListener());
	 this.theView.registerEditListener(new EditListener());
	 this.theView.registerClearListener(new ClearListener());
	 this.theView.registerImportListener(new ExportListener());
	 this.theView.registerExportListener(new ImportListener());
	 this.theView.registerLoadListener(new LoadListener());
	 this.theView.registerSaveListener(new SaveListener());
	 
	 
 }
 class SelectionListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
		 
		 
		 
	 }
	 
 }
 class PieChartListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
		 
		 //get person from selection on JList
		 //MediaPerson person = theView.mediaOutput
		 
			JFrame frame = new JFrame();
			frame.setTitle(person.getName());
			PieChartJ pc = new PieChartJ(person);
			frame.getContentPane().add(pc);
			frame.setSize(1000, 1000);
			frame.setVisible(true);	
			
		 
	 }
	 
 }
 class HistogramListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
	 }
	 
 }
 class DeleteListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
		 
		 
		 
	 }
	 
 }
 class AddListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
		 
		 
	 }
	 
 }
 class EditListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
	 }
	 
 }
 class ClearListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
	 }
	 
 }
 class ExportListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
	 }
	 
 }
 class ImportListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
	 }
	 
 }
 class LoadListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
		 
		 
		 
	 }
	 
 }
 class SaveListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 if (theModel == null)
				return;
	 }
	 
 }
 
 public void setModel(DatabaseModel model){
	 this.theModel = model;
 }

 public void setView(ViewMDB view){
	 this.theView = view;
 }
 

 
}
