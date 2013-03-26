package assignment05;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ke-Bang Huang
 *
 */
public class BankCustomer 
{
	private String name;
	private BankAccount account;
	
	/**
	 * Constructor method for this class that initializes all the field
	 * 
	 * @param name of the customer
	 * @param account Bank Account of the customer
	 */
	public BankCustomer(String name, BankAccount account) 
	{
		this.name = name;
		this.account = account;
	}

	/**
	 * Deposits money into the bank account.
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		account.deposit(amount);
	}

	/**
	 * Withdraws money from the bank account.
	 * @param amount the amount to withdraw
	 * @throws InsufficientFundsException if the account
	 * cannot cover the withdrawal of this amount
	 */
	public void withdraw(double amount) throws InsufficientFundsException {
		account.withdraw(amount);
	}

	/**
	 * Gets the current balance of the bank account.
	 * @return the current balance
	 */
	public double getBalance() {
		return account.getBalance();
	}

	/**
	 * Getter method for account number
	 * @return account number of this account
	 */
	public int getAccountNumber() {
		return account.getAccountNumber();
	}

	/**
	 * Transfers money from the bank account to another account
	 * @param amount the amount to transfer
	 * @param other the other account
	 * @throws InsufficientFundsException if the account
	 * cannot cover the withdrawal of this amount
	 */
	public void transfer(double amount, BankCustomer other) throws InsufficientFundsException
	{
		withdraw(amount);
		other.deposit(amount);
	}
	
	/**
	 * Main method for testing the class
	 * @param args command-line argument are not used
	 */
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		ArrayList<BankCustomer> accounts = new ArrayList<BankCustomer>();
		
		accounts.add(new BankCustomer("John Quick", new BankAccount(1930, 001)));
		accounts.add(new BankCustomer("Jack Slow", new BankAccount(4572, 002)));
		accounts.add(new BankCustomer("Mary Mary", new BankAccount(8848.0, 003)));
		accounts.add(new BankCustomer("Ben Kick", new BankAccount(9473.0, 004)));
		
		for (int i = 0; i < accounts.size(); i++)
		{
			try {
				System.out.println("Input the amount deposit to account " + accounts.get(i).name + " ");
				accounts.get(1).deposit(Double.valueOf(input.nextLine()));
			} catch(IllegalArgumentException arg) {
				System.out.println("IllegalArgumentException thrown with message " + arg);
			}
		}
		
		System.out.println("\n");
		
		for (int i = 0; i < accounts.size(); i++)
		{
			try {
				int target = i;
				do {
					target = (int)(Math.random() * 4);
				} while (target == i);
				
				int amount = (int)(Math.random() * accounts.get(i).getBalance() + accounts.get(i).getBalance() / 3);
				System.out.println("The amount intend to transfer from " + 
								   accounts.get(i).name + " to " + 
								   accounts.get(target).name + " is " + amount);
				
				accounts.get(i).transfer(amount, accounts.get(target));
				
				System.out.println("The current balance of the account " + accounts.get(i).name +
								   " after transfer is " + accounts.get(i).getBalance());
				System.out.println("The current balance of the account " + accounts.get(target).name +
						   		   " after receive is " + accounts.get(target).getBalance() + "\n");
			} catch(InsufficientFundsException arg) {
				System.out.println("IllegalArgumentException thrown with message " + arg);
				System.out.println("The current balance of the account " + accounts.get(i).name +
								   " after penalty is " + accounts.get(i).getBalance() + "\n");
			}
		}
	}
	
	/**
	 * Display the histogram for the list of the customers
	 * "There's missing data" returned when the array supplied 
	 * is null or empty, the name of the account is null, or 
	 * the account itself is null.
	 * 
	 * @param array list of the customers bank account
	 */
	public static void drawHistogram(BankCustomer[] array)
	{
		double max = 0.0;
		double subunit = 0.0;
		boolean okay = false;
		
		if (array != null && array.length > 0)
		{
			if (array[0] != null && array[0].name != null && array[0].account != null) 
			{
				max = array[0].getBalance();
				okay = true;
			}
			
			for (int i = 1; i < array.length && okay; i++)
			{
				if (array[i] != null && array[i].name != null && array[i].account != null) {
					if (max < array[i].getBalance()) {
						max = array[i].getBalance();
					}
				} else {
					okay = false;
				}
			}
		}
		
		if (okay) {
			subunit = max / 20.0;
			
			int[] temp = new int[array.length];
			int[] halfPos = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				temp[i] = (int)(array[i].getBalance() / subunit + 0.5);
				halfPos[i] = (int)(array[i].name.length() / 2);
			}
			
			for (int i = 20; i > 0; i--)
			{
				for (int j = 0; j < temp.length; j++)
				{
					for (int k = 0; k < halfPos[j]; k++) {
						System.out.print(" ");
					}
					
					if (temp[j] >= i) {
						System.out.print("X");
					} else {
						System.out.print(" ");
					}
					
					for (int k = halfPos[j] + 1; k < array[j].name.length(); k++) {
						System.out.print(" ");
					}
					
					System.out.print("  ");
				}
				System.out.println();
			}
			
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i].name + "  ");
			}
		} else {
			System.out.println("Cannot show Histogram, there is missing data");
		}
	}
}
