package assignment02;

public class Room2 
{
    private RoomType type;
    private double length;
    private double width;
 
    public Room2(RoomType type, double length, double width)
    {
         this.type = type;
         this.length = length;
         this.width = width;
    }
  
    public RoomType getType() {
        return type;
    }
  
    public String getDescription() {
    	return type.getDescription();
    }
  
    public String getAbbreviation() {
        return type.getAbbreviation();
    }
  
    public double getLength() {
        return length;
    }
  
    public double getWidth() {
        return width;
    }

    public double getArea() {
        return width*length;
    }
 
    @Override
    public String toString() {
        return "Room2 [type=" + type + ", length=" + length + ", width="
                + width + "]";
    }
}
 