package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Ke-Bang Huang
 *
 */
public class Question2 
{
	private String[][] text;
	
	/**
	 * Convert a 2d array of string into one. During appending,
	 * skip string that's null, add a space after each word, add
	 * two spaces after each '.', '!', or '?', and go to next line
	 * after each row of array.
	 * @return a single string converted from 2d array or 
	 * 		   null if whole array is null
	 */
	public String showText()
	{
		StringBuilder strBuilder = new StringBuilder();
		String returnStr = null;
		
		if (text != null) {
			for (int i = 0; i < text.length; i++) {
				if (text[i] != null) {
					for (int j = 0; j < text[i].length; j++) {
						if (text[i][j] != null && text[i][j].length() > 0) {
							if (text[i][j].charAt(text[i][j].length() - 1) == '.' || 
								text[i][j].charAt(text[i][j].length() - 1) == '!' ||
								text[i][j].charAt(text[i][j].length() - 1) == '?')
							{
								strBuilder.append(text[i][j] + "  ");
							} else {
								strBuilder.append(text[i][j] + " ");
							}
						}
					}
					strBuilder.append("\n");
				}
			}
			returnStr = strBuilder.toString();
		}

		return returnStr;
	}
	
	/**
	 * Find the line of the text with most of words in it
	 * Null is returned if the array is null or all the lines
	 * are null or empty
	 * @return single String of the longest line of the text
	 * 		   or null if whole array is null
	 */
	public String lineWithMostWords()
	{
		StringBuilder strBuilder = new StringBuilder();
		int max = -1;
		int count = 0;
		int loc = -1;
		
		if (text != null) {
			for (int i = 0; i < text.length; i++) {
				if (text[i] != null) {
					for (int j = 0; j < text[i].length; j++) {
						if (text[i][j] != null && text[i][j].length() > 0) {
							count++;
						}
					}
					
					if (max < count) {
						max = count;
						loc = i;
					}
					
					count = 0;
				}
			}
			
			for (int j = 0; j < text[loc].length; j++) {
				if (text[loc][j] != null && text[loc][j].length() > 0) {
					if (text[loc][j].charAt(text[loc][j].length() - 1) == '.' || 
						text[loc][j].charAt(text[loc][j].length() - 1) == '!' ||
						text[loc][j].charAt(text[loc][j].length() - 1) == '?')
					{
						strBuilder.append(text[loc][j] + "  ");
					} else {
						strBuilder.append(text[loc][j] + " ");
					}
				}
			}
		}
		
		return loc == -1 ? null : strBuilder.toString();
	}
	
	/**
	 * Find the longest word in the in a list of words
	 * null is returned if the array is null or all the string
	 * are null
	 * @return longest word in the list	or null if whole array is null
	 */
	public String firstLongestWord()
	{
		int max = -1;
		int row = -1, column = -1;
		
		if (text != null) {
			for (int i = 0; i < text.length; i++)	{
				if (text[i] != null) {
					for (int j = 0; j < text[i].length; j++) {
						if (text[i][j] != null && text[i][j].length() > max) {
							max = text[i][j].length();
							row = i;
							column = j;
						}
					}
				}
			}
		}
		
		return max == -1 ? null: text[row][column];
	}
	
	/**
	 * Reads a text file and places the words (with the punctuation) in 
	 * a 2-dimensional array of String. Each row of the array
	 * corresponds to a line of text.
	 * NOTE that null lines and null Strings are
	 * randomly inserted into the array.
	 * @param file the input file to be read
	 * @throws FileNotFoundException if the input file is not found
	 */
	public void readInput(File file) throws FileNotFoundException
	{
		Random rand = new Random();
		Scanner input = new Scanner(file);
		ArrayList<String> temp = new ArrayList<String>();
		while(input.hasNextLine()) {
			temp.add(input.nextLine());
			// deliberately add random null lines
			if (Math.random() < 0.05) {
				temp.add(null);
			}
		}
		input.close();
		String[][] retVal = new String[temp.size()][];
		for(int i = 0; i < temp.size(); i++) {
			if (temp.get(i) == null) {
				retVal[i] = null;
			} else {
				retVal[i] = temp.get(i).split("\\s+");
				// deliberately add a null String to the array randomly
				if (retVal[i].length > 1) {					
					int index = rand.nextInt(retVal[i].length);
					String[] newVal = new String[1+retVal[i].length];
					System.arraycopy(retVal[i], 0, newVal, 0, index);
					System.arraycopy(retVal[i], index, newVal, index+1, retVal[i].length - index);
					newVal[index] = null;
					retVal[i] = newVal;
				}
			}			
		}
		text = retVal;
	}

	/**
	 * Main method for testing the class
	 * @param args command line arguments are not used
	 * @throws FileNotFoundException if a file is not found 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Question2 test = new Question2();
		test.readInput(new File("javadocaboutfocus.txt"));
		System.out.println(test.showText());
		
		System.out.println("");
		System.out.println(test.lineWithMostWords());
		
		System.out.println("\n");
		System.out.println(test.firstLongestWord());		
	}
}
