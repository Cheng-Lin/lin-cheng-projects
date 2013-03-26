package lab3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class providing a GUI to collect information
 * about a Room in a House
 * @author CS 140
 *
 */
public class RoomInformation {
	private String[] labels = {"Room Type: ", "Length: ", "Width: "};
	private RoomType[] types = RoomType.values();
	private String[] roomTypeNames = new String[types.length+1];
	private Map<String, RoomType> roomTypeMap = new HashMap<String, RoomType>();
	{ // initialization block
		for(int i = 0; i < types.length; i++) {
			roomTypeNames[i] = types[i].getDescription();
			roomTypeMap.put(types[i].getDescription(), types[i]);
		}
		roomTypeNames[types.length] = "AAAAA"; // this is a dirty trick
		Arrays.sort(roomTypeNames); // alphabetize the names
		roomTypeNames[0] = "Select...";	// replace "AAAAA" by "Select..."
		// since AAAAA would come first after sorting, we have ensured that
		// putting "Select..." at the start of the array will not remove any
		// of the Strings we need to keep in the array.
	}
	private JComboBox<String> roomTypeChooser = new JComboBox<String>(roomTypeNames);
	private JTextField lengthField = new JTextField();
	private JTextField widthField = new JTextField();
	private JButton submit = new JButton("Submit"); 

	/**
	 * Method to set up a GUI to collect the basic
	 * information about a room
	 * @return a JPanel containing the Swing components
	 * that will accept the information about a room
	 */
	public JPanel createRoomPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel labelsPanel = new JPanel();
		labelsPanel.setLayout(new GridLayout(0,1));
		for(String str : labels) {
			labelsPanel.add(new JLabel(str,JLabel.RIGHT));
		}
		labelsPanel.setPreferredSize(new Dimension(200,40));
		JPanel valuesPanel = new JPanel();
		valuesPanel.setLayout(new GridLayout(0,1));
		valuesPanel.add(roomTypeChooser);
		valuesPanel.add(lengthField);
		valuesPanel.add(widthField);
		
		panel.add(labelsPanel, BorderLayout.CENTER);
		panel.add(valuesPanel, BorderLayout.LINE_END);
		panel.add(submit, BorderLayout.PAGE_END);
		return panel;
	}
	
	/**
	 * Setter method for the listener on the Submit button
	 * @param listener ActionListener for the submit 
	 * button
	 */
	public void setSubmitListener(ActionListener listener) {
		submit.addActionListener(listener);
	}
	
	/**
	 * Method to create a Room2 object from the information
	 * provided in the GUI for room creation
	 * @return a new room object with the selected information
	 * @throws RoomCreationException if any information is missing
	 */
	public Room2 createRoom() throws RoomCreationException {
		Room2 returnValue = null;
		int selection = roomTypeChooser.getSelectedIndex();
		double length = 0;
		double width = 0;
		String type = "Select...";
		if(selection != -1) {
			type = roomTypeChooser.getItemAt(selection);
		}
		try {
			length = Double.parseDouble(this.lengthField.getText().trim());
			width = Double.parseDouble(this.widthField.getText().trim());
		} catch (NumberFormatException ex) {
			throw new RoomCreationException("Length or Width missing or badly formatted");
		}
		if(!type.equals("Select...") && length > 0 && width > 0) {
			RoomType rtype = roomTypeMap.get(type);
			returnValue = new Room2(rtype, length, width);
		} else {
			throw new RoomCreationException("No room type selected or length or width is zero");			
		}
		return returnValue;
	}

	/**
	 * Main method to test this class
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame testFrame = new JFrame("Testing RoomInformation");
		RoomInformation obj = new RoomInformation();
		testFrame.add(obj.createRoomPanel());
		testFrame.pack();
		obj.setSubmitListener(new SubmitListener(obj));
		testFrame.setLocationRelativeTo(null);
		testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(testFrame, "This JFrame only tests " +
				"RoomInformation.java\n");
	}
	
	/**
	 * Sample ActionListener class. Does error checking
	 * on the inputs.
	 * @author CS 140
	 *
	 */
	private static class SubmitListener implements ActionListener {
		private RoomInformation obj;
		/**
		 * Constructor which sets the call back object
		 * for the listener.
		 * @param obj the GUI object that contains the
		 * data to be error checked
		 */
		public SubmitListener(RoomInformation obj) {
			this.obj = obj;
		}
		/**
		 * Action that checks the validity of the input data.
		 * @param e the action event passed to the listener
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				JOptionPane.showMessageDialog(null, obj.createRoom());
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (RoomCreationException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}

	/**
	 * Method to make the components in this panel
	 * enabled or disabled
	 * @param b if true the components should be enabled
	 * otherwise disabled
	 */
	public void makeActive(boolean b) {
		roomTypeChooser.setEnabled(b);
		lengthField.setEnabled(b);
		widthField.setEnabled(b);
		submit.setEnabled(b);		
	}
}
