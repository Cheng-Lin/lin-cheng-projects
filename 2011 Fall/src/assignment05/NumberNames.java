package assignment05;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NumberNames {
	private static Map<Integer, String> nameList = new TreeMap<Integer, String>();

	/**
	 * Convert user number input i to its correspond text.
	 * "No names available for numbers other than 1 through 999"
	 * is returned when the input is not a number or not in range of 1-999
	 * 
	 * @param i the input number that user want to get text form from
	 * @return text form of the number or "No names available for numbers other than 1 through 999"
	 * 		   if it's not a number or not in range of 1-999.
	 */
	public static String lookup(int i) {
		String retVal = "No names available for numbers other than 1 through 999";
		if(nameList.containsKey(i)) {
			retVal = nameList.get(i);
		} else {
			if (i == 1) {
				retVal = "one";
			} else if (i == 2) {
				retVal = "two";
			} else if (i == 3) {
				retVal = "three";
			} else if (i == 4) {
				retVal = "four";
			} else if (i == 5) {
				retVal = "five";
			} else if (i == 6) {
				retVal = "six";
			} else if (i == 7) {
				retVal = "seven";
			} else if (i == 8) {
				retVal = "eight";
			} else if (i == 9) {
				retVal = "nine";
			} else if (i == 10) {
				retVal = "ten";
			} else if (i == 11) {
				retVal = "eleven";
			} else if (i == 12) {
				retVal = "twelve";
			} else if (i == 13) {
				retVal = "thirteen";
			} else if (i == 14) {
				retVal = "fourteen";
			} else if (i == 15) {
				retVal = "fifteen";	
			} else if (i == 16) {
				retVal = "sixteen";
			} else if (i == 17) {
				retVal = "seventeen";
			} else if (i == 18) {
				retVal = "eighteen";
			} else if (i == 19) {
				retVal = "nineteen";
			} else if (i == 20) {
				retVal = "twenty";
			} else if (i == 30) {
				retVal = "thirty";
			} else if (i == 40) {
				retVal = "forty";
			} else if (i == 50) {
				retVal = "fifty";
			} else if (i == 60) {
				retVal = "sixty";
			} else if (i == 70) {
				retVal = "seventy";
			} else if (i == 80) {
				retVal = "eighty";
			} else if (i == 90) {
				retVal = "ninety";
			} else if (20 < i && i <= 99) {
				retVal = lookup(i/10*10)+"-"+lookup(i%10);
			} else if (i%100 == 0 && i < 1000){
				retVal = lookup(i/100) + " hundred";
			} else if (i < 1000) {
				retVal = lookup(i/100) + " hundred and " + lookup(i%100);
			}
			nameList.put(i, retVal);
		}
		return Character.toUpperCase(retVal.charAt(0)) + 
				retVal.toLowerCase().substring(1);
	}
	/**
	 * Main method for testing the class
	 * @param args command line argument are not used
	 */
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		while(kbd.hasNextInt()) {
			int i = kbd.nextInt();
			System.out.println(NumberNames.lookup(i));
		}
		System.out.println(nameList);
	}

}
