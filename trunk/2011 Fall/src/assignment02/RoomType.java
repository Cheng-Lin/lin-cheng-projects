package assignment02;

public enum RoomType 
{
    BEDROOM("Bedroom", "bed"),
    KITCHEN("Kitchen", "kit"),
    BATHROOM("Bathroom", "ba"),
    SITTING_ROOM("Sitting Room", "sit"),
    DEN("Den", "den"), 
    DINING_ROOM("Dining Room", "di"),
    ENTRANCE_HALL("Entrance Hall", "en");
 
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
