package lab06.part1;
/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
 */
public class BankAccount {  
	private double balance; 
	private int accountNumber;
	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount(int accountNumber) {  
		//balance = 0;
		//this.accountNumber = accountNumber;
		this(0.0, accountNumber);
	}

	/**
	 * Constructs a bank account with a given balance.
	 * @param initialBalance the initial balance
	 */
	public BankAccount(double initialBalance, int accountNumber) {  
		balance = initialBalance;
		this.accountNumber = accountNumber; 
	}

	/**
	 * Deposits money into the bank account.
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount)	{  
		if (amount < 0) throw new IllegalArgumentException("Negative argument");
		balance += amount;
	}

	/**
	 * Withdraws money from the bank account.
	 * @param amount the amount to withdraw
	 * @throws InsufficientFundsException if the account
	 * cannot cover the withdrawal of this amount
	 */
	public void withdraw(double amount) 
	throws InsufficientFundsException {  
		if (amount < 0) throw new IllegalArgumentException("Negative argument");
		if (amount > balance) {
			balance -= 15;
			throw new InsufficientFundsException("Amount = " + 
					amount + " is too large, penalty = $15");
		}
		balance -= amount;
	}

	/**
	 * Gets the current balance of the bank account.
	 * @return the current balance
	 */
	public double getBalance()
	{  
		return balance; 
	}

	/**
	 * Transfers money from the bank account to another account
	 * @param amount the amount to transfer
	 * @param other the other account
	 * @throws InsufficientFundsException if the account
	 * cannot cover the withdrawal of this amount
	 */
	public void transfer(double amount, BankAccount other) 
	throws InsufficientFundsException {  
		withdraw(amount);
		other.deposit(amount);
	}

	/**
	 * Getter method for account number
	 * @return account number of this account
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" 
			+ accountNumber + ", balance="
			+ balance + "]";
	}
}
