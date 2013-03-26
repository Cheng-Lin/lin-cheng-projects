package assignment01;

public class HouseTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		House house1 = new House();
		Room room = new Room("Bedroom", "bed");
		room.setLength(12.0);
		room.setWidth(10.0);
		
		house1.addRoom(room);

		room = new Room("Kitchen", "kit");
		room.setLength(15.0);
		room.setWidth(12.0);

		house1.addRoom(room);
		
		room = new Room("Sitting Room", "sit");
		room.setLength(20.0);
		room.setWidth(15.0);

		house1.addRoom(room);
		
		room = new Room("Bedroom", "bed");
		room.setLength(11.0);
		room.setWidth(11.5);

		house1.addRoom(room);

		room = new Room("Bathroom", "ba");
		room.setLength(8.0);
		room.setWidth(10.0);

		house1.addRoom(room);
		
		room = new Room("Studio Room", "st");
		room.setLength(20.0);
		room.setWidth(20.0);
			
		house1.addRoom(room);
		
		room = new Room("Quiet Room", "qu");
		room.setLength(7.0);
		room.setWidth(7.0);
			
		house1.addRoom(room);
		
		// check that there are 5 rooms as
		// described above
		house1.checkRooms();
		
		System.out.println("Testing findNumberOfRooms");
		System.out.println("Expected 2 Bedrooms");
		System.out.println("Actual Value " + house1.findNumberOfRooms("bed"));
		System.out.println("Expected 1 Bathroom");
		System.out.println("Actual Value " + house1.findNumberOfRooms("ba"));
		System.out.println("Expected 1 Kitchen");
		System.out.println("Actual Value " + house1.findNumberOfRooms("kit"));
		System.out.println("Expected 1 Sitting Room");
		System.out.println("Actual Value " + house1.findNumberOfRooms("sit"));
		System.out.println("Expected 1 Studio Room");
		System.out.println("Actual Value " + house1.findNumberOfRooms("st"));
		System.out.println("Expected 1 Quiet Room");
		System.out.println("Actual Value " + house1.findNumberOfRooms("qu"));
		
		System.out.println("Testing printAreas");
		System.out.println("Expected Area for Bedroom 1 is 120");
		System.out.println("Expected Area for Bedroom 2 is 126.5");
		System.out.println("Actual Area is: ");
		house1.printAreas("bed");
		System.out.println("Expected Area for Bathroom is 80");
		System.out.print("Actual Area is: ");
		house1.printAreas("ba");
		System.out.println("Expected Area for Kitchen is 180");
		System.out.print("Actual Area is: ");
		house1.printAreas("kit");
		System.out.println("Expected Area for Sitting Room is 300");
		System.out.print("Actual Area is: ");
		house1.printAreas("sit");
		System.out.println("Expected Area for Studio Room is 400");
		System.out.print("Actual Area is: ");
		house1.printAreas("st");
		System.out.println("Expected Area for Quiet Room is 49");
		System.out.print("Actual Area is: ");
		house1.printAreas("qu");
		
		System.out.println("Testing getWholeArea");
		System.out.println("Expected value is 1255.5");
		System.out.println("Actual Area is " + house1.getWholeArea());
		
		LocatedHouse georgesPizza = new LocatedHouse(house1, 40.850634, -73.937275, "726 West 181st Street", "New York", "NY", "10033-4728");
		System.out.println("\nGeorge's Pizza");
		System.out.println(georgesPizza);
		
		System.out.println("Testing findNumberOfRooms");
		System.out.println("Expected 2 Bedrooms");
		System.out.println("Actual Value " + georgesPizza.findNumberOfRooms("bed"));
		System.out.println("Expected 1 Bathroom");
		System.out.println("Actual Value " + georgesPizza.findNumberOfRooms("ba"));
		System.out.println("Expected 1 Kitchen");
		System.out.println("Actual Value " + georgesPizza.findNumberOfRooms("kit"));
		System.out.println("Expected 1 Sitting Room");
		System.out.println("Actual Value " + georgesPizza.findNumberOfRooms("sit"));
		System.out.println("Expected 1 Studio Room");
		System.out.println("Actual Value " + georgesPizza.findNumberOfRooms("st"));
		System.out.println("Expected 1 Quiet Room");
		System.out.println("Actual Value " + georgesPizza.findNumberOfRooms("qu"));
		
		System.out.println("Testing printAreas");
		System.out.println("Expected Area for Bedroom 1 is 120");
		System.out.println("Expected Area for Bedroom 2 is 126.5");
		System.out.println("Actual Area is: ");
		georgesPizza.printAreas("bed");
		System.out.println("Expected Area for Bathroom is 80");
		System.out.print("Actual Area is: ");
		georgesPizza.printAreas("ba");
		System.out.println("Expected Area for Kitchen is 180");
		System.out.print("Actual Area is: ");
		georgesPizza.printAreas("kit");
		System.out.println("Expected Area for Sitting Room is 300");
		System.out.print("Actual Area is: ");
		georgesPizza.printAreas("sit");
		System.out.println("Expected Area for Studio Room is 400");
		System.out.print("Actual Area is: ");
		georgesPizza.printAreas("st");
		System.out.println("Expected Area for Quiet Room is 49");
		System.out.print("Actual Area is: ");
		georgesPizza.printAreas("qu");
		
		System.out.println("Testing getWholeArea");
		System.out.println("Expected value is 1255.5");
		System.out.print("Actual Area is " + georgesPizza.getWholeArea());
	}
}
