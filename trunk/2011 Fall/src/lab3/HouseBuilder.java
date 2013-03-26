package lab3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class HouseBuilder {
	private JFrame frame = new JFrame("House Builder");
	private HouseInformation houseInf;
	private RoomInformation roomInf;
	private ApplicationModel model;	

	public HouseBuilder(ApplicationModel model) {
		this.model = model;
		houseInf = model.getHouseInf();
		roomInf = model.getRoomInf();
		houseInf.setNewRoomListener(new NewRoomListener());
		houseInf.setNewHouseListener(new NewHouseListener());
		houseInf.setSaveHousesListener(new SaveHousesListener());
		houseInf.setOpenHousesListener(new OpenHousesListener());
		roomInf.setSubmitListener(new SubmitListener());
		roomInf.makeActive(false);
		
		// Note a JFrame has a BorderLayout by default
		// ADD houseInf.createHousePanel() TO THE CENTER OF frame
		// ADD roomInf.createRoomPanel() TO THE PAGE_END OF frame
		// SET THE SIZE OF frame TO 600x500
		// SET THE LOCATION OF THE frame TO BE RELATIVE TO null
		// SET THE DEFAULT CLOSE OPERATION OF frame TO BE EXIT_ON_CLOSE,
		// WHICH IS A CLASS CONSTANT IN JFrame
		// MAKE frame VISIBLE
		frame.add(houseInf.createHousePanel(), BorderLayout.CENTER);
		frame.add(roomInf.createRoomPanel(), BorderLayout.PAGE_END);
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// Ask the TA to explain how to do these steps if they
		// are not obvious to you
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// THE Java TUTORIAL TELLS US TO START GUIS
		// LIKE THIS:
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ApplicationModel model = new ApplicationModel();
				new HouseBuilder(model);
			}
		});
	}

	// ACTION LISTENER TO MAKE A NEW ROOM
	private class NewRoomListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getCurrentHouse() == null) {
				JOptionPane.showMessageDialog(null, "No house selected.\n" +
						"First create a new house");							
			} else {
				houseInf.makeActive(false);
				roomInf.makeActive(true);
			}
		}
	}

	// ACTION LISTENER FOR SUBMITTING A NEW ROOM
	private class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Room2 room = roomInf.createRoom();
				model.addRoom(room);
			} catch (RoomCreationException e1) {
				JOptionPane.showMessageDialog(null, "That did not work:\n" + e1.getMessage());			
			}
			houseInf.makeActive(true);
			roomInf.makeActive(false);			
		}
	}

	// ACTION LISTENER TO MAKE A NEW HOUSE
	private class NewHouseListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String type = JOptionPane.showInputDialog(frame, 
					"Please enter the new house type:");
			model.createHouse(type);
			frame.repaint();
		}
	}

	// ACTION LISTENER TO MAKE SAVE THE LIST OF HOUSES TO A FILE
	private class SaveHousesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			File file = null;
	        JFileChooser jfc = new JFileChooser();
	        int selection = jfc.showSaveDialog(frame);
	        if(selection == JFileChooser.APPROVE_OPTION) {
	            file = jfc.getSelectedFile();
	        }
	        if (file == null) {
	            JOptionPane.showMessageDialog(frame, "You did not select a " +
	                "file\nThe houses cannot be saved");
	        } else {
	        	model.saveHouses(file);
	        }

		}
	}

	// ACTION LISTENER TO LOAD A LIST OF HOUSES FROM A FILE
	// (AND APPEND THEM TO AN EXISTING LIST OF HOUSES)
	private class OpenHousesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			File file = null;
	        JFileChooser jfc = new JFileChooser();
	        int selection = jfc.showOpenDialog(frame);
	        if(selection == JFileChooser.APPROVE_OPTION) {
	            file = jfc.getSelectedFile();
	        }
	        if (file == null) {
	            JOptionPane.showMessageDialog(frame, "You did not select a " +
	                "file\nThe house file cannot be opened");
	        } else {
	        	model.openHouses(file);
	        }

		}
	}

}
