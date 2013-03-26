package lab06.part3;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.event.MouseInputAdapter;

public class MyListener extends MouseInputAdapter {
	private SelectionArea drawingArea;
	private Rectangle2D.Double currentRect;
	private Rectangle2D.Double rectToDraw;
	private Rectangle2D.Double previousRectDrawn;
	
	public MyListener(SelectionArea drawingArea, 
			Rectangle2D.Double currentRect,
			Rectangle2D.Double rectToDraw, 
			Rectangle2D.Double previousRectDrawn) {
		super();
		this.drawingArea = drawingArea;
		this.currentRect = currentRect;
		this.rectToDraw = rectToDraw;
		this.previousRectDrawn = previousRectDrawn;		
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		currentRect.setRect(x, y, 0, 0);
		drawingArea.updateDrawableRect(drawingArea.getWidth(), 
				drawingArea.getHeight());
		drawingArea.repaint();
	}

	public void mouseDragged(MouseEvent e) {
		updateSize(e);
	}

	public void mouseReleased(MouseEvent e) {
		updateSize(e);
	}

	/* 
	 * Update the size of the current rectangle
	 * and call repaint.  Because currentRect
	 * always has the same origin, translate it
	 * if the width or height is negative.
	 * 
	 * For efficiency (though
	 * that isn't an issue for this program),
	 * specify the painting region using arguments
	 * to the repaint() call.
	 * 
	 */
	private void updateSize(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		currentRect.setRect(currentRect.x, currentRect.y,
				x - currentRect.x, y - currentRect.y);
		drawingArea.updateDrawableRect(drawingArea.getWidth(), 
				drawingArea.getHeight());
		Rectangle2D.Double totalRepaint = new Rectangle2D.Double(); 
		Rectangle2D.Double.union(rectToDraw, previousRectDrawn, totalRepaint);
		drawingArea.repaint((int)totalRepaint.x-4, (int)totalRepaint.y-4,
				(int)totalRepaint.width+5, (int)totalRepaint.height+5);
	}
}
