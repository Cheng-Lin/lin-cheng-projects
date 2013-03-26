package assignment03;
/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
	double change = 0.0;
	
   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchase = purchase + amount;
   }
   
   /**
      Enters the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void enterPayment(int dollars, int quarters, 
         int dimes, int nickels, int pennies)
   {
      payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE
            + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
   }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }
   
   /**
    * calculate dollars in change
    * @return number of dollars in the change
    */
   public int giveDollars()
   {
	   change = payment - purchase;
	   purchase = 0;
	   payment = 0;
	   
	   int dollars = (int)change;
	   change -= dollars;
	   return dollars;
   }
   
   /**
    * calculate quarters in change
    * @return number of quarters in the change
    */ 
   public int giveQuarters()
   {
	   int quaters = (int)(change / QUARTER_VALUE);
	   change -= quaters * QUARTER_VALUE;
	   return quaters;
   }
   
   /**
    * calculate dimes in change
    * @return number of dimes in the change
    */
   public int giveDimes()
   {
	   int dimes = (int)(change / DIME_VALUE);
	   change -= dimes * DIME_VALUE;
	   return dimes;
   }
   
   /**
    * calculate nickels in change
    * @return number of nickels in the change
    */
   public int giveNickels()
   {
	   int nickels = (int)(change / NICKEL_VALUE);
	   change -= nickels * NICKEL_VALUE;
	   return nickels;	   
   }
   
   /**
    * calculate pennies in change
    * @return number of pennies in the change
    */
   public int givePennies()
   {
	   int pennies = (int)(change / PENNY_VALUE);
	   change -= pennies * PENNY_VALUE;
	   return pennies;
   }
   
   public static final double QUARTER_VALUE = 0.25;
   public static final double DIME_VALUE = 0.1;
   public static final double NICKEL_VALUE = 0.05;
   public static final double PENNY_VALUE = 0.01;

   private double purchase;
   private double payment;
}
