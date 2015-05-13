package runescape;

import java.lang.Math;
import java.util.HashMap;

/* Purpose of this class is to show constants in Interfaces
 * I'm mostly just going to use it to implement it.
 */

public abstract class RunescapeConstants {
	
	public static String name;
	
	public static double finalLevel = 3;
	
	public final static int NUM_OF_COMBAT = 7;
	
	
	public static String[] combatNames = {"Attack","Strength","Defense","Range","Prayer","Magic","Hitpoints"};
	
	public static final float xpGrowth = (float) Math.pow(2, 1/7); //On the RS website, 2^(1/7) is the average growth factor per level
	
	@SuppressWarnings("serial")
	public static HashMap<String, Integer> stats = new HashMap<String, Integer>() {{
		put("attack", 1);
		put("strength", 1);
		put("defense", 1);
		put("range", 1);
		put("prayer", 1);
		put("magic", 1);
		put("hitpoints", 10);
	}};
	
	public static double baseLevel;
	public static double meleeLevel;
	public static double rangeLevel;
	public static double magicLevel;
	
	public static int maxLevel = 99;
	
	public void checkLevel() {
		for(int i  = 0; i < stats.size(); i++) {
			if(stats.get(combatNames[i].toLowerCase()) > 99) {
				System.out.println("Your level can not be over level 99!");
				break;
			}
			if(stats.get("hitpoints") < 10) {
				System.out.println("You cannot have a HITPOINTS level less than 10!");
				break;
			}
		}
		if(stats.get("hitpoints") < 10) {
			System.out.println("Your hitpoints HAS to be over 10!");
		}
	}
	
	
	public static String getStats() {
		return stats.toString();
	}
	
	public static String getUser() {
		return name;
	}
	
	public RunescapeCharacter getChar() {
		return (RunescapeCharacter) this;
	}
	
	public static double calculateFinalLevel() {
		//Placeholder equations to use for finalLevel
		baseLevel = 0.25 * (stats.get("defense") + stats.get("hitpoints") + Math.floor(stats.get("prayer")/2));
		meleeLevel = 0.325 * (stats.get("attack") + stats.get("strength"));
		rangeLevel = 0.325 * (Math.floor(stats.get("range")/2) + stats.get("range"));
		magicLevel = 0.325 * (Math.floor(stats.get("magic")/2) + stats.get("magic"));
		  
		finalLevel = Math.floor(baseLevel + Math.max(meleeLevel, Math.max(rangeLevel, magicLevel)));
		
		return finalLevel;
	}
	
}