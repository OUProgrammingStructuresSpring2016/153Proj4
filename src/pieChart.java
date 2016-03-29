import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;

public class pieChart extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1345340232316547120L;
	MediaPerson mediaPerson;
	
	 public pieChart(MediaPerson person)
	 {
		 mediaPerson=person;
	 }
	
	 public void paintComponent(Graphics g) {  
	    // Cast to Graphics2D
	    Graphics2D gfx = (Graphics2D) g;
	    
	    //tally up
	    int movieActing = mediaPerson.getNumMoviesActed(), movieProducing=mediaPerson.getNumMoviesProduced(),movieDirecting=mediaPerson.getNumMoviesDirected();
	    int seriesActing = mediaPerson.getNumSeriesActed(),seriesProducing=mediaPerson.getNumSeriesProduced(),seriesDirecting=mediaPerson.getNumSeriesDirected();
	    	    	    
	    
	    //number of radians per each entry
	    double radRes = 2*3.14 / (movieActing+movieProducing+movieDirecting+
	    		seriesActing+seriesProducing+seriesDirecting);
	    int movieActing_start = 0;
	    int movieActing_finish = (int) (movieActing_start+movieActing*radRes);
	    
	    if(movieActing_finish == 0)
	    	movieActing_finish = 1;

	    int movieProducing_start = (int) movieActing_finish;
	    int movieProducing_finish = (int) (movieProducing_start +movieProducing*radRes);
	    
	    if(movieProducing_finish == movieProducing_start)
	    	movieProducing_finish = movieProducing_start++;
	    
	    int movieDirecting_start = (int) movieProducing_finish;
	    int movieDirecting_finish = (int) (movieDirecting_start +movieDirecting*radRes);
	    
	    if(movieDirecting_start == movieDirecting_finish)
	    	movieDirecting_start = movieDirecting_finish++;
	    
	    int seriesActing_start = (int) movieDirecting_finish;
	    int seriesActing_finish = (int) (seriesActing_start +seriesActing*radRes);
	    
	    if(seriesActing_start == seriesActing_finish)
	    	seriesActing_start = seriesActing_finish+1;

	    int seriesProducing_start = (int) seriesActing_finish;
	    int seriesProducing_finish = (int) (seriesProducing_start +seriesProducing*radRes);
	    
	    if(seriesProducing_start == seriesProducing_finish)
	    	seriesProducing_start = seriesProducing_finish++;
	    
	    int seriesDirecting_start = (int) seriesProducing_finish;
	    int seriesDirecting_finish = (int) (seriesDirecting_start +seriesDirecting*radRes);
	    
	    if(seriesDirecting_start == seriesDirecting_finish)
	    	seriesDirecting_start = seriesDirecting_finish++;
	    //TODO handle the case where you got a zero slice
	    //NOTE: attempted to handle by assigning a value of 1 to zero slices
	    
	    
	    //half way radian points for drawing arcs
	    float halfWayPts[]= {
	    		(movieActing_start+movieActing_finish)/2,
	    		(movieProducing_start+movieProducing_finish)/2,
	    		(movieDirecting_start+movieDirecting_finish)/2,
	    		
	    		(seriesDirecting_start+seriesDirecting_finish)/2,
	    		(seriesDirecting_start+seriesDirecting_finish)/2,
	    		(seriesDirecting_start+seriesDirecting_finish)/2	    		
	    };
	    //two arrays containing the X,Y coordinates to draw a single slice
	    float x_cords[]={
	    		(float)Math.cos(movieActing_start),    (float)Math.cos(movieActing_finish),250,
	    		(float)Math.cos(movieProducing_start), (float)Math.cos(movieProducing_finish),250,
	    		(float)Math.cos(movieDirecting_start), (float)Math.cos(movieDirecting_finish),250,
	    		
	    		(float)Math.cos(seriesActing_start),   (float)Math.cos(seriesActing_finish),250,
	    		(float)Math.cos(seriesProducing_start),(float)Math.cos(seriesProducing_finish),250,
	    		(float)Math.cos(seriesDirecting_start),(float)Math.cos(seriesDirecting_finish),250,};
	    
	    float y_cords[]={
	    		(float)Math.sin(movieActing_start),    (float)Math.sin(movieActing_finish),250,
	    		(float)Math.sin(movieProducing_start), (float)Math.sin(movieProducing_finish),250,
	    		(float)Math.sin(movieDirecting_start), (float)Math.sin(movieDirecting_finish),250,
	    		
	    		(float)Math.sin(seriesActing_start),   (float)Math.sin(seriesActing_finish),250,
	    		(float)Math.sin(seriesProducing_start),(float)Math.sin(seriesProducing_finish),250,
	    		(float)Math.sin(seriesDirecting_start),(float)Math.sin(seriesDirecting_finish),250,};

	    //draw the slices using GeneralPath
	    GeneralPath fullPie = new GeneralPath();
	    fullPie.moveTo(250, 250);
	    

	    for(int i=0; i<halfWayPts.length; i+=1)
	    {
	    	fullPie.lineTo(x_cords[i],y_cords[i]);
	    	fullPie.quadTo(Math.cos(halfWayPts[i]),Math.sin(halfWayPts[i]),x_cords[i+1],y_cords[i+1]);
	    	fullPie.lineTo(x_cords[i+2],y_cords[i+2]);
	    	}
	    fullPie.closePath();
	    gfx.draw(fullPie);

	    return;
	 }
}

