package lab06.part3;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
/* 
 * When the user drags within the area of the JFrame, 
 * this program displays a rectangle and a string
 * indicating the bounds of the rectangle.
 */
public class SelectionDemo {
	private JLabel label;

	private void buildUI(Container container) {
		container.setLayout(new BoxLayout(container,
				BoxLayout.PAGE_AXIS));

		SelectionArea area = new SelectionArea(this);
		container.add(area);
		label = new JLabel("Drag within the image.");
		label.setLabelFor(area);
		container.add(label);
		//Align the left edges of the components.
		area.setAlignmentX(Component.LEFT_ALIGNMENT);
	}


	public void updateLabel(Rectangle2D.Double rect) {
		double width = rect.width;
		double height = rect.height;
		//Make the coordinates look OK if a dimension is 0.
		if (width == 0) {
			width = 1;
		}
		if (height == 0) {
			height = 1;
		}
		label.setText("Perimeter: ("
				+ (width + height) * 2 + ") Area: ("
				+ (height * width) + ")");
	}

	/**
	 * Create the GUI and show it.  For thread safety, 
	 * this method should be invoked from the 
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Make sure we have nice window decorations.
		JFrame.setDefaultLookAndFeelDecorated(true);
		//Create and set up the window.
		JFrame frame = new JFrame("SelectionDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set up the content pane.
		SelectionDemo controller = new SelectionDemo();
		controller.buildUI(frame.getContentPane());

		//Display the window.
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
			}
		});
	}

}