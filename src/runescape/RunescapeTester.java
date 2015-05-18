package runescape;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class RunescapeTester {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		createInterface();
		RunescapeCharacter test = new RunescapeCharacter();
		RunescapeCharacter test1 = new RunescapeCharacter("CammyJammy", new ArrayList<Integer>(Arrays.asList(4,46,45,54,43,52,48)));
		RunescapeCharacter.createFile();
		test1.writeStats();
		RunescapeCharacter.readStats();
	}
	
	public static void createInterface() {
		JFrame f = new JFrame();
		f.setTitle("Runescape Character Creator");
		f.setSize(800,600);
		f.setVisible(true);
	}

}