package assignment06;

import java.util.ArrayList;

public class Driver2 {
    public static void main(String[] args) {
        ArrayList<Top> list = new ArrayList<Top>();
        
        list.add(new Top());
        list.add(new Top());
        list.add(new Middle());
        list.add(new Bottom());
        list.add(new Middle());
        list.add(new Top());
        list.add(new Middle());
        list.add(new Middle());
        list.add(new Bottom());
        
        for(Top t : list) {
            System.out.println(t.methodC());
        }
    }
}
