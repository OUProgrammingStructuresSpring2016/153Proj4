public class MediaController {
 
	private View DatabaseView;
	private Model DatabaseModel;
 
 public MediaController(MediaView DatabaseView, MediaModel DatabaseModel){
	 this.DatabaseView = DatabaseView;
	 this.DatabaseModel = DatabaseModel;
	 this.DatabaseView.addSelectionListener(new SelectionListener());
	 this.DatabaseView.addPieChartListener(new PiechartListener());
	 this.DatabaseView.addHistogramListener(new HistogramListener());
	 
 }
 class SelectionListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
	 	 
	 }
	 
 }
 class PieChartListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 class HistogramListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 class DeleteListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 class AddListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 class EditListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 class ClearListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 class ExportListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 class ImportListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 class LoadListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 class SaveListener implements ActionListener{
	 public void actionPerformed(ActionEvent ){
		 
	 }
	 
 }
 public DatabaseController(){}
 public void setModel(){}
 public getModel(){}
 public void setView(){}
 public getView(){}
 
 
}
