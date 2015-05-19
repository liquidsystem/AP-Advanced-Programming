package runescape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.layout.BorderPane;

import javax.swing.*;

public class RunescapeTester {
	/* b1 = lookup user
	 * b2 = create user
	 * b3 = go back */
	JButton b1, b2, b3;
	
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
		JPanel p = new JPanel();
		
		p.setSize(f.getContentPane().getSize());
		
		f.setTitle("Runescape Character Creator");
		f.pack();
		f.setSize(800,600);
		f.setLocationByPlatform(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		
		JButton b1 = new JButton("Lookup User");
		JButton b2 = new JButton("Create user");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.remove(b1);
				p.remove(b2);
				p.repaint();
				System.out.println("Ayy");
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.remove(b1);
				p.remove(b2);
				p.repaint();
			}
		});
		
		p.add(b1);
		f.add(p, BorderLayout.CENTER);
		
		
		f.setVisible(true);
	}

}