package runescape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javafx.scene.input.KeyCode;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class RunescapeUI extends JFrame {

	/** Don't ask why serialVersionUID exists... Eclipse told me I should include it.
	 * 
	 */
	private static final long serialVersionUID = -9153255398948721284L;
	ClassLoader cl = this.getClass().getClassLoader(); 
	public ImageIcon runescapeLoginIntro = new ImageIcon(cl.getResource("runescape/images/rsLogin.jpg"));  // Get the resource of the rsLogin
	public ImageIcon rsLgn = new ImageIcon(cl.getResource("runescape/images/rsLogin2.png"));
	JLabel bg = new JLabel(runescapeLoginIntro);
	JButton loginButton, newAccountButton, searchButton;
	JTextField lookUp;
		
	
	public RunescapeUI() {
		//debugMousePosition(this);
		setDefaultLookAndFeelDecorated(false);
		lookUp = new JTextField();
		searchButton = new JButton();
		searchButton.setOpaque(false);
		searchButton.setBackground(Color.BLACK);
		searchButton.setBorderPainted(false);
		searchButton.setContentAreaFilled(false);
		searchButton.setVisible(false);
		searchButton.setBounds(331, 326, (456 - 331), (351 - 326));
		
		lookUp.setBounds(339, 235, (469 - 339), (260 - 241));
		lookUp.setBackground(Color.darkGray);
		lookUp.setForeground(Color.white);
		lookUp.setBorder(BorderFactory.createEmptyBorder());
		lookUp.setVisible(false);
		lookUp.requestFocus();
		newAccountButton = new JButton();
		newAccountButton.setOpaque(true);
		newAccountButton.setBorderPainted(false);
		newAccountButton.setContentAreaFilled(true);
		newAccountButton.setBackground(Color.darkGray.brighter());
		
		loginButton = new JButton();
		loginButton.setOpaque(false);
		loginButton.setBackground(Color.BLACK);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setBounds(392, 291, (533 - 392), (346 - 291));
		newAccountButton.setBounds(235, 292, (369 - 235), (325 - 291));
		
		loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("Registered existing character click...");
                newAccountButton.setEnabled(false);
                newAccountButton.setOpaque(false);
                loginButton.setEnabled(false);
                bg.setIcon(rsLgn);
                lookUp.setVisible(true);
                searchButton.setVisible(true);
                
            }
        });
		lookUp.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
						try {
							RunescapeCharacter.readStats(lookUp.getText().toLowerCase().toString());
						} catch (Throwable e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lookUp.setText("");
				}
			}
		});
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ayy!");
				if(lookUp.getText().isEmpty()) {
					System.out.println("There should be text here!");
				}
				else {
					if(lookUp.getText().contains(" ")) {
						System.out.println("No spaces are allowed!");
					}
					else if(lookUp.getText().isEmpty()) {
						System.out.println("You need text here!");
					}
					else {
						System.out.println("Text in box: " + lookUp.getText().toString());
						try {
							RunescapeCharacter.readStats(lookUp.getText().toLowerCase().toString());
							lookUp.setText("");
						} catch (Throwable e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		newAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Feature disabled");
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(765, 520);  // Don't change this! This is the perfect size for the rsLogin picture!
		setResizable(false);  // Don't allow the frame to be resized, we don't want it to distort the login picture
		getContentPane().add(loginButton);
		getContentPane().add(newAccountButton);
		getContentPane().add(lookUp);
		getContentPane().add(bg);  // Add the runescape login picture to the frame
		getContentPane().add(searchButton);
		setComponentZOrder(searchButton, 0);
		setComponentZOrder(loginButton, 0);
		setComponentZOrder(lookUp, 0);
		setComponentZOrder(newAccountButton, 0);
		setComponentZOrder(bg, 1);
	}
	
	/** Debug frame for getting the mouse information. Not intended to have in final project.
	 * @param frame
	 */
	private static void debugMousePosition(JFrame frame) {
		JFrame box = new JFrame("Mouse Position");
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box.setLocation(frame.getX() + 800,frame.getY());
		box.setSize(300, 100);
		box.setLayout(new GridLayout(1,2));
		box.setVisible(true);
		JLabel X = new JLabel();
		JLabel Y = new JLabel();
		frame.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent me) {
				X.setText(String.valueOf("X Position: " + me.getX()));
				Y.setText(String.valueOf("Y Position: " + me.getY()));
				box.repaint();
			}
		});
		box.add(X);
		box.add(Y);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

	           @Override
	           public void run() {
	              new RunescapeUI().setVisible(true);
	           }
	        });
	}

}
