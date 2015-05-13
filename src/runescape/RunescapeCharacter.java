package runescape;

import java.util.ArrayList;

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
	
	RunescapeCharacter(ArrayList<Integer> statLevels) throws Throwable {
		super();
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
				System.out.println("Array is passed the same amount of arguments as the allowed combat skills! (This is good)");
				if(stats.containsKey(combatNames[i].toLowerCase())) {
					stats.put(combatNames[i].toLowerCase(), statLevels.get(i));
					System.out.println(stats.get(combatNames[i].toLowerCase()));
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
	
	public static void sendData() {
		
	}
	
	public static String dataToString() {
		String username = getUser();
		String stats = getStats();
		String output = username + stats.toString();
		
		return output;
	}
	
	
}