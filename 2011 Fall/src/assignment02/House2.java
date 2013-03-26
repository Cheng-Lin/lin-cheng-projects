package assignment02;

import java.util.ArrayList;

public class House2
{
	// Either write
    private ArrayList<Room2> rooms = new ArrayList<Room2>();
    // or if Java 7 is working for you (I got mine working) you can write:
    // private ArrayList<Room2> rooms = new ArrayList<>();
   	// you can only of one of the two versions of rooms. 
   	// the only difference is the way the right-hand side is written
  
    // no explicit constructor, just use the null-argument constructor
    // that Java provides in the absence of explicit constructors
  
    /**
     * Adds a room to the rooms of the house
     * @param room new room to add
     */
    public void addRoom(Room2 room) {
        rooms.add(room);
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
        for(int i = 0; i < rooms.size(); i++) {
 //           PROVIDE THIS CODE. IF (rooms.get(i) != null &&
 //                   rooms.get(i).getAbbreviation().equals(abbr))
 //            THEN ADD 1 TO count
        	if (rooms.get(i) != null && rooms.get(i).getAbbreviation().equals(abbr)) {
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
         for(int i = 0; i < rooms.size(); i++) {
 //            PROVIDE THIS CODE: USE THE SAME TEST AS IN
 //            findNumberOfRooms TO FIND THE CORRECT ABBREVIATION.
 //            IF THERE IS A MATCH, USE System.out.println TO 
//            PRINT rooms.get(i).getDescription() + " " + listCounter
 //                  + " area is " + rooms.get(i).getArea()
 //            If YOU PRINT A LINE, INCREMENT listCounter
         	if (rooms.get(i) != null && rooms.get(i).getAbbreviation().equals(abbr)) {
        		System.out.println(rooms.get(i).getDescription() + " " + listCounter
        						   + " area is " + rooms.get(i).getArea());
        	}
         }
     }
  
 //    CREATE A METHOD TO COMPUTE THE WHOLE AREA OF THE HOUSE AND
 //    PROVIDE THE javadoc COMMENT
 	/**
 	 * Method for calculating whole area of the house
 	 */
 	public double getWholeArea()
 	{
 		double wholeArea = 0.0;
        for(int i = 0; i < rooms.size(); i++)	//replaced rooms.length with nextUnusedIndex since 
 		{											//there's still unassigned part in rooms.
 			wholeArea += rooms.get(i).getArea();
 		}
 		return wholeArea;
 	}
 	
     /**
      * Method for testing only
      */
     public void checkRooms() {
 // note that Java knows how to print ArrayLists
         System.out.println(rooms);
     }
 }
 