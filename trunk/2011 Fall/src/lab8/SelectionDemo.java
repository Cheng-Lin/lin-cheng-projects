package lab8;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Container;
/*
 * User can move the two ellipses. This program
 * is intended to draw a connecting line between
 * the two ellipses. 
 */
public class SelectionDemo {
    private JLabel label;

    private void buildUI(Container container) {
        container.setLayout(new BoxLayout(container,
                BoxLayout.PAGE_AXIS));

        SelectionArea area = new SelectionArea();
        container.add(area);
        label = new JLabel("Drag within the image.");
        label.setLabelFor(area);
        container.add(label);
        //Align the left edges of the components.
        area.setAlignmentX(Component.LEFT_ALIGNMENT);
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