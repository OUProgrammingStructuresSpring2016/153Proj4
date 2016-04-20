package src;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
		    
		    int minYear=1896;
		    int maxYear=2017;
		   

		   
		   //convert String years to num years
		   int yearsTotal=maxYear-minYear;
		   //get the yearResolution on the x axis
		   //Window width-100px for padding
		   int maxDim_h=1000,maxDim_w=1000;
		   int pad_x=50, pad_y=50;
		   int yearsRes= (maxDim_w-(2*pad_x))/yearsTotal;

		   //move along x and draw in y direction
		   int iter=0;
		 
		   
		   for(int i=minYear; i<maxYear; i++)
		   {
			   
			   ArrayList<Integer> creds = maker.getCredits(i);
			   
			   //get the #of credits for a particular year			   
			   int mAct = creds.get(1)*7;
			   int mDir = creds.get(2)*7;
			   int mProd = creds.get(3)*7;
			   int sAct = creds.get(4)*7;
			   int sDir = creds.get(5)*7;
			   int sProd = creds.get(6)*7;
			   
			   //mAct=100; mDir=230; mProd=50;
			   
			   //legend
			   gfx.setColor(new Color(255, 0, 0)); gfx.fill( new Rectangle(100, 100, 25,25) ); gfx.drawString("Movies Acted", 130, 115);
			   gfx.setColor(new Color(255, 255, 0)); gfx.fill( new Rectangle(100, 125, 25,25) );gfx.drawString("Series Acter", 130, 140);
			   gfx.setColor(new Color(0, 255, 0)); gfx.fill( new Rectangle(100, 150, 25,25) );gfx.drawString("Movies Produced", 130, 165);
			   gfx.setColor(new Color(173,255,47)); gfx.fill( new Rectangle(100, 175, 25,25) );gfx.drawString("Series Produced", 130, 190);
			   gfx.setColor(new Color(0, 0, 255)); gfx.fill( new Rectangle(100, 200, 25,25) );gfx.drawString("Movies Directed", 130, 215);
			   gfx.setColor(new Color(0, 191, 255)); gfx.fill( new Rectangle(100, 225, 25,25) );gfx.drawString("Series Directed", 130, 240);

			   gfx.setColor(new Color(255, 0, 0)); gfx.fill( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mAct,yearsRes, mAct) );
			   gfx.setColor(new Color(0, 0, 0)); gfx.draw( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mAct,yearsRes, mAct) );
			   gfx.setColor(new Color(255, 255, 0)); gfx.fill( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mAct-sAct,yearsRes, sAct) );
			   gfx.setColor(new Color(0, 0, 0)); gfx.draw( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mAct-sAct,yearsRes, sAct) );
			  // AffineTransform old = gfx.getTransform();
			 //  gfx.rotate(Math.toRadians(90));
			  // gfx.drawString(Integer.toString(creds.get(0)), pad_x+iter*yearsRes, maxDim_h-pad_y-mAct-sAct-10);
			 //  gfx.setColor(new Color(255,0,0));gfx.drawString("TESTESTETSETSETESTES", 200, 200);

			  // gfx.setTransform(old);


			   
			   
			   gfx.setColor(new Color(0, 255, 0)); gfx.fill( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mDir,yearsRes, mDir) );
			   gfx.setColor(new Color(0, 0, 0)); gfx.draw( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mDir,yearsRes, mDir) );
			   gfx.setColor(new Color(173,255,47)); gfx.fill( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mDir-sDir,yearsRes, sDir) );
			   gfx.setColor(new Color(0, 0, 0)); gfx.draw( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mDir-sDir,yearsRes, sDir) );
			   
			   gfx.setColor(new Color(0, 0, 255)); gfx.fill( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mProd,yearsRes, mProd) );
			   gfx.setColor(new Color(0, 0, 0)); gfx.draw( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mProd,yearsRes, mProd) );
			   gfx.setColor(new Color(0,191,255)); gfx.fill( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mProd-sProd,yearsRes, sProd) );
			   gfx.setColor(new Color(0, 0, 0)); gfx.draw( new Rectangle(pad_x+iter*yearsRes,maxDim_h-pad_y-mProd-sProd,yearsRes, sProd) );
			   
			   iter++;
			   
		   }
		   
		   
		   
	      return;
	   }
}