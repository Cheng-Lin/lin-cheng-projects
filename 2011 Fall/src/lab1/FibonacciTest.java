package lab1;

import java.util.Scanner;

public class FibonacciTest {

	/**
	 * Main method with tests of the value of Fibonacci
	 * that can be represented using a int and long.
	 * 
	 * @param args command line parameters are not used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("First value where the value of Fibonacci(i) is incorrectly computed using int is 47");
		System.out.println("Expected value = " + Fibonacci.fibonacciBIre(47));
		System.out.println("Actual value = " + Fibonacci.fibonacciIre(47));
		System.out.println("First value where the value of Factorial(i) is incorrectly computed using long is 93");
		System.out.println("Expected value = " + Fibonacci.fibonacciBIre(93));
		System.out.println("Actual value = " + Fibonacci.fibonacciLre(93));
		
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
                    System.out.println("\t" + Fibonacci.fibonacciIre(input));
                    System.out.println("\t" + Fibonacci.fibonacciLre(input));
                    System.out.println("\t" + Fibonacci.fibonacciBIre(input));
                    System.out.println("\t" + Fibonacci.fibonacciIim(input));
                    System.out.println("\t" + Fibonacci.fibonacciLim(input));
                    System.out.println("\t" + Fibonacci.fibonacciBIim(input));
                }
            } else {
                System.out.println("Please try harder to enter an int");
            }
            // VERY, VERY IMPORTANT LINE:
            keyboard.nextLine(); // soak up and clear what was typed in
        }
	}

}
