package assignment02;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Question2
{
    private static File file;
    private static PrintWriter printWriter;
 
    public static void main(String[] args) throws FileNotFoundException
    {
    	// LET ECLIPSE INSERT THE THROWS CLAUSE 
        JFileChooser jfc = new JFileChooser();
        int selection = jfc.showSaveDialog(null);
        if(selection == JFileChooser.APPROVE_OPTION)
        {
            file = jfc.getSelectedFile();
        }
        if (file == null) {
            JOptionPane.showMessageDialog(null, "You did not select a " +
                "file\nThe program cannot continue");
        } else {
            JFrame frame = new JFrame("Question 2");
            printWriter = new PrintWriter(file);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(new ApplicationListener());
             frame.setLocationRelativeTo(null);
            frame.add(new ButtonComponent(printWriter));
            frame.pack();
            frame.setVisible(true);
        }
    }

    private static class ApplicationListener extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent arg0)
        {
            if (printWriter != null)
            {
                printWriter.close();
            }
            System.exit(0);
        }
    }
}
