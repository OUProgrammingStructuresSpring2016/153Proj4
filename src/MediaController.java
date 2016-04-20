import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MediaController {
 
	private View ViewMDB;
	private Model DatabaseModel;
 
 public MediaController(MediaView ViewMDB, MediaModel DatabaseModel){
	 this.ViewMDB = DatabaseView;
	 this.DatabaseModel = DatabaseModel;
	 this.ViewMDB.addSelectionListener(new SelectionListener());
	 this.ViewMDB.addPieChartListener(new PieChartListener());
	 this.ViewMDB.addHistogramListener(new HistogramListener());
	 this.ViewMDB.addDeleteListener(new DeleteListener());
	 this.ViewMDB.addAddListener(new AddListener());
	 this.ViewMDB.addEditListener(new EditListener());
	 this.ViewMDB.addClearListener(new ClearListener());
	 this.ViewMDB.addExportListener(new ExportListener());
	 this.ViewMDB.addImportListener(new ImportListener());
	 this.ViewMDB.addLoadListener(new LoadListener());
	 this.ViewMDB.addSaveListener(new SaveListener());
	 
	 
 }
 class SelectionListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
	 	 
	 }
	 
 }
 class PieChartListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 class HistogramListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 class DeleteListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 class AddListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 class EditListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 class ClearListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 class ExportListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 class ImportListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 class LoadListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 class SaveListener implements ActionListener{
	 public void actionPerformed(ActionEvent arg0){
		 
	 }
	 
 }
 public DatabaseController(){}
 public void setModel(DatabaseModel model){
	 this.model = model;
 }

 public void setView(ViewMDB View){
	 this.ViewMDB = view;
 }
 

 
}
