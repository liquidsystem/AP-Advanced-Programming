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
	RunescapeCharacter() {
		super();
	}
	
	RunescapeCharacter(String n) {
		super();
		name = n;
	}
	
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
	
	public static void enterCombatSkills(String stat, int value) {
		if(stats.containsKey(stat)) {
			stats.put(stat, value);
		}
		else {
			System.out.println("This stat does not exist... Possible options are 'attack', 'strength', 'defense', 'range', 'magic', and 'prayer'!");
		}
	}
	
	public static void enterCombatSkills(ArrayList<Integer> combats) {
		for(int i = 0; i < stats.size(); i++) {
			stats.put(combatNames[i].toLowerCase(), combats.get(i));
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
	
	
	public String dataToString() {
		String username = getUser();
		String stats = getStats();
		String output = username + stats.toString();
		
		return output;
	}
	

	public static void createFile() {
		// TODO Auto-generated method stub
		try {
			
			System.out.println(path);
			
			//Get information from here and store it
			statFile = new File(path+"stats.txt");
			if(statFile.exists()) {
				path = statFile.getAbsolutePath();
				System.out.println("Absolute Filepath: " + path);
			}
			else if(!statFile.exists()) {
				statFile.createNewFile();
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//End of File Creation Segment
	}
	
	public void writeStats() {
		/* Attempt to gather information about statistics and apply them here... */
		String info = dataToString();
		System.out.println(info);
		try {
			Scanner s = new Scanner(statFile);
			FileWriter fw = new FileWriter(statFile.getAbsolutePath());
			FileReader fr = new FileReader(statFile.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fw);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			if((line = br.readLine()) == null) {
				bw.write(info);
				bw.close();
			}
			while((line = br.readLine()) != null){
					if(line.equals(info)) {
						System.out.println("This is the same!");
						bw.close();
					}
					else {
						System.out.println("Not same");
						bw.write(info);
						bw.newLine();
						bw.close();
					}
				}
			s.close();
			br.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		//readStats();
	}
	
	public static void readStats() throws Throwable {
		try {
			Scanner s = new Scanner(statFile);
			list = new ArrayList<String>();
			//BufferedReader br = new BufferedReader(new FileReader(path));
			while(s.hasNext()) {
				list.add(s.nextLine());
			}
			//br.close();
			s.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		parseStats();
	}
	
	public static void parseStats() throws Throwable {
		String name = "Test";
		int atk = 1;
		int str = 1;
		int def = 1;
		int range = 1;
		int pray = 1;
		int mage = 1;
		int hp = 10;
		System.out.println(list.size());
		System.out.println(list.get(0));
		for(int i = 0; i < list.size(); i++) {
			name = list.get(i).substring(0, list.get(i).indexOf("{"));
			
			/* Start of long try-catch for each stat.
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
			
			System.out.println(new RunescapeCharacter(name, new ArrayList<Integer>(Arrays.asList(atk,str,def,range,pray,mage,hp))).dataToString());
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