package lab1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Simple program to check you are using at least Java 1.6
 * or later
 * @author Ke-Bang Huang
 */
public class VersionTester {
    public String doDateComputation () {
        Calendar day = new GregorianCalendar();
        day.roll(Calendar.DAY_OF_YEAR, -1);
        return
        day.get(Calendar.DAY_OF_MONTH) +
        ", " + day.getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.US) +
        ", " + day.get(Calendar.YEAR);
    }
    /**
     * Special toString to use some features introduced
     * in Java 1.6
     */
    @Override
    public String toString() {
        return "This is NOT a typical toString response\n"+
        "Yesterday was " + doDateComputation();
    }

    /**
     * Uses the println method to call the toString
     * method of a VersionTester object
     * @param args command line parameters not used
     */
    public static void main(String[] args) {
        System.out.println(new VersionTester());
    }
} 