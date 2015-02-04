import javax.swing.JOptionPane;
import java.util.Arrays;
public class bankTeller {

	// Scrum idea:
	/* Bank Teller program ---------
	 * Pre-Planning: make a list of pins, and give a balance to them to use
	 * 1. ask the user for their pin
	 * 2. check to see if the pin exists, if it does, find the variable associated with it
	 * 3. allow them to deposit, withdraw from their account
	 * 
	 */
	
	
	public static int[] getUsersList() 
	{
		int[] user = {1234, 2019, 2100, 1900, 1111, 0000};
		return user;
	}
	
	public static double[] getBalanceList()
	{
		double[] balance = {200, 5, 100, 10000, 1241.21, 5000};
		return balance;
	}
	
	public static int getPin()
	{
		boolean invalid_format = true;
		int pin = 0;
		while(invalid_format)
		{
			String input = JOptionPane.showInputDialog("Please enter your Personal Identification Number");
			try
			{
				pin = Integer.parseInt(input);
				invalid_format = false;
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"I'm sorry, but it appears you did not enter a pin in the form of an integer.");
			}
			catch(NullPointerException e)
			{
				System.exit(0);
			}
		}
		return pin;
		
	}
	
	public static void welcome()
	{
		JOptionPane.showMessageDialog(null,"Good day! Welcome to the Bank of Middleton");
	}
	
	public static double preCheck()
	{
		boolean noPin = false;
		int i = 0;
		int[] users = getUsersList();
		int pin = getPin();
		System.out.println("pin:"+pin);
		double account_balance = 0.0;
		double[] balance = getBalanceList();
		JOptionPane.showMessageDialog(null,"Thank you for entering your pin, please hold while we check to see if your pin is correct...");
		
		
		for(i=0;i<users.length;i++)
		{
			if(users[i] == pin)
			{
				account_balance=balance[i];
			}
			else
			{
				noPin = true;
			}
		}
		if(noPin == true)
		{
			JOptionPane.showMessageDialog(null,"It apppears that you have entered a pin that does not exist in our database. Try again.");
			pin = getPin();
			preCheck();
		}
		return account_balance;
		
	}
	
	public static double withdraw(double account_balance)
	{
		
	}
	
	public static double deposit(double account_balance)
	{
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		welcome();
		preCheck();
		
	}

}
