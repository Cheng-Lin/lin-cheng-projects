package lab06.part3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class SelectionArea extends JPanel {
	// This constant is computed by the serialver program
	// which is in the same directory as javac and java
	static final long serialVersionUID = 3726092003695431302L;
	private Rectangle2D.Double currentRect = new Rectangle2D.Double();
	private Rectangle2D.Double rectToDraw = new Rectangle2D.Double();
	private Rectangle2D.Double previousRectDrawn = new Rectangle2D.Double();
	private SelectionDemo controller;

	public SelectionArea(SelectionDemo controller) {
		setBackground(Color.WHITE);
		this.controller = controller;    		
		MyListener myListener = new MyListener(this, currentRect, 
				rectToDraw, previousRectDrawn);
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}

	@SuppressWarnings("null")
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //paints the background and image
		//Cast the Graphics context to Graphics2D
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(4));
		//If currentRect exists, paint a box on top.
		if (currentRect != null) {
			Rectangle2D.Double temp = new Rectangle2D.Double(
					rectToDraw.x, rectToDraw.y, 
					rectToDraw.width - 1, rectToDraw.height - 1);
			// the height of this rectangle is temp.getHeight()
			// the width of this rectangle is temp.getWidth()
			// use System.out.println(temp.getHeight() + " " + temp.getWidth());
			// or print the area or perimeter while developing the code
			// then remove the println when the code is working
			g2.setColor(Color.BLUE);
			g2.draw(temp);
			
			Color color = Color.YELLOW;
			g2.setColor(color);
			
			if (temp.getWidth() * temp.getHeight() > 4000) {
				color = color.darker();
				g2.setColor(color);
			}
			if (temp.getWidth() * temp.getHeight() > 16000) {
				color = color.darker();
				g2.setColor(color);
			}
			if (temp.getWidth() * temp.getHeight() > 32000) {
				color = color.brighter();
				g2.setColor(color);
			}
			if (temp.getWidth() * temp.getHeight() > 64000) {
				color = color.brighter();
				g2.setColor(color);
			}

			g2.fill(temp);
			controller.updateLabel(rectToDraw);
		}
	}

	public void updateDrawableRect(int compWidth, int compHeight) {
		double x = currentRect.x;
		double y = currentRect.y;
		double width = currentRect.width;
		double height = currentRect.height;

		//Make the width and height positive, if necessary.
		if (width < 0) {
			width = 0 - width;
			x = x - width + 1; 
			if (x < 0) {
				width += x; 
				x = 0;
			}
		}
		if (height < 0) {
			height = 0 - height;
			y = y - height + 1; 
			if (y < 0) {
				height += y; 
				y = 0;
			}
		}

		//The rectangle shouldn't extend past the drawing area.
		if ((x + width) > compWidth) {
			width = compWidth - x;
		}
		if ((y + height) > compHeight) {
			height = compHeight - y;
		}

		//Update rectToDraw after saving old value.
		if (rectToDraw != null) {
			previousRectDrawn.setFrame(
					rectToDraw.x, rectToDraw.y, 
					rectToDraw.width, rectToDraw.height);
			rectToDraw.setFrame(x, y, width, height);
		} else {
			rectToDraw = new Rectangle2D.Double(x, y, width, height);
		}
	}
}
