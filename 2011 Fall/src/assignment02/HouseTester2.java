package assignment02;

import static assignment02.RoomType.*;
import assignment01.LocatedHouse;

public class HouseTester2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        House2 house2 = new House2();
        Room2 room = new Room2(BEDROOM, 12.0, 10.0);        
        house2.addRoom(room);
 
        room = new Room2(KITCHEN, 15.0, 12.0);
        house2.addRoom(room);
 
        room = new Room2(BEDROOM, 11.0, 11.5);        
        house2.addRoom(room);
 
        room = new Room2(BATHROOM, 8.0, 10.0);        
        house2.addRoom(room);
        
        room = new Room2(SITTING_ROOM, 20.0, 20.0);
        house2.addRoom(room);
        
        room = new Room2(DEN, 5.0, 5.0);
        house2.addRoom(room);
        
        room = new Room2(DINING_ROOM, 10.0, 10.0);
        house2.addRoom(room);
        
        room = new Room2(ENTRANCE_HALL, 10.0, 5.0);
        house2.addRoom(room);
 
        // check that there are 5 rooms as
        // described above
        house2.checkRooms();
  
        System.out.println("Testing findNumberOfRooms");
		System.out.println("Expected 2 Bedrooms");
		System.out.println("Actual Value " + house2.findNumberOfRooms("bed"));
		System.out.println("Expected 1 Bathroom");
		System.out.println("Actual Value " + house2.findNumberOfRooms("ba"));
		System.out.println("Expected 1 Kitchen");
		System.out.println("Actual Value " + house2.findNumberOfRooms("kit"));
		System.out.println("Expected 1 Sitting Room");
		System.out.println("Actual Value " + house2.findNumberOfRooms("sit"));
		System.out.println("Expected 1 Den");
		System.out.println("Actual Value " + house2.findNumberOfRooms("den"));
		System.out.println("Expected 1 Dining Room");
		System.out.println("Actual Value " + house2.findNumberOfRooms("di"));
		System.out.println("Expected 1 Entrance Hall");
		System.out.println("Actual Value " + house2.findNumberOfRooms("en"));
		
		System.out.println("Testing printAreas");
		System.out.println("Expected Area for Bedroom 1 is 120");
		System.out.println("Expected Area for Bedroom 2 is 126.5");
		System.out.println("Actual Area is: ");
		house2.printAreas("bed");
		System.out.println("Expected Area for Bathroom is 80");
		System.out.print("Actual Area is: ");
		house2.printAreas("ba");
		System.out.println("Expected Area for Kitchen is 180");
		System.out.print("Actual Area is: ");
		house2.printAreas("kit");
		System.out.println("Expected Area for Sitting Room is 400");
		System.out.print("Actual Area is: ");
		house2.printAreas("sit");
		System.out.println("Expected Area for Den is 25");
		System.out.print("Actual Area is: ");
		house2.printAreas("den");
		System.out.println("Expected Area for Dining Room is 100");
		System.out.print("Actual Area is: ");
		house2.printAreas("di");
		System.out.println("Expected Area for Entrance Hall is 50");
		System.out.print("Actual Area is: ");
		house2.printAreas("en");
		
		System.out.println("Testing getWholeArea");
		System.out.println("Expected value is 1081.5");
		System.out.println("Actual Area is " + house2.getWholeArea());
	}
}
 