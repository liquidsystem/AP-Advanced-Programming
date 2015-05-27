package runescape;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

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
	final int height = 540;
	final int width = 765;
		
	
	public RunescapeUI() {
		
		debugMousePosition(this);
		setDefaultLookAndFeelDecorated(true);
		lookUp = new JTextField();
		loginButton = new JButton();
		searchButton = new JButton();
		newAccountButton = new JButton();
		
		
		searchButton.setOpaque(false);
		searchButton.setBackground(Color.BLACK);
		searchButton.setBorderPainted(false);
		searchButton.setContentAreaFilled(false);
		searchButton.setVisible(false);
		
		searchButton.setBounds(width - 434, height - 214, (456 - 331), (351 - 326));
		lookUp.setBounds(341, 256, (467 - 341), (280 - 260));
		loginButton.setBounds(396, 309, (531 - 396), (343 - 311));
		newAccountButton.setLocation(width - 529, height - 230);
		newAccountButton.setSize(135, 35);
		//newAccountButton.setBounds(width - 529, height - 230, 135, 35);
		
		lookUp.setBackground(Color.darkGray);
		lookUp.setForeground(Color.white);
		lookUp.setBorder(BorderFactory.createEmptyBorder());
		lookUp.setVisible(false);
		lookUp.requestFocus();
		
		newAccountButton.setOpaque(true);
		newAccountButton.setBorderPainted(false);
		newAccountButton.setContentAreaFilled(true);
		newAccountButton.setBackground(Color.darkGray.brighter());
		
		loginButton.setOpaque(false);
		loginButton.setBackground(Color.BLACK);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);  // Don't allow the frame to be resized, we don't want it to distort the login picture
		getContentPane().add(loginButton);
		getContentPane().add(newAccountButton);
		getContentPane().add(lookUp);
		getContentPane().add(bg);  // Add the runescape login picture to the frame
		getContentPane().add(searchButton);
		bg.setSize(this.getSize().width, this.getSize().height);
		setComponentZOrder(searchButton, 0);
		setComponentZOrder(loginButton, 0);
		setComponentZOrder(lookUp, 0);
		setComponentZOrder(newAccountButton, 0);
		setComponentZOrder(bg, 1);
		setPreferredSize(new Dimension(width, height));
		setSize(width, height);  // Don't change this! This is the perfect size for the rsLogin picture!
		
		loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("Registered existing character click...");
                newAccountButton.setEnabled(false);
                newAccountButton.setVisible(false);
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
		
		
	}
	
	/** Debug frame for getting the mouse information. Not intended to have in final project.
	 * @param frame
	 */
	private static void debugMousePosition(JFrame frame) {
		final JFrame box = new JFrame("Mouse Position");
		box.setAlwaysOnTop(true);
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box.setLocation(frame.getX() + 800,frame.getY());
		box.setSize(300, 100);
		box.setLayout(new GridLayout(1,2));
		box.setVisible(true);
		final JLabel X = new JLabel();
		final JLabel Y = new JLabel();
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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {

	           public void run() {
	              new RunescapeUI().setVisible(true);
	           }
	        });
	}

}
