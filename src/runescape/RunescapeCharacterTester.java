package runescape;

import java.util.ArrayList;
import java.util.Arrays;

public class RunescapeCharacterTester {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		RunescapeCharacter test = new RunescapeCharacter();
		RunescapeCharacter test1 = new RunescapeCharacter(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,10)));
		System.out.println(test1.getFinalLevel());
	}

}
