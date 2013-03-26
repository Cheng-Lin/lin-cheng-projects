package lab1;

import java.util.Scanner;


public class FactorialTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter an int input value (-7 will exit)");
            if(keyboard.hasNextInt()) {
                int input = keyboard.nextInt();           
                if (input == -7) {
                    exit = true;
                } else {
                    System.out.println("values for " + input + "!");
                    System.out.println("\t" + RecursiveFactorials.factorialIre(input));
                    System.out.println("\t" + RecursiveFactorials.factorialIrm(input));
                    System.out.println("\t" + RecursiveFactorials.factorialLre(input));
                    System.out.println("\t" + RecursiveFactorials.factorialLrm(input));
                    System.out.println("\t" + RecursiveFactorials.factorialBIre(input));
                    System.out.println("\t" + RecursiveFactorials.factorialBIrm(input));
                    System.out.println("\t" + IterativeFactorials.factorialIie(input));
                    System.out.println("\t" + IterativeFactorials.factorialIim(input));
                    System.out.println("\t" + IterativeFactorials.factorialLie(input));
                    System.out.println("\t" + IterativeFactorials.factorialLim(input));
                    System.out.println("\t" + IterativeFactorials.factorialBIie(input));
                    System.out.println("\t" + IterativeFactorials.factorialBIim(input));
                }
            } else {
                System.out.println("Please try harder to enter an int");
            }
            // VERY, VERY IMPORTANT LINE:
            keyboard.nextLine(); // soak up and clear what was typed in
        }
	}

}
