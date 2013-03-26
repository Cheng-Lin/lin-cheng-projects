package assignment01;

import java.util.Arrays;

/**
 * Class to give simple representation of a house 
 * @author CS 140
 *
 */
public class House {
	@Override
	public String toString() {
		return "House [rooms=" + Arrays.toString(rooms) + ", nextUnusedIndex="
				+ nextUnusedIndex + "]";
	}

	private Room[] rooms = new Room[30];
	// 30 is an arbitrary limit and we will demonstrate how to 
	// make this more flexible soon. A house DOES NOT need to 
	// 30 rooms. It only has the number you put in
	private int nextUnusedIndex = 0;
	
	// no explicit constructor, just use the null-argument constructor
	// that Java provides in the absence of explicit constructors
	
	/**
	 * Adds a room to the rooms of the house
	 * @param room new room to add
	 */
	public void addRoom(Room room) {
//		PROVIDE THIS CODE:
//		YOU DO THE ASSIGNMENT rooms[nextUnusedIndex] = room
//		THEN INCREMENT nextUnusedIndex BY 1,
//		THAT MEANS YOU ADD 1 TO nextUnusedIndex (USE THE ++ OPERATOR)
		rooms[nextUnusedIndex] = room;
		nextUnusedIndex++;
	}
	
	/**
	 * Find the number of rooms of a certain type. For example
	 * findNumberOfRooms("ba") is the number of bathrooms in the
	 * house. For this you must use the equals method of String.
	 * NEVER usr == to compare Strings in Java
	 * @param abbr the abbreviation of the rooms being counted
	 * @return the number of rooms in the house with this abbreviation
	 */
	public int findNumberOfRooms(String abbr) {
		int count = 0;
		for(int i = 0; i < nextUnusedIndex; i++)	//replaced rooms.length with nextUnusedIndex since 
		{											//there's still unassigned part in rooms.
//		    PROVIDE THIS CODE. IF rooms[i].getAbbr().equals(abbr)
//		    THEN ADD 1 TO count
			if (rooms[i].getAbbr().equals(abbr)) {
				count++;
			}
		}	
		return count;		
	}
	
	/**
	 * Prints a list of the area or areas of the room or rooms in
	 * the house described of a certain type. For example, if the 
	 * abbreviation is "bed" you might get
	 *    Bedroom 1 area is 150
	 *    Bedroom 2 area is 120
	 *    Bedroom 3 area is 110
	 * @param abbr the abbreviation of the rooms for the area report
	 */
	public void printAreas(String abbr) {
		int listCounter = 1;
		for(int i = 0; i < nextUnusedIndex; i++)	//replaced rooms.length with nextUnusedIndex since 
		{											//there's still unassigned part in rooms.
//			PROVIDE THIS CODE: USE THE SAME TEST AS IN
//			findNumberOfRooms TO FIND THE CORRECT ABBREVIATION.
//			IF THERE IS A MATCH, USE System.out.println TO 
//			PRINT rooms[i].getDescription() + listCounter + rooms[i].getArea()
//			If YOU PRINT A LINE, INCREMENT listCounter
			if (rooms[i].getAbbr().equals(abbr)) {
				System.out.println(rooms[i].getDescription() + " " + listCounter + " " + rooms[i].getArea());
				listCounter++;
			}
		}
	}
	 
//	CREATE A METHOD TO COMPUTE THE WHOLE AREA OF THE HOUSE AND
//	PROVIDE THE javadoc COMMENT
	/**
	 * Method for calculating whole area of the house
	 */
	public double getWholeArea()
	{
		double wholeArea = 0.0;
		for(int i = 0; i < nextUnusedIndex; i++)	//replaced rooms.length with nextUnusedIndex since 
		{											//there's still unassigned part in rooms.
			wholeArea += rooms[i].getArea();
		}
		return wholeArea;
	}
	
	/**
	 * Method for testing only
	 */
	public void checkRooms() {
		System.out.println(Arrays.toString(rooms));
	}
}
