package assignment05;

import java.util.ArrayList;

/**
 * @author Ke-Bang Huang
 *
 */
public class Question4a 
{
	/**
	 * Main method for testing purpose
	 * @param args command-line argument not used
	 */
	public static void main(String[] args)
	{
		ArrayList<BankCustomer> accounts = new ArrayList<BankCustomer>();
		
		accounts.add(new BankCustomer("John Future", new BankAccount(1930, 001)));
		accounts.add(new BankCustomer("James Now", new BankAccount(4572, 002)));
		accounts.add(new BankCustomer("Mary Quickson", new BankAccount(8848.0, 003)));
		accounts.add(new BankCustomer("Ben Kids", new BankAccount(9473.0, 004)));
		
		BankCustomer.drawHistogram(accounts.toArray(new BankCustomer[accounts.size()]));
	}
}
