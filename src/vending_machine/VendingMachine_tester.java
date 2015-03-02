package vending_machine;

public class VendingMachine_tester {
	
	public void createGUI()
	{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine tester = new VendingMachine();
		tester.getFoodsAndPrices();
		tester.addOrChangeItem(0,0,"ayy",2.00);
		
		VendingMachine emptyTester = new VendingMachine(4,6);
		emptyTester.addOrChangeItem(0, 0, "ayylmaooo", 2.49);
		emptyTester.changePrice(0,0, 500);
		emptyTester.enterMoney(50000);
		emptyTester.getMoneyEntered();
		emptyTester.chooseFood(0,0);
		emptyTester.getMoneyEntered();
	}

}
