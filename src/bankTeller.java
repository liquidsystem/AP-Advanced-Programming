import javax.swing.JOptionPane;

public class bankTeller {

	// Scrum idea:
	/* Bank Teller program ---------
	 * Pre-Planning: make a list of pins, and give a balance to them to use
	 * 1. ask the user for their pin
	 * 2. check to see if the pin exists, if it does, find the variable associated with it
	 * 3. allow them to deposit, withdraw from their account
	 * 
	 */
	
	private static double account_balance;
	private static int pin;
	
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
	
	public static void getPin()
	{
		boolean invalid_format = true;
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
		setPin(pin);
	}
	
	public static void setPin(int p)
	{
		pin = p;
	}
	
	public static void welcome()
	{
		JOptionPane.showMessageDialog(null,"Good day! Welcome to the Bank of Middleton");
	}
	
	public static void preCheck()
	{
		boolean noPin = false;
		int i = 0;
		int[] users = getUsersList();
		double account_balance = 0.0;
		double[] balance = getBalanceList();
		JOptionPane.showMessageDialog(null,"Thank you for entering your pin, please hold while we check to see if your pin is correct...");
		
		
		
		for(i=0;i<users.length;i++)
		{
			if(users[i] == pin)
			{
				account_balance=balance[i];
				noPin = false;
				break;
			}
			else
			{
				noPin = true;
			}
		}
		if(noPin == true)
		{
			JOptionPane.showMessageDialog(null,"It apppears that you have entered a pin that does not exist in our database. Try again.");
			pin = 0;
			preCheck();
		}
		
			setBalance(account_balance);
	}
	
	public static void setBalance(double a)
	{
		account_balance = a;
	}
	
	public static void createGUI()
	{
		Object[] choices = {"Deposit","Withdraw","Go Back"};
		int choice = JOptionPane.showOptionDialog(null,"Hello! What would you like to do with your account?"+"\nYour current balance is: "+account_balance,"Account",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,choices[0]);
		if(choice==0) // User has chosen deposit
		{
			deposit(account_balance);
			JOptionPane.showMessageDialog(null,"Your new balance: $"+account_balance);
		}
		else if(choice==1)
		{
			withdraw(account_balance);
			JOptionPane.showMessageDialog(null,"Your new balance is: $"+account_balance);
		}
		else if(choice==2)
		{
			account_balance = 0;
			pin = 0;
			preCheck();
		}
		
	}
	
	public static void deposit(double user_input)
	{
		double addMoney=checkNumber(user_input,"add"); 
		account_balance+=addMoney;
		createGUI();
	}
	
	public static void withdraw(double user_input)
	{
		double removeMoney=checkNumber(user_input,"remove");
		if(removeMoney > account_balance)
		{
			JOptionPane.showMessageDialog(null,"I'm sorry, but you cannot withdraw more than you have in your account");
			withdraw(account_balance);
		}
		else
		{
			account_balance-=removeMoney;
			createGUI();
		}
	}
	public static double checkNumber(double user_input,String addOrRemove)
	{
		boolean invalid = true;
		double changeMoney = 0;
		while(invalid)
		{
			String input = JOptionPane.showInputDialog("How much money would you like to "+ addOrRemove +" to your account?");
			try
			{
				changeMoney = Double.parseDouble(input);
				invalid = false;
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Sorry, you did not enter a proper number.");
			}	
		}
		
		changeMoney = Math.abs(changeMoney);
		return changeMoney;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		welcome();
		preCheck();
		createGUI();
	}

}
