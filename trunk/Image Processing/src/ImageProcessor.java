import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;

public class ImageProcessor extends JFrame 
{
	private OriginalPicturePanel orgPicPanel;
	private ProcessedPicturePanel procPicPanel;
	
	public ImageProcessor()
	{
		super("Image Processor");
		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent arg0) {
				orgPicPanel.createNewPicture();
			}
		});
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		AppMenuBar appMenus = new AppMenuBar(this);
		setJMenuBar(appMenus);
		
		JPanel imgPanels = new JPanel();
		imgPanels.setLayout(new GridLayout(1, 2));
		
		orgPicPanel = new OriginalPicturePanel();		
		procPicPanel = new ProcessedPicturePanel(orgPicPanel);
		orgPicPanel.setPanel(procPicPanel);
		
		imgPanels.add(orgPicPanel);
		imgPanels.add(procPicPanel);
		
		ControlPanel ctrlPanel = new ControlPanel(this);
		
		Container c = getContentPane();
		c.add(imgPanels, BorderLayout.CENTER);
		c.add(ctrlPanel, BorderLayout.SOUTH);
	}
	
	public void loadPicture() 
	{
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter extFilter = new FileNameExtensionFilter("JPEG Image (.jpg)", "jpg");
		fc.setFileFilter(extFilter);
		
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				BufferedImage targetPic = ImageIO.read(fc.getSelectedFile());
				orgPicPanel.setPicture(targetPic);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Invalid File Choosen", 
						"Invalid File", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void scalingEnable(boolean enable) {
		procPicPanel.setScalingEnable(enable);
	}	
	
	public void translationEnable(boolean enable) {
		procPicPanel.setTranslationEnable(enable);
	}

	public void setRotation(int degree) {
		procPicPanel.setRotation(degree);
	}
	
	public static void main(String[] args) 
	{
		ImageProcessor driver = new ImageProcessor();
		driver.setSize(608, 395);
		driver.show();
	}
}
