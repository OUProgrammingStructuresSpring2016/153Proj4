import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.security.acl.Permission;
import java.util.ArrayList;

import javax.swing.JComponent;

public class histogram extends JComponent{
	
	private static final long serialVersionUID = -9171932284611597141L;
	MediaPerson maker;
	public histogram(MediaPerson person)
	{
		maker=person;
	}
	
	
	 // Paints a histogram with three bins
	   public void paintComponent(Graphics g) {  
		   // Cast to Graphics2D
		    Graphics2D gfx = (Graphics2D) g;
		    
		    int minYear=9999;
		    int maxYear=0000;
		    ArrayList<String> works = maker.getWorks();
		    int years[] = new int[works.size()];
		    for (int i=0; i<works.size(); i++) {
		    	int firstPar = works.get(i).indexOf("(")+1;
		    	String parsed = works.get(i).substring(firstPar, firstPar+4);
		    	if (parsed =="????"){
		    		//TODO this is not perfect
		    		years[i]=years[i-1];
		    	} else {
		    		years[i] = Integer.parseInt(parsed);
		    	}
		    	if(years[i]>maxYear) maxYear=years[i];
		    	if(years[i]<minYear) minYear=years[i];
		    }
		    
		    //count up
		    int acting = 100,producing=20,directing=50;   
		    //acting = maker.getNumMoviesActed();
		   // producing = maker.getNumMoviesProduced();
		    //directing = maker.getNumMoviesDirected();
		    
		   
		   //convert String years to num years
		   int yearsTotal=maxYear-minYear;
		   //get the yearResolution on the x axis
		   //Window width-100px for padding
		   int maxDim_h=500,maxDim_w=1000;
		   int pad_x=50, pad_y=50;
		   int yearsRes= (maxDim_w-(2*pad_x))/yearsTotal;

		   
		   int actedHeight=1*acting;
		   int directedHeight=1*directing;
		   int producedHeight=1*producing;
		   
		   //ArrayList<Rectangle> al_acted = new ArrayList<Rectangle>();
		  // ArrayList<Rectangle> al_directed = new ArrayList<Rectangle>();
		   //ArrayList<Rectangle> al_produced = new ArrayList<Rectangle>();


		   for(int i=0; i<yearsTotal; i++)
		   {
			   //draw a square
			   //offset from bottom=10,right=10 
			  
			   //TODO get the #of credits for a particular year
			   int thisYearActed = 10;
			   int thisYearDirected = 10;
			   int thisYearProduced = 10;
			   
			   
			   
			   gfx.setColor(new Color(255, 0, 0)); gfx.fill( new Rectangle(pad_x+i*yearsRes,maxDim_h-pad_y-actedHeight,yearsRes, thisYearActed) );
			   gfx.setColor(new Color(0, 0, 0)); gfx.draw( new Rectangle(pad_x+i*yearsRes,maxDim_h-pad_y-actedHeight,yearsRes, thisYearActed) );
			   
			   gfx.setColor(new Color(0, 255, 0)); gfx.fill( new Rectangle(pad_x+i*yearsRes,maxDim_h-pad_y-directedHeight,yearsRes, thisYearDirected) );
			   gfx.setColor(new Color(0, 0, 0)); gfx.draw( new Rectangle(pad_x+i*yearsRes,maxDim_h-pad_y-directedHeight,yearsRes, thisYearDirected) );
			   
			   gfx.setColor(new Color(0, 0, 255)); gfx.fill( new Rectangle(pad_x+i*yearsRes,maxDim_h-pad_y-producedHeight,yearsRes, thisYearProduced) );
			   gfx.setColor(new Color(0, 0, 0)); gfx.draw( new Rectangle(pad_x+i*yearsRes,maxDim_h-pad_y-producedHeight,yearsRes, thisYearProduced) );
			   
		   }
		   
		   
		   
	      return;
	   }
}
