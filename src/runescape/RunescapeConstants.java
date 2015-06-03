package runescape;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.omg.PortableInterceptor.USER_EXCEPTION;

/* Purpose of this class is to show constants in Interfaces
 * I'm mostly just going to use it to implement it.
 */

public abstract class RunescapeConstants {
	
	public String name;
	
	public static double finalLevel = 3;
	
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
	
	public double baseLevel;
	public double meleeLevel;
	public double rangeLevel;
	public double magicLevel;
	public double combatLevel;
	
	static public File statFile;
	static public File statFolder;
	public static String path = System.getProperty("user.home");
	protected static ArrayList<String> list;
	
	public static int maxLevel = 99;
	
	public static String getPath() {
		return path;
	}
	
	

	/** Checks to make sure that the skills entered are not over level 99
	 * 
	 */
	public void checkLevel() {
		for(int i  = 0; i < stats.size(); i++) {
			if(this.stats.get(combatNames[i].toLowerCase()) > 99) {
				System.out.println("Your level can not be over level 99!");
				break;
			}
		}
		if(this.stats.get("hitpoints") < 10) {
			System.out.println("Your hitpoints HAS to be over 10!");
		}
	}
	
	
	public String getStats() {
		return this.stats.toString();
	}
	
	public String getUser() {
		return this.name;
	}
	
	public static HashMap<String, Integer> getStatNames() {
		HashMap<String, Integer> statNames = stats;
		
		return statNames;
	}
	
	public RunescapeCharacter getChar() {
		return (RunescapeCharacter) this;
	}
	
	public double calculateFinalLevel() {
		//Placeholder equations to use for finalLevel
		this.baseLevel = 0.25 * (stats.get("defense") + stats.get("hitpoints") + Math.floor(stats.get("prayer")/2));
		this.meleeLevel = 0.325 * (stats.get("attack") + stats.get("strength"));
		this.rangeLevel = 0.325 * (Math.floor(stats.get("range")/2) + stats.get("range"));
		this.magicLevel = 0.325 * (Math.floor(stats.get("magic")/2) + stats.get("magic"));
		  
		this.combatLevel = Math.floor(this.baseLevel + Math.max(this.meleeLevel, Math.max(this.rangeLevel, magicLevel)));
		
		return this.combatLevel;
	}
	
}