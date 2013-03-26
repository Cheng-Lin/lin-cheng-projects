package lab4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author khuang13
 *
 */
public class Question1 
{
	private String[][] str;
	
	/**
	 * Constructor method for the class
	 * @param str
	 */
	public Question1(String[][] str) {
		this.str = str;
	}
	
	public String linearize()
	{
		// 86% increase (6 line added)
		StringBuilder strBuilder = new StringBuilder();
		
		if (str != null) {
			for (int i = 0; i < str.length; i++) {
				if (str[i] != null) {
					for (int j = 0; j < str[i].length; j++)	{
						if (str[i][j] != null) {
							strBuilder.append(str[i][j]);
						}
					}
				}
			}
		}

		return strBuilder.toString();
	}
	
	public String[] longestIndividualArray()
	{
		//71% increase in the code (5 line added)
		int max = -1;
		int count = -1;
		
		if (str != null) {
			for (int i = 0; i < str.length; i++) {
				if (str[i] != null && str[i].length > max) {
					max = str[i].length;
					count = i;
				}
			}
		}
		
		return count == -1 ? null : str[count];
	}
	
	public String longestIndividualString()
	{
		int max = -1;
		int row = -1, column = -1;
		
		if (str != null) {
			for (int i = 0; i < str.length; i++)	{
				if (str[i] != null) {
					for (int j = 0; j < str[i].length; j++) {
						if (str[i][j] != null && str[i][j].length() > max) {
							max = str[i][j].length();
							row = i;
							column = j;
						}
					}
				}
			}
		}
		
		return max == -1 ? null: str[row][column];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Question1 ques1 = new Question1(new String[][]{{"This ", "is ", "an ", "example "},
													   {"of ", "a "},
													   {"ragged "},
													   {"array ", "of ", "strings ", "without ", "any ", "null ", "strings."}});
		System.out.println(ques1.linearize());
		System.out.println(Arrays.toString(ques1.longestIndividualArray()));
		System.out.println(ques1.longestIndividualString());
		
		String[] temp1 = {"Yet","another","example"};
		String[] temp2 = {"Unfortunately",null,"","I","omitted","the"};
		String[] temp3 = null;
		String[] temp4 = {null,"spaces","."};
		String[][] arg = {temp1,temp2,temp3,null,temp4};
		Question1 q2 = new Question1(arg);
		System.out.println(q2.linearize());
		System.out.println(Arrays.toString(q2.longestIndividualArray()));
		System.out.println(q2.longestIndividualString());
		
		String[][] input = new String[5][7];
		for(int i = 0; i < input.length; i++) {
			input[i] = null;
		}
		Question1 q3 = new Question1(input);
		System.out.println(q3.linearize());
		System.out.println(Arrays.toString(q3.longestIndividualArray()));
		System.out.println(q3.longestIndividualString());
		
        Scanner keyboard = new Scanner(System.in);
        int numRows = -1;
        do {
            System.out.println("How many rows do you want in the 2-dimensional String array?");
            if(keyboard.hasNextInt()) {
                numRows = keyboard.nextInt();
                keyboard.nextLine();
            } else {
                System.out.println("We need an int, please");
                keyboard.nextLine();
            }
        } while(numRows == -1);
        String[][] text = new String[numRows][];
        for(int i = 0; i < numRows; i++) {
            String line = null;
            StringBuilder builder = new StringBuilder();
            do {
                System.out.println("Please enter a single String to store in the array (end the string with a period to complete the row)");
                line = keyboard.nextLine();
                builder.append(line);
                builder.append((char)0); // a separator
            } while(line.indexOf('.') != line.length()-1);
            System.out.println("Array row " + i + " completed");
            text[i] = builder.toString().split(""+(char)0);
        }
        System.out.println("-----------\nThanks, your input was:");
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < text[i].length; j++) {
                System.out.print(text[i][j] + " ");
            }
            System.out.println();
        }
        Question1 q31 = new Question1(text);
		System.out.println(q31.linearize());
		System.out.println(Arrays.toString(q31.longestIndividualArray()));;
		System.out.println(q31.longestIndividualString());
	}
}
