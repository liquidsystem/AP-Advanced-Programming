package runescape;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Purpose: This class is meant to allow the creation of a RunescapeCharacter and to store it in a text file with BufferedStreams
 * 
 */

public class RunescapeCharacter extends RunescapeConstants {
	
	/**
	 * @param n - Username
	 * @param statLevels - An ArrayList that accepts only integers, one for every skill
	 * @throws Throwable - Throws exception if you use too many integers for the stats
	 */
	RunescapeCharacter(String n, ArrayList<Integer> statLevels) throws Throwable {
		super();
		name = n;
		int j = stats.size();
		for(int i = 0; i < j; i++) {
			if(statLevels.size() < NUM_OF_COMBAT) {
				j = statLevels.size();
				System.out.println("Array passed to character is less than the total amount of combat skills! (This isn't a problem, just don't go passed the amount we entered!");
				if(combatNames[i].isEmpty()) {
					break;
				}
				else {
					stats.put(combatNames[i].toLowerCase(), statLevels.get(i));
				}
			}
			else if(statLevels.size() > NUM_OF_COMBAT) {
				System.out.println("Array passed to stats is greater than the total combat skills! (This is VERY BAD, DO SOMETHING ABOUT IT");
				throw new Throwable("Invalid amount of allowed arguments for stats");
			}
			else {
				//System.out.println("Array is passed the same amount of arguments as the allowed combat skills! (This is good)");
				if(stats.containsKey(combatNames[i].toLowerCase())) {
					stats.put(combatNames[i].toLowerCase(), statLevels.get(i));
					//System.out.println(stats.get(combatNames[i].toLowerCase()));
				}
			}
		}
		this.checkLevel();
	}
	
	public void enterCombatSkills(String stat, int value) {
		if(super.stats.containsKey(stat)) {
			super.stats.put(stat, value);
		}
		else {
			System.out.println("This stat does not exist... Possible options are 'attack', 'strength', 'defense', 'range', 'magic', and 'prayer'!");
		}
	}
	
	public void enterCombatSkills(ArrayList<Integer> combats) {
		for(int i = 0; i < this.stats.size(); i++) {
			super.stats.put(combatNames[i].toLowerCase(), combats.get(i));
		}
	}
	
	public String getCombatLevel() {
		String output = "";
		double temp = calculateFinalLevel();
		output = "Your total combined stats will give you: " + temp + " combat.";
		return output;
		
	}
	
	public RunescapeCharacter getCharacter() {
		RunescapeCharacter a = this;
		return a;
	}
	
	
	/** Similar to String.toString() but using our own set of information
	 * @return output - String that comprises of the username + stats for that object
	 */
	public String dataToString() {
		String username = this.getUser();
		String stats = this.getStats();
		String output = username + stats.toString();
		
		return output;
	}
	

	/** Method to create a file in the location of the class, usually found in ..\bin\stats.txt
	 *
	 * 
	 */
	public static void createFile() {
		// TODO Auto-generated method stub
		try {
			//Get information from here and store it
			statFile = new File(path + "stats.txt");
			if(statFile.isFile() && !statFile.isDirectory()) {
				System.out.println("This already exists..");
			}
			else if(!statFile.exists()) {
				System.out.println("Ayy this doesn't exist");
				statFile.createNewFile();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//End of File Creation Segment
	}
	
	/** Writes to the stats.txt file, with the given information of the object.
	 * @throws Throwable 
	 * 
	 */
	public void writeStats() throws Throwable {
		/* Attempt to gather information about statistics and apply them here... */
		try {
			String info = this.dataToString();
			System.out.println("Information attempting to place: " + info);
			
			
			Scanner s = new Scanner(statFile);
			FileWriter fw = new FileWriter(statFile.getAbsolutePath(), true);
			FileReader fr = new FileReader(statFile.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fw);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			if(statFile.length() == 0) {
				bw.write(info);
			}
			while(s.hasNextLine() && (line = s.nextLine()) != null) {
				if(line.equalsIgnoreCase(info) && s.hasNextLine()) {
					line = s.nextLine();
					break;
				}
				else if(!line.equalsIgnoreCase(info) && !s.hasNextLine()) {
					bw.newLine();
					bw.write(info);
					break;
				}
			}
			s.close();
			br.close();
			fr.close();
			bw.close();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		readStats();
	}
	
	
	/** Reads in from the stats.txt file, creates a new list that includes every line, which contains our character information
	 * @throws Throwable
	 */
	public static void readStats() throws Throwable {
		try {
			Scanner s = new Scanner(statFile);
			String line = null;
			list = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(statFile));
			while(s.hasNextLine() && (line = s.nextLine()) != null) {
				if(list.contains(line)) {
					System.out.println("This entry is already in list!");
				}
				else {
					list.add(line);
				}
			}
			br.close();
			System.out.println("List size: " + list.size());
			s.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/** Parse the information that we found in the file, and makes a new RunescapeCharacter from the information found on each line.
	 * @throws Throwable - NumberFormatException: if the input that is passed is unable to be parsed to an integer, it'll go ahead and search 1 space less than the previous search
	 */
	public static void parseStats() throws Throwable {
		String name = "Test";
		int atk = 1;
		int str = 1;
		int def = 1;
		int range = 1;
		int pray = 1;
		int mage = 1;
		int hp = 10;
		for(int i = 0; i < list.size(); i++) {
			name = list.get(i).substring(0, list.get(i).indexOf("{"));
			
			/* Start of long try-catch for each stat, no point in reading this, as this was the only way I could find to properly parse the information that I had
			 * Starting with Attack */
			try {
				atk = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("attack=") + "attack=".length(), list.get(i).indexOf("attack=") + "attack=".length() + 2));
			}
			catch(NumberFormatException e) {
				atk = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("attack=") + "attack=".length(), list.get(i).indexOf("attack=") + "attack=".length() + 1));
			}
			
			try {
				str = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("strength=") + "strength=".length(), list.get(i).indexOf("strength=") + "strength=".length() + 2));
			}
			catch(NumberFormatException e) {
				str = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("strength=") + "strength=".length(), list.get(i).indexOf("strength=") + "strength=".length() + 1));
			}
			
			try {
				def = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("defense=") + "defense=".length(), list.get(i).indexOf("defense=") + "defense=".length() + 2));
			}
			catch(NumberFormatException e) {
				def = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("defense=") + "defense=".length(), list.get(i).indexOf("defense=") + "defense=".length() + 1));
			}
			
			try {
				range = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("range=") + "range=".length(), list.get(i).indexOf("range=") + "range=".length() + 2));
			}
			catch(NumberFormatException e) {
				range = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("range=") + "range=".length(), list.get(i).indexOf("range=") + "range=".length() + 1));
			}
			
			try {
				pray = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("prayer=") + "prayer=".length(), list.get(i).indexOf("prayer=") + "prayer=".length() + 2));
			}
			catch(NumberFormatException e) {
				pray = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("prayer=") + "prayer=".length(), list.get(i).indexOf("prayer=") + "prayer=".length() + 1));
			}
			
			try {
				mage = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("magic=") + "magic=".length(), list.get(i).indexOf("magic=") + "magic=".length() + 2));
			}
			catch(NumberFormatException e) {
				mage = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("magic=") + "magic=".length(), list.get(i).indexOf("magic=") + "magic=".length() + 1));
			}
			
			try {
				hp = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("hitpoints=") + "hitpoints=".length(), list.get(i).indexOf("hitpoints=") + "hitpoints=".length() + 2));
			}
			catch(NumberFormatException e) {
				hp = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("hitpoints=") + "hitpoints=".length(), list.get(i).indexOf("hitpoints=") + "hitpoints=".length() + 1));
			}
			
			System.out.println("Character Name: " + name + "\n" + 
			"Stats" + "\n"
			+ "-----------------------" + "\n"
			+ "| Attack: " + atk + "\n" 
			+ "| Strength: " + str + "\n" 
			+ "| Defense: " + def + "\n" 
			+ "| Range: " + range + "\n" 
			+ "| Prayer: " + pray + "\n"
			+ "| Magic: " + mage + "\n"
			+ "| Hitpoints: " + hp + "\n"
			+ "-----------------------" + "\n");
		}
	}
	
	
}