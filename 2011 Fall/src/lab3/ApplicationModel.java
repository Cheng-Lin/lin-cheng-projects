package lab3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;


public class ApplicationModel extends Observable {
	private House2 currentHouse;
	private int indexOfCurrentHouse = 0;
	private ArrayList<House2> listOfHouses = new ArrayList<House2>();
	private HouseInformation houseInf;
	private RoomInformation roomInf;

	public ApplicationModel () {
		houseInf = new HouseInformation(this);
		roomInf = new RoomInformation();
	}

	public HouseInformation getHouseInf() {
		return houseInf;
	}

	public int getIndexOfCurrentHouse() {
		return indexOfCurrentHouse;
	}

	public RoomInformation getRoomInf() {
		return roomInf;
	}

	public void addRoom(Room2 room) {
		currentHouse.addRoom(room);

		setChanged();
		notifyObservers(currentHouse);
	}

	public House2 getCurrentHouse() {
		return currentHouse;
	}

	public ArrayList<House2> getListOfHouses() {
		return listOfHouses;
	}

	public String[] getHouseNames() {
		String[] returnValue = new String[listOfHouses.size()];
		for(int i = 0; i < listOfHouses.size(); i++) {
			returnValue[i] = "House " + (i+1) + ": " + listOfHouses.get(i).getHouseType(); 
		}
		return returnValue;
	}

	public void createHouse(String type) {
		currentHouse = new House2(type);
		listOfHouses.add(currentHouse);
		Collections.sort(listOfHouses);
		indexOfCurrentHouse = listOfHouses.indexOf(currentHouse);
		setChanged();
		notifyObservers(currentHouse);
	}

	public void setHouseIndex(int index) {
		currentHouse = listOfHouses.get(index);
		indexOfCurrentHouse = index;
		setChanged();
		notifyObservers(currentHouse);
	}

	public void saveHouses(File file) {
		try {
			ObjectOutputStream objOutput = 
					new ObjectOutputStream(new FileOutputStream(file));
			objOutput.writeObject(listOfHouses);
			objOutput.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void openHouses(File file) {
		ObjectInputStream objInput;
		try {
			objInput = new ObjectInputStream(new FileInputStream(file));
			listOfHouses.addAll((ArrayList<House2>)objInput.readObject());
			objInput.close();
			setHouseIndex(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
