package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaController {
 
	private ViewMDB DatabaseView;
	private DatabaseModel DatabaseModel;
 
 public MediaController(ViewMDB DatabaseView, DatabaseModel DatabaseModel){
	 this.DatabaseView = DatabaseView;
	 this.DatabaseModel = DatabaseModel;
	 this.DatabaseView.addSelectionListener(new SelectionListener());
	 this.DatabaseView.addPieChartListener(new PiechartListener());
	 this.DatabaseView.addHistogramListener(new HistogramListener());
 }
 
class SelectionListener implements ActionListener{
	 public void actionPerformed(ActionEvent actionEvent ){
	 	 
	 }
}

 class PieChartListener implements ActionListener{
	 public void actionPerformed(ActionEvent actionEvent){
		 
	 }
	 
 }
 class HistogramListener implements ActionListener{
	 public void actionPerformed(ActionEvent ActionEvent){
		 
	 }
	 
 }
 class DeleteListener implements ActionListener{
	 public void actionPerformed(ActionEvent ActionEvent){
		 
	 }
	 
 }
 class AddListener implements ActionListener{
	 public void actionPerformed(ActionEvent ActionEvent){
		 
	 }
	 
 }
 class EditListener implements ActionListener{
	 public void actionPerformed(ActionEvent ActionEvent){
		 
	 }
	 
 }
 class ClearListener implements ActionListener{
	 public void actionPerformed(ActionEvent ActionEvent){
		 
	 }
	 
 }
 class ExportListener implements ActionListener{
	 public void actionPerformed(ActionEvent ActionEvent){
		 
	 }
	 
 }
 class ImportListener implements ActionListener{
	 public void actionPerformed(ActionEvent ActionEvent){
		 
	 }
	 
 }
 class LoadListener implements ActionListener{
	 public void actionPerformed(ActionEvent ActionEvent){
		 
	 }
	 
 }
 class SaveListener implements ActionListener{
	 public void actionPerformed(ActionEvent ActionEvent){
		 
	 }
	 
 }
 public DatabaseController(){
	 
 }
 public void setModel(){
		this.DatabaseModel = DatabaseModel;
 }

 public void setView(){
	 this.DatabaseView = DatabaseView; 
 }

 
}
