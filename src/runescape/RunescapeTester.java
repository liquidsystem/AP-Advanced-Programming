package runescape;

import java.util.ArrayList;
import java.util.Arrays;

public class RunescapeTester {
	
	/* Information to use this class:
	 * This class is the tester for the RunescapeCharacter & RunescapeConstants classes
	 */
	
	// TODO Add proper interface to make adding characters easy...
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		RunescapeCharacter.createFile();
		RunescapeCharacter test2 = new RunescapeCharacter("Endlyng", new ArrayList<Integer>(Arrays.asList(20,13,11,2,8,17,18)));
		RunescapeCharacter test1 = new RunescapeCharacter("CammyJammy", new ArrayList<Integer>(Arrays.asList(4,46,45,54,43,52,48)));
		RunescapeCharacter test3 = new RunescapeCharacter("Urkchar", new ArrayList<Integer>(Arrays.asList(32,30,29,34,30,23,34)));
		RunescapeCharacter test4 = new RunescapeCharacter("IcyDice", new ArrayList<Integer>(Arrays.asList(20,20,19,1,8,2,21)));
		RunescapeCharacter.readStats();
		RunescapeCharacter.parseStats();
	}

}