package assignment02;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Question1
{
     public static void main(String[] args) throws FileNotFoundException
     {
    	 // LET ECLIPSE INSERT THROWS CLAUSE
         Edible[] food= new Edible[10];
         food[0] = new Plum();
         food[1] = new Orange();
         food[2] = new Strawberry();
         food[3] = new Grape();
         food[4] = new Banana();
         food[5] = new Peach();
         food[6] = new Blackberry();
         food[7] = new Blueberry();
         PrintWriter writer = new PrintWriter("out.txt");
         for(Edible e : food) {
             if(e != null) {
                 System.out.println("Color: " + e.getColor());
                 System.out.println("Flavor: " + e.getTaste(writer));                
            }
         }
         writer.close();
     }
}
