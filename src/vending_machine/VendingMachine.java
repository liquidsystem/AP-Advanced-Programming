package vending_machine;

import java.util.Arrays;



public class VendingMachine {
	
	public int i=0;
	public int k=0;
	String[][] items;
	double[][] price;
	double moneyEntered = 0.00;
	
	VendingMachine()
	{
		items = new String[2][2];
			//Set up each column in the 0th (technically 1st in real life) row
			items[0][0] = "Cool Ranch Doritos";
			items[0][1] = "Sour Cream & Onion Lays";
			
			//Set up each column in the 1st (technically 2nd in real life) row
			items[1][0] = "Extremely Unhealthy Food";
			items[1][1] = "Totally Radical Healthy Food";
			
		//End of items
		price = new double[2][2];
			//Set up price for items in the 1st row
			price[0][0] = 2.00;
			price[0][1] = 2.00;
			
			//Set up price for items in the 2nd row
			price[1][0] = 4.00;
			price[1][1] = 4.00;
		//End of price
		moneyEntered = 0.00;
	}
	
	VendingMachine(int NUM_OF_ROWS, int NUM_OF_COLUMNS)
	{
		items = new String[NUM_OF_ROWS][NUM_OF_COLUMNS];
			//Item defining done here
		
		//End of items
		price = new double[NUM_OF_ROWS][NUM_OF_COLUMNS];
			//Pricing for each item done here
		
		//End of price
		moneyEntered = 0.00;
	}
	
	
	//Setters
	void addOrChangeItem(int row, int column, String itemName, double itemPrice)
	{
		if(items[row][column] == null)
		{
			System.out.println("This element appears to be empty... Continuing");
			items[row][column] = itemName;
			price[row][column] = itemPrice;
			System.out.println("New item added at "+row+","+column+" with the price of: $"+itemPrice);
			
		}
		else
		{
			System.out.println("Replacing " + items[row][column] + " (cost: $" + price[row][column] + ")" + " with " + itemName + " (cost: $"
					+ itemPrice + ")");
			items[row][column] = itemName;
			price[row][column] = itemPrice;
		}
		
	}
	
	void changePrice(int row, int column, double itemPrice)
	{
		if(items[row][column] != null)
		{
			System.out.println("Changing the price of " + items[row][column] + " to $" + itemPrice);
			price[row][column] = itemPrice;
		}
	}
	
	void enterMoney(double m)
	{
		moneyEntered = m;
	}
	
	void chooseFood(int row, int column)
	{
		if(moneyEntered >= price[row][column])
		{
			System.out.println("You chose " + items[row][column] + " which has a price of $" + price[row][column]);
			moneyEntered-= price[row][column];
			System.out.println("Enjoy!");
		}
		else if (moneyEntered < price[row][column])
		{
			System.out.println("You don't have enough money for this! The price of this item is " + price[row][column]
					+ " Current money in the machine: $" + moneyEntered);
		}
	}
	
	//Getters
	void getFoodsAndPrices()
	{
		for(i = 0; i < 2; i++)
		{
			for(k = 0; k < 2; k++)
			{
				System.out.println("Price of " + items[i][k] + " is: " + "$" +price[i][k]);
			}
		}
	}
	
	void getMoneyEntered()
	{
		System.out.println("There is currently $" + moneyEntered + " in this machine.");
	}
	
}
