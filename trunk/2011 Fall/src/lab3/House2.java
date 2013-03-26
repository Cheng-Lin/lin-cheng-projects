package lab3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * Class to give simple representation of a house 
 * @author CS 140
 *
 */
public class House2 implements Comparable<House2>, Serializable  {
	private static final long serialVersionUID = -827652852505114053L;
	private ArrayList<Room2> rooms = new ArrayList<Room2>();
	private Map<RoomType, Integer> roomTypeCount = new EnumMap<RoomType, Integer>(RoomType.class);
	// if Java 7 is working you can write:
	//private ArrayList<Room2> rooms = new ArrayList<>();
	//private Map<RoomType, Integer> roomTypeCount = new EnumMap<>(RoomType.class);
	private String houseType;

	/**
	 * Constructor for House2
	 * @param description the type of the house
	 */
	public House2(String description) {
		houseType = description;
	}

	/**
	 * Adds a room to the rooms of the house
	 * @param room new room to add
	 */
	public void addRoom(Room2 room) {
		rooms.add(room);
		int numRoomsOfType = 0;
		if(roomTypeCount.containsKey(room.getType())) {
			numRoomsOfType = roomTypeCount.get(room.getType());
		}
		numRoomsOfType++;
		roomTypeCount.put(room.getType(), numRoomsOfType);
		Collections.sort(rooms);
	}

	/**
	 * Method for testing only
	 */
	public void checkRooms() {
		System.out.println(rooms);
	}

	/**
	 * Method to compare this object with another house.
	 * The order is the alphabetical order of the types
	 * of the house
	 * @param other the other house to be compared with
	 * this house for the alphabetic ordering based on 
	 * houseType
	 * @return negative if this house comes before the other,
	 * zero if they are the same type and positive if
	 * this house comes after the other house
	 */
	@Override
	public int compareTo(House2 other) {
		return houseType.compareToIgnoreCase(other.houseType);
	}

	/**
	 * Find the number of rooms of a certain type. For example
	 * findNumberOfRooms("ba") is the number of bathrooms in the
	 * house. For this you must use the equals method of String.
	 * NEVER use == to compare Strings in Java
	 * @param abbr the abbreviation of the rooms being counted
	 * @return the number of rooms in the house with this abbreviation
	 */
	public int findNumberOfRooms(String abbr) {
		int count = 0;
		for(Room2 room : rooms) {
			if (room.getAbbreviation().equals(abbr)) {
				count++;
			}
		}	
		return count;		
	}

	/**
	 * Getter method for houseType. 
	 * @return the type of house
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * Getter method for the rooms in the house
	 * @return the list of rooms in the house
	 */
	public ArrayList<Room2> getRooms() {
		return rooms;
	}

	/**
	 * Get a list of the abbreviations of the rooms 
	 * in the house in alphabetical order. If there 
	 * are multiple rooms such as three bedrooms, 
	 * they appear as 3 bed 
	 * @return an abbreviated list of the rooms in the house
	 */
	public String getSummary() {
		StringBuilder builder = new StringBuilder();
		for(RoomType type : roomTypeCount.keySet()){
			builder.append(roomTypeCount.get(type) + " " + type.getAbbreviation() + ", ");
		}
		if(builder.length() > 0) {
			builder.setLength(builder.length()-2);
		}
		return builder.toString();
	}

	/**
	 * Prints a list of the area or areas of the room or rooms in
	 * the house described of a certain type. For example, if the 
	 * abbreviation is "bed" you might get
	 *    Bedroom 1 area is 150
	 *    Bedroom 2 area is 120
	 *    Bedroom 3 area is 110
	 * @param abbr the abbreviation of the roomTypes for the area report
	 */
	public void printAreas(String abbr) {
		int listCounter = 1;
		for(Room2 room : rooms) {
			if (room.getAbbreviation().equals(abbr)) {
				System.out.println(room.getDescription() + " " 
						+ listCounter + " area is " + room.getArea());
			}
		}
	}

	/**
	 * Computes the area of the whole house by summing
	 * the individual room areas.
	 * @return area of the whole house
	 */
	public double wholeArea() {
		double returnValue = 0;
		for (Room2 room : rooms) {
			returnValue += room.getArea();
		}
		return returnValue;
	}

}
