package runescape;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RSCharacterWriter extends RunescapeCharacter {
	static private File statFile = null;
	static private String path = RSCharacterWriter.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	static private ArrayList<String> list;
	public static void main(String[] args) {
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
		writeStats();
		
	}
	
	public static void writeStats() {
		/* Attempt to gather information about statistics and apply them here... */
		String info = dataToString();
		
		try {
			FileWriter fw = new FileWriter(statFile.getAbsolutePath(), false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(info);
			bw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		readStats();
	}
	
	public static void readStats() {
		try {
			Scanner s = new Scanner(statFile);
			list = new ArrayList<String>();
			//BufferedReader br = new BufferedReader(new FileReader(path));
			while(s.hasNext()) {
				list.add(s.nextLine());
			}
			//br.close();
			s.close();
			System.out.println(list);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		parseStats();
	}
	
	public static void parseStats() {
		String[] data = new String[7];
		for(int i = 0; i < list.size(); i++) {
			data[i] = list.get(i).toString();
		}
		String name = "Test";
		String atk = "a";
		int str = 1;
		int def = 1;
		int range = 1;
		int pray = 1;
		int mage = 1;
		int hp = 10;
		System.out.println(list.size());
		System.out.println(data[0]);
		for(int i = 0; i < data.length; i++) {
			name = data[i].substring(0, data[i].indexOf("{"));
			atk = data[i];
		}
		System.out.println(name);
		System.out.println(atk);
		//System.out.println(list.get(1).substring(0));
	}

}
