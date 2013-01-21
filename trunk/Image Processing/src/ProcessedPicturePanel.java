import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class ProcessedPicturePanel extends JPanel 
	implements MouseListener, MouseMotionListener
{
	private static boolean ZOOM_IN = true, ZOOM_OUT = false;
	private static double SQRT_OF_2 = Math.sqrt(2);
	private static int WHITE_RGB = Color.white.getRGB();

	private OriginalPicturePanel origPicPanel;
	private BufferedImage picture = null, scaledPic = null, rotatedPic = null;
	private boolean moving = false, translationEnable = true;
	private boolean scaling = false, scalingEnable = true;
	private boolean affining = false, affineEnable = false;
	private int initX, initY;
	private int xShift = 0, yShift = 0, offset = 0;
	private double scalingFactor = 1.0;
	private double radianRotated = 0.0;

	public ProcessedPicturePanel(OriginalPicturePanel origPicPanel) 
	{
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		setBackground(Color.white);

		this.origPicPanel = origPicPanel;

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void setPicture(BufferedImage pictureIn)
	{		
		picture = new BufferedImage(pictureIn.getWidth(), 
				pictureIn.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		scaling(1.0);
		repaint();
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}	

	public void mousePressed(MouseEvent e) 
	{
		initX = e.getX();
		initY = e.getY();
		if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
			moving = true;
		} else if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			scaling = true;
		}
	}

	public void mouseReleased(MouseEvent e) 
	{
		int xMoved = e.getX() - initX;
		int yMoved = e.getY() - initY;
		
		if (translationEnable && moving) {
			xShift += xMoved;
			yShift += yMoved;
		} else if (scalingEnable && scaling) {
			double addFactor = (Math.sqrt(xMoved * xMoved + yMoved * yMoved)) 
					/ (this.getHeight() / 2) + 1.0;
			if (yMoved > 0) {
				scalingFactor *= addFactor;
			} else {
				scalingFactor /= addFactor;
			}
		}
		
		moving = false;
		scaling = false;
	}

	public void mouseDragged(MouseEvent e) 
	{
		int xMoved = e.getX() - initX;
		int yMoved = e.getY() - initY;
		
		if (translationEnable && moving && e.getModifiers() == MouseEvent.BUTTON1_MASK) {
			translation(xMoved, yMoved);
		} else if (scalingEnable && scaling && e.getModifiers() == MouseEvent.BUTTON3_MASK) {
			double addFactor = (Math.sqrt(xMoved * xMoved + yMoved * yMoved)) 
					/ (this.getHeight() / 2) + 1.0;		
			if (yMoved < 0) {
				scaling(1.0 / addFactor);
			} else {
				scaling(addFactor);
			}
		}
	}

	private void scaling(double addFactor) 
	{
		BufferedImage origPic = origPicPanel.getPicture();	
	
		double overallScale = scalingFactor * addFactor;
		int scaledDimension = (int)(origPic.getWidth() * overallScale);
		scaledPic = new BufferedImage(scaledDimension, scaledDimension, BufferedImage.TYPE_INT_RGB);
		
		for (int x = 0; x < scaledDimension; x++) {
			for (int y = 0; y < scaledDimension; y++) {
				try {
					scaledPic.setRGB(x, y, origPic.getRGB((int)(x / overallScale),
							(int)(y / overallScale)));
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println((int)(x / overallScale) + " " + (int)(y / overallScale));
					System.out.println(origPic.getWidth() + " " + origPic.getHeight());
				}
			}
		}
		
		int diagonal = (int)(SQRT_OF_2 * scaledPic.getWidth() + 0.5);
		offset = (diagonal - picture.getWidth()) / 2;
		rotatedPic = new BufferedImage(diagonal, diagonal, BufferedImage.TYPE_INT_RGB);
		final int RADIUS = diagonal / 2;
		final int RADIUS_2 = RADIUS * RADIUS;
		for (int y = 0; y < RADIUS; y++) 
		{
			int height = RADIUS - y;
			int end = RADIUS - (int)(Math.sqrt(RADIUS_2 - height * height) + 0.5);
			for (int x = 0; x < end; x++) 
			{
				rotatedPic.setRGB(x, y, WHITE_RGB);
				rotatedPic.setRGB(diagonal - x - 1, y, WHITE_RGB);
				rotatedPic.setRGB(x, diagonal - y - 1, WHITE_RGB);
				rotatedPic.setRGB(diagonal - x - 1, diagonal - y - 1, WHITE_RGB);
			}
		}
		rotation();
	}
	
	private void translation(int addXShift, int addYShift)
	{
		for (int x = 0; x < picture.getWidth(); x++) 
		{
			for (int y = 0; y < picture.getHeight(); y++)
			{
				int mappedX = x - xShift - addXShift + offset;
				int mappedY = y - yShift - addYShift + offset;

				if ((mappedX > rotatedPic.getWidth() - 1) || (mappedX < 0)) {
					picture.setRGB(x, y, Color.white.getRGB());
				} else if ((mappedY > rotatedPic.getHeight() - 1) || (mappedY < 0)) {
					picture.setRGB(x, y, Color.white.getRGB());
				} else {
					picture.setRGB(x, y, rotatedPic.getRGB(mappedX, mappedY));
				}
			}
		}
		repaint();
	}
	
	private void rotation() 
	{
		//BufferedImage scaleedPic = origPicPanel.getPicture();		
		final int RADIUS = rotatedPic.getHeight() / 2;
		final int RADIUS_2 = RADIUS * RADIUS;
		
		for (int y = 0; y < rotatedPic.getHeight(); y++) 
		{
			int height = Math.abs(RADIUS - y);
			int start = RADIUS - (int)(Math.sqrt(RADIUS_2 - height * height) + 0.5);
			int end = rotatedPic.getWidth() - start;
			for (int x = start; x < end; x++) 
			{
				int mappedX = (int)((x - RADIUS) * Math.cos(radianRotated) 
						+ (RADIUS - y) * Math.sin(radianRotated) + .5);
				int mappedY = (int)((RADIUS - y) * Math.cos(radianRotated) 
						- (x - RADIUS) * Math.sin(radianRotated) + .5);
				if ((mappedX >= scaledPic.getWidth() / 2) || (mappedX < -scaledPic.getWidth() / 2)) {
					rotatedPic.setRGB(x, y, Color.white.getRGB());
				} else if ((mappedY > scaledPic.getHeight() / 2) || (mappedY <= -scaledPic.getHeight() / 2)) {
					rotatedPic.setRGB(x, y, Color.white.getRGB());
				} else {
					rotatedPic.setRGB(x, y, scaledPic.getRGB(mappedX
							+ scaledPic.getWidth() / 2, scaledPic.getHeight() / 2 - mappedY));
				}
			}
		}
		translation(0, 0);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);

		if (picture != null) {
			try {
				int xOffset = (getWidth() - picture.getWidth()) / 2;
				int yOffset = (getHeight() - picture.getHeight()) / 2;
				g.drawImage(picture, xOffset, yOffset, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setScalingEnable(boolean enable) 
	{	scalingEnable = enable;		}
	
	public void setTranslationEnable(boolean enable) 
	{	translationEnable = enable;	}

	public void setAffineEnable(boolean enable) 
	{	affineEnable = enable;		}
	
	public void setRotation(int degree) 
	{
		radianRotated = degree * Math.PI / 180;
		rotation();
	}
}