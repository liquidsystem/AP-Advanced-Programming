import java.util.HashMap;
import javax.swing.JOptionPane;


public class bankTellerWithLists {

	private static double account_balance;
	private static int pin;
	
	public static HashMap<Integer, Double> getUserList() {
		HashMap<Integer, Double> users = new HashMap<Integer, Double>();
		users.put(1515, 20.15);
		users.put(6514, 12321.00);
		users.put(6969, 12000000000.00);
		users.put(1000, 121212.00);
		return users;
	}
	
	public static void getPin()
	{
		boolean invalid_format = true;
		while(invalid_format)
		{
			String input = JOptionPane.showInputDialog("Please enter your Personal Identification Number","Enter your PIN");
			if(input==null)
			{
				System.exit(0);
			}
			try
			{
				pin = Integer.parseInt(input);
				invalid_format = false;
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"I'm sorry, but it appears you did not enter a pin in the form of an integer.","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		setPin(pin);
	}
	
	public static void preCheck()
	{
		getPin();
		boolean noPin = false;
		HashMap<Integer, Double> users = getUserList();
		double account_balance = 0.0;
		JOptionPane.showMessageDialog(null,"Thank you for entering your pin, please hold while we check to see if your pin is correct...","Please Wait...",JOptionPane.PLAIN_MESSAGE);
		
		
	
		if(users.containsKey(pin))
		{
			account_balance=users.get(pin);
			noPin = false;
		}
		else
		{
			noPin = true;
		}
		if(noPin == true)
		{
			JOptionPane.showMessageDialog(null,"It apppears that you have entered a pin that does not exist in our database. Try again.","Error",JOptionPane.ERROR_MESSAGE);
			preCheck();
		}
		
			setBalance(account_balance);
			createGUI();
	}
	
	public static void setBalance(double a)
	{
		account_balance = a;
	}
	
	public static void createGUI()
	{
		Object[] choices = {"Deposit","Withdraw","Go Back"};
		int choice = JOptionPane.showOptionDialog(null,"Hello! What would you like to do with your account?"+"\nYour current balance is: $"+account_balance,"Account",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,choices[0]);
		if(choice==0) // User has chosen deposit
		{
			deposit(account_balance);
			JOptionPane.showMessageDialog(null,"Your new balance: $"+account_balance,"Balance",JOptionPane.PLAIN_MESSAGE);
		}
		else if(choice==1)
		{
			withdraw(account_balance);
			JOptionPane.showMessageDialog(null,"Your new balance is: $"+account_balance,"Balance",JOptionPane.PLAIN_MESSAGE);
		}
		else if(choice==2)
		{
			account_balance = 0;
			pin = 0;
			preCheck();
		}
		else
		{
			System.exit(0);
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
			JOptionPane.showMessageDialog(null,"I'm sorry, but you cannot withdraw more than you have in your account","Error",JOptionPane.ERROR_MESSAGE);
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
			String input = JOptionPane.showInputDialog(null, "How much money would you like to "+ addOrRemove +" to your account?",addOrRemove+" Money",JOptionPane.PLAIN_MESSAGE);
			try
			{
				changeMoney = Double.parseDouble(input);
				invalid = false;
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null,"Sorry, you did not enter a proper number.","Error",JOptionPane.ERROR_MESSAGE);
			}	
		}
		
		changeMoney = Math.abs(changeMoney);
		return changeMoney;
		
	}
	
	public static void setPin(int p)
	{
		pin = p;
	}
	
	public static void welcome()
	{
		JOptionPane.showMessageDialog(null,"Good day! Welcome to the Bank of Middleton","Welcome!",JOptionPane.PLAIN_MESSAGE);
		preCheck();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		welcome();
		
	}

}
