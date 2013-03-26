package lab8;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.event.MouseInputAdapter;

public class MyListener extends MouseInputAdapter {
    private SelectionArea drawingArea;
    private boolean dragging = false;
    private Ellipse2D.Double currentEllipse;
    private double width;
    private double height;
    private double xOffset;
    private double yOffset;
   
    public MyListener(SelectionArea drawingArea,
            Ellipse2D.Double currentEllipse) {
        this.drawingArea = drawingArea;
        this.currentEllipse = currentEllipse;
        width = currentEllipse.getWidth();
        height = currentEllipse.getHeight();
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (currentEllipse.contains(x,y)) {
            dragging = true;
            xOffset = x-currentEllipse.getX();
            yOffset = y-currentEllipse.getY();
        }
    }

    public void mouseDragged(MouseEvent e) {
        if(dragging) updateCenter(e);
        drawingArea.repaint();
    }

    public void mouseReleased(MouseEvent e) {
        if(dragging) updateCenter(e);
        dragging = false;
        drawingArea.repaint();
    }

    /*
     * Update the location of the current rectangle
     * and call repaint.  
     */
    private void updateCenter(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        currentEllipse.setFrame(x-xOffset, y-yOffset, width, height);
    }
}