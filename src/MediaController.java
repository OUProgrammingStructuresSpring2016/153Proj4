public class MediaController {
 
	private View DatabaseView;
	private Model DatabaseModel;
 
 public MediaController(MediaView DatabaseView, MediaModel DatabaseModel){
	 this.DatabaseView = DatabaseView;
	 this.DatabaseModel = DatabaseModel;
	 this.DatabaseView.addSelectionListener(new SelectionListener());
	
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
 public void setModel(){}
 public getModel(){}
 public void setView(){}
 public getView(){}
 
 
}
