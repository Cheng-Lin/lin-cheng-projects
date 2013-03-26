package lab8;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class SelectionArea extends JPanel {
	static final long serialVersionUID = 3726092003695431302L;
	private Ellipse2D.Double oval1 = new Ellipse2D.Double(10,10,100,50);
	private Ellipse2D.Double oval2 = new Ellipse2D.Double(150,150,100,50);
	private Line2D.Double connector;
	private Line2D.Double connector2;

	public SelectionArea() {
		MyListener myListener1 = new MyListener(this, oval1);
		MyListener myListener2 = new MyListener(this, oval2);
		addMouseListener(myListener1);
		addMouseMotionListener(myListener1);
		addMouseListener(myListener2);
		addMouseMotionListener(myListener2);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //paints the background and image
		//Cast the Graphics context to Graphics2D
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.BLUE);
		g2.draw(oval1);
		g2.draw(oval2);
		computeConnector();
		if(connector != null) {
			g2.setColor(Color.MAGENTA);
			g2.draw(connector);
			//g2.draw(connector2);
		}
	}

	private void computeConnector() {
		//compute the line that joins the centers
		//of the 2 ellipses but only shows the points
		//You can go online for help to solve tshis
		//with Math
		//Or you can compute the angle theta of the line
		//between the two centers of the ellipses
		//and start (x,y) from the center of one
		//ellipse and move in increments of (cos theta, sin theta)
		//along the line until you reach a point just
		//outside the Ellipse (ellipse.contains should
		//work but if not, use some Math).
		//That gives one end of the line, then work back from
		//the other center to find the other end of the
		//line.
		//SEE the graphic attached to Lab 8
		double x1 = oval1.getCenterX();
		double y1 = oval1.getCenterY();
		double x2 = oval2.getCenterX();
		double y2 = oval2.getCenterY();

		double radian = 0;
		double cosTheta = 0;

		
		if (x2 > x1) {
			radian = Math.atan((y2 - y1) / (x2 - x1));
			cosTheta = Math.cos(-radian);
		} else {
			radian = Math.atan((y2 - y1) / (x1 - x2));
			cosTheta = -Math.cos(radian);
		}
		
		double sinTheta = Math.sin(radian);
		
		while (oval1.contains(x1, y1))
		{
			x1 += cosTheta;
			y1 += sinTheta;
		}

		while (oval2.contains(x2, y2))
		{
			x2 -= cosTheta;
			y2 -= sinTheta;
		}

		connector = new Line2D.Double(x1, y1, x2, y2);
		//connector2 = new Line2D.Double(oval1.getCenterX(), oval1.getCenterY(), oval2.getCenterX(), oval2.getCenterY());
	}
}

