import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

class Slice {
	double value;
	Color color;
	
	public Slice(double val, Color col){
		value = val;
		color = col;
	}
}

public class PieChartJ extends JComponent{

	private static final long serialVersionUID = 2506771643438428547L;
	
	MediaPerson mediaPerson;
	Slice[] slices;
	
	public PieChartJ(MediaPerson p){
		mediaPerson = p;
		Slice[] temp = {new Slice(mediaPerson.getNumMoviesActed(), Color.BLUE), new Slice(mediaPerson.getNumMoviesDirected(), Color.CYAN),
				new Slice(mediaPerson.getNumMoviesProduced(), Color.PINK), new Slice(mediaPerson.getNumSeriesActed(), Color.RED), 
				new Slice(mediaPerson.getNumSeriesDirected(), Color.ORANGE), new Slice(mediaPerson.getNumSeriesProduced(), Color.GREEN)};
		slices = temp;
	}
	

	
	public void paint(Graphics g){
		
		drawPie((Graphics2D) g, getBounds(), slices);
		
	}
	
	private void drawPie(Graphics2D g, Rectangle area, Slice[] slices ){
		 double total = 0.0D;
		    for (int i = 0; i < slices.length; i++) {
		      total += slices[i].value;
		    }

		    double curValue = 0.0D;
		    int startAngle = 0;
		    for (int i = 0; i < slices.length; i++) {
		      startAngle = (int) (curValue * 360 / total);
		      int arcAngle = (int) (slices[i].value * 360 / total);

		      g.setColor(slices[i].color);
		      g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
		      curValue += slices[i].value;
		    }
		    
		    
		    g.setColor(slices[0].color); g.fill( new Rectangle(10, 10, 25,25) ); g.drawString("Movies Acted", 40, 35);
		    g.setColor(slices[1].color); g.fill( new Rectangle(10, 35, 25,25) );g.drawString("Series Acter", 40, 60);
		    g.setColor(slices[2].color); g.fill( new Rectangle(10, 60, 25,25) );g.drawString("Movies Produced", 40, 85);
		    g.setColor(slices[3].color); g.fill( new Rectangle(10, 85, 25,25) );g.drawString("Series Produced", 40, 110);
		    g.setColor(slices[4].color); g.fill( new Rectangle(10, 110, 25,25) );g.drawString("Movies Directed", 40, 135);
		    g.setColor(slices[5].color); g.fill( new Rectangle(10, 135, 25,25) );g.drawString("Series Directed", 40, 160);

		    
		 }
	

}
