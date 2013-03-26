package lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 * Class providing a GUI to collect information
 * about the rooms in a House
 * @author CS 140
 */
public class HouseInformation implements Observer {
	private JList<String> jListOfHouses = new JList<String>(new String[]{"No houses stored"});
	private JTextArea listOfRooms = new JTextArea();	
	private JTextField summary = new JTextField();
	private JButton openHouseFile = new JButton("Open House File");
	private JButton newHouse = new JButton("New House");
	private JButton newRoom = new JButton("New Room");
	private JButton saveHouse = new JButton("Save Houses");
	private JScrollPane houseScroller;
	private ApplicationModel model;
	private ListSelectionListener listListener = new ListListener();

	public HouseInformation(ApplicationModel model) {
		this.model = model;
		model.addObserver(this);
	}

	public JPanel createHousePanel() {
		JPanel panel = new JPanel();
		// GIVE THIS PANEL A BorderLayout WITH A HORIZONTAL
		// SEPARATION OF 3 PIXELS AND A VERTIAL SEPARATION
		// OF 2 PIXELS
		panel.setLayout(new BorderLayout(3, 2));

		// ADD THE JTextField summary TO THE PAGE_START (the top)
		// OF THIS LAYOUT
		panel.add(summary, BorderLayout.PAGE_START);
		
		// ADD THE JList listOfRooms TO THE CENTER OF THIS
		// LAYOUT
		panel.add(listOfRooms, BorderLayout.CENTER);

		houseScroller = new JScrollPane(jListOfHouses);
		
		// ADD THE JScrollPane houseScroller TO THE LINE_END
		// (the right-hand side in left-to-right countries)
		// OF THIS LAYOUT
		panel.add(houseScroller, BorderLayout.LINE_END);

		// Here is a simple example of using a border. Note that
		// we obtain borders using the "factory method" such as
		// createLineBorder instead of calling a constructor.
		listOfRooms.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jListOfHouses.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jListOfHouses.setPreferredSize(new Dimension(150,200));
		jListOfHouses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// MAKE ANOTHER PANEL CALLED buttonPanel
		// GIVE buttonPanel A GridLayout WITH 1 ROW
		// ADD THE FOLLOWING BUTTONS TO buttonPanel:
		// openHouseFile
		// newHouse
		// newRoom
		// saveHouse
		// ADD buttonPanel to panel AT THE PAGE_END POSITION
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 0));
		buttonPanel.add(openHouseFile);
		buttonPanel.add(newHouse);
		buttonPanel.add(newRoom);
		buttonPanel.add(saveHouse);
		
		panel.add(buttonPanel, BorderLayout.PAGE_END);
		return panel;
	}

	public void setNewRoomListener(ActionListener listener) {
		newRoom.addActionListener(listener);		
	}

	public void setNewHouseListener(ActionListener listener) {
		newHouse.addActionListener(listener);
	}

	public void setSaveHousesListener(ActionListener listener) {
		saveHouse.addActionListener(listener);
	}

	public void setOpenHousesListener(ActionListener listener) {
		openHouseFile.addActionListener(listener);
	}

	public void updateRoomList(House2 house) {
		listOfRooms.setText("");
		for(Room2 room : house.getRooms()){
			listOfRooms.append(room.getDescription() + "(" 
					+ room.getLength() + "x" + room.getWidth() + ")\n");
		}
	}

	public void updateSummary(House2 house) {
		summary.setText(house.getSummary());
	}

	public void updateListOfHouses(String[] names) {
		jListOfHouses = new JList<String>(names);
		jListOfHouses.addListSelectionListener(listListener);
		houseScroller.setViewportView(jListOfHouses);
		jListOfHouses.setSelectedIndex(model.getIndexOfCurrentHouse());
	}

	public void makeActive(boolean b) {
		jListOfHouses.setEnabled(b);
		listOfRooms.setEnabled(b);
		summary.setEnabled(b);
		openHouseFile.setEnabled(b);
		newHouse.setEnabled(b);
		newRoom.setEnabled(b);
		saveHouse.setEnabled(b);		
	}

	@Override
	public void update(Observable o, Object arg) {
		House2 currentHouse = (House2)arg;
		String[] houses = model.getHouseNames();
		updateListOfHouses(houses);
		updateRoomList(currentHouse);
		updateSummary(currentHouse);		
	}

	private class ListListener implements ListSelectionListener {
		private int selectedIndex = 0;
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting()) return;
			if(selectedIndex != jListOfHouses.getSelectedIndex()) {
				selectedIndex = jListOfHouses.getSelectedIndex();
				model.setHouseIndex(jListOfHouses.getSelectedIndex());
			}
		}
	}

}
