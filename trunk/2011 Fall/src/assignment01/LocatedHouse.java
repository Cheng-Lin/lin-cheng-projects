
package assignment01;

/**
 * Class representating the address of a house 
 * @author Ke-Bang Huang
 * 
 */
public class LocatedHouse
{
	House house;
	
	double latitude;
	double longitude;
	
	String streetAddress;
	String city;
	String state;
	String zipCode;

	/**
	 * Constructor
	 * 
	 * @param house The house
	 * @param latitude Latitude of the house
	 * @param longitude	Longitude of the house
	 * @param streetAddress Street Address of the house
	 * @param city city where the house located
	 * @param state state where the house located
	 * @param zipCode zip code of the house
	 */
	public LocatedHouse(House house, double latitude, double longitude,	
						String streetAddress, String city, String state, String zipCode)
	{
		super();
		this.house = house;
		this.latitude = latitude;
		this.longitude = longitude;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	/**
	 * Find the number of rooms of a certain type.
	 * 
	 * @param abbr the abbreviation of the rooms being counted
	 * @return the number of rooms in the house with this abbreviation
	 */
	public int findNumberOfRooms(String abbr) {
		return house.findNumberOfRooms(abbr);
	}

	/**
	 * Prints a list of the area or areas of the room or rooms in
	 * the house described of a certain type. 
	 * 
	 * @param abbr the abbreviation of the rooms for the area report
	 */
	public void printAreas(String abbr) {
		house.printAreas(abbr);
	}
	
	/**
	 * Method for calculating whole area of the house
	 */
	public double getWholeArea() {
		return house.getWholeArea();
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "LocatedHouse [house=" + house + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", streetAddress="
				+ streetAddress + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}
}
