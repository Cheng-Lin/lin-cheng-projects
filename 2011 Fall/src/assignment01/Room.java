package assignment01;
/**
 * Class representing a room in a house
 * @author CS 140
 *
 */
public class Room {
	// no requirement to provide javadoc comments for anything
	// that is private
	private double length;
	private double width;
	private String description;
	private String abbr;
	
	/**
	 * Constructor for a room
	 * @param description name of the type of the room
	 * @param abbr abbreviation for that name
	 */
	public Room(String description, String abbr) {
		this.description = description;
		this.abbr = abbr;
	}

	/**
	 * Getter method of length
	 * @return the length of the room
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Setter method for length
	 * @param length the length of the room
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * Getter method of width
	 * @return the width of the room
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Setter method for width
	 * @param width the width of the room
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * Getter method for computed area.
	 * @return the area of the room
	 */
	public double getArea() {
		return length*width;
	}

	/**
	 * Getter method for description.
	 * @return the description of the room
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Getter method for abbr.
	 * @return the abbreviated name of the room
	 */	
	public String getAbbr() {
		return abbr;
	}

	@Override
	public String toString() {
		return "Room [length=" + length + ", width=" + width + ", description="
				+ description + ", abbr=" + abbr + "]";
	}

}
