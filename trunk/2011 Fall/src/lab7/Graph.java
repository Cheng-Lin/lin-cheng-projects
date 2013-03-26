package lab7;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * A component that draws a graph 
 * @author CS 140
 */
public class Graph extends JComponent {
	
	private Path2D.Double path1 = new Path2D.Double();
	private Path2D.Double path2 = new Path2D.Double();
	private Path2D.Double path3 = new Path2D.Double();
	private double[] x;
	private double[] y;
	private double[] z;
	private double[] to3;
	// radius of dot on graph
	private int r = 5;

	/**
	 * Constructor for the Graph. It takes two
	 * arrays, which are the x and y coordinates
	 * of the path that will be drawn by this
	 * component 
	 * @param x x-coordinates of points on path
	 * @param y y-coordinates of points on path
	 */
	public Graph(double[] x, double[] y, double[] z, double[] to3) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.to3 = to3; 
		if(x.length != y.length || x.length != z.length) {
			JOptionPane.showMessageDialog(this, "Cannot make a graph." +
					"\nArrays have different length");
		}
		path1.moveTo(x[0], y[0]);
		for(int i = 1; i < x.length; i++) {
			path1.lineTo(x[i], y[i]);
		}
		path2.moveTo(x[0], z[0]);
		for(int i = 1; i < x.length; i++) {
			path2.lineTo(x[i], z[i]);
		}
		path3.moveTo(x[0], to3[0]);
		for (int i = 1; i < x.length; i++) {
			path3.lineTo(x[i], to3[i]);
		}
	}


	/**
	 * Implementation of the paintComponent method
	 * for this component. It draws the path and
	 * the set of points on the path.
	 */
	@Override
	public void paintComponent(Graphics g)
	{  
		super.paintComponent(g);
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.BLUE);
		g2.draw(path1);
		g2.setColor(Color.BLACK);
		for(int i = 0; i < x.length; i++)
		g2.fill(new Ellipse2D.Double(x[i]-r,y[i]-r,2*r,2*r));
		g2.setColor(Color.RED);
		g2.draw(path2);
		g2.setColor(Color.BLACK);
		for(int i = 0; i < x.length; i++)
		g2.fill(new Ellipse2D.Double(x[i]-r,z[i]-r,2*r,2*r));
		g2.setColor(Color.GREEN);
		g2.draw(path3);
		g2.setColor(Color.BLACK);
		for(int i = 0; i < x.length; i++)
		g2.fill(new Ellipse2D.Double(x[i]-r,to3[i]-r,2*r,2*r));
	}
}
