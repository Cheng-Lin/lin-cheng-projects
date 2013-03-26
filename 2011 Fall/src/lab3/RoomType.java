package lab3;

public enum RoomType {
	BATHROOM("Bathroom", "ba"),
	BEDROOM("Bedroom", "bed"),
	DEN("Den","den"),
	ENTRANCE_HALL("Entrance Hall","hall"),
	FORMAL_DINING_ROOM("Formal Dining Room", "fdr"),
	KITCHEN("Kitchen", "kit"),
	LIVING_ROOM("Living Room", "liv");
	
	String description;
	String abbreviation;
	
	private RoomType(String description, String abbreviation) {
		this.description = description;
		this.abbreviation = abbreviation;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
}
