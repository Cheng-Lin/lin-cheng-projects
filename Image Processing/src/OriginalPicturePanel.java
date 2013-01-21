import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class OriginalPicturePanel extends JPanel 
{
	private ProcessedPicturePanel procPicPanel;
	private BufferedImage origPic, compressedPic;
	
	public OriginalPicturePanel() 
	{
	    setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	    setBackground(Color.white);
	}
	
	public void createNewPicture() {
		int size = Math.min(getHeight() - 4, getWidth() - 4);
		compressedPic = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		repaint();
	}
	
	public void setPanel(ProcessedPicturePanel procPicPanel)
	{	this.procPicPanel = procPicPanel;	}
	
	public void setPicture(BufferedImage targetPic) 
	{
		origPic = targetPic;
		repaint();
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		if (origPic != null)
		{
			int origHeight = origPic.getHeight();
			int origWidth = origPic.getWidth();
//			final int ORIG_FACTOR = Math.max(origHeight, origWidth);
//			double origXFactor = (double)origWidth / ORIG_FACTOR;
//			double origYFactor = (double)origHeight / ORIG_FACTOR;
			
			int compHeight = compressedPic.getHeight();
			int compWidth = compressedPic.getWidth();
			double compXFactor = (double)origWidth / compWidth;
			double compYFactor = (double)origHeight / compHeight;
			
			for (int x = 0; x < compWidth; x++) {
				for (int y = 0; y < compHeight; y++) {
					double mappedX = (x * compXFactor);
					double mappedY = (y * compYFactor);					
					compressedPic.setRGB(x, y, origPic.getRGB((int)mappedX, (int)mappedY));
				}
			}
			
			procPicPanel.setPicture(compressedPic);
			
		    try {
		    	int xOffset = (getWidth() - compWidth) / 2;
		    	int yOffset = (getHeight() - compHeight) / 2;
		        g.drawImage(compressedPic, xOffset, yOffset, null);
		    } catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "File Corrupted", 
						"Corrupted File", JOptionPane.ERROR_MESSAGE);
		    }
		}
	}
	
	public BufferedImage getPicture()
	{	return compressedPic;	}
}
