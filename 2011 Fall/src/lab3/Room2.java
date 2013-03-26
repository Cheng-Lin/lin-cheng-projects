package lab3;

import java.io.Serializable;


/**
 * Representation of the room of a house.
 * @author CS 140
 *
 */
public class Room2 implements Comparable<Room2>, Serializable {

	private static final long serialVersionUID = 6872587885194887794L;
	private RoomType type;
	private double length;
	private double width;

	/**
	 * Constructor for a room object.
	 * @param type the RoomType of the room
	 * @param length the length of the room
	 * @param width the width of the room
	 */
	public Room2(RoomType type, double length, double width) {
		this.type = type;
		this.length = length;
		this.width = width;
	}
	
	/**
	 * Getter method for the RoomType of this room object
	 * @return the RoomtType of this object
	 */
	public RoomType getType() {
		return type;
	}
	
	/**
	 * Delegated getter method for the description of the 
	 * RoomType of this object
	 * @return the description of the RoomType of this room
	 */
	public String getDescription() {
		return type.getDescription();
	}
	
	/**
	 * Delegated getter method for the abbreviation of the 
	 * RoomType of this object
	 * @return the abbreviation of the RoomType of this room
	 */
	public String getAbbreviation() {
		return type.getAbbreviation();
	}
	
	/**
	 * Getter method for the length field
	 * @return the length of this room object
	 */
	public double getLength() {
		return length;
	}
	
	/**
	 * Getter method for the width field
	 * @return the width of this room object
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Method to compute the area of the room.
	 * @return the area of this room object
	 */
	public double getArea() {
		return width*length;
	}

	/**
	 * Method to give a String representation of this object
	 * providing the names and vales of all the instance
	 * fields.
	 * @return the class name and all the fields of this object
	 */
	@Override
	public String toString() {
		return "Room2 [type=" + type + ", length=" + length + ", width="
				+ width + "]";
	}

	/**
	 * Compare this room object with another room object.
	 * The ordering is the ordering of the RoomTypes, which
	 * is the order the enum constants are listed.
	 * For two rooms of the same type, the order puts
	 * larger rooms first.
	 * @param room the room for comparison
	 * @return the comparison value
	 */
	@Override
	public int compareTo(Room2 room) {
		int comp = type.compareTo(room.type);
		if(comp == 0) {
			if (getArea() > room.getArea()) {
				comp = -1;
			} else if (getArea() < room.getArea()) {
				comp = 1;
			} 
		}
		return comp;
	}
}
