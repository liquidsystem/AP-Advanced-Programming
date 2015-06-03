package runescape;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/* Currently testing to see if screen DPI is going to cause an issue with the program... How could I fix it?
 * Personal notes:
 * Laptop - 144DPI, 1920x1080
 * Desktop - 96DPI, 1920x1080
 * 8 pixel difference on the Y axis will set it properly...
 * 
 * 
 */

public class RunescapeUI extends JFrame {

	/** Don't ask why serialVersionUID exists... Eclipse told me I should include it.
	 * 
	 */
	private static final long serialVersionUID = -9153255398948721284L;
	ClassLoader cl = this.getClass().getClassLoader(); 
	public ImageIcon runescapeLoginIntro = new ImageIcon(cl.getResource("runescape/images/rsLogin.jpg"));  // Get the resource of the rsLogin
	public ImageIcon rsLgn = new ImageIcon(cl.getResource("runescape/images/rsLogin2.png"));
	public ImageIcon attackImg, strengthImg, defenseImg, rangeImg, prayerImg, magicImg, hpImg;
	JLabel bg = new JLabel(runescapeLoginIntro);
	JButton loginButton, newAccountButton, searchButton, creditsButton;
	JTextField lookUp;
	final int offset = getScreenResolution();
	final int frameWidth = 765;
	final int frameHeight = 540 - offset;
	final Dimension dm =  new Dimension(135, 35);
	
	public RunescapeUI() {
		Container content = this;
		//debugScreenResolution();
		debugMousePosition(this);
		setDefaultLookAndFeelDecorated(true);
		lookUp = new JTextField();
		loginButton = new JButton();
		searchButton = new JButton();
		newAccountButton = new JButton();
		creditsButton = new JButton();
		
		// creditsButton always shown
		creditsButton.setOpaque(true);
		creditsButton.setBorderPainted(false);
		creditsButton.setContentAreaFilled(false);
		creditsButton.setFocusable(false);
		
		creditsButton.setLocation(frameWidth - 756, frameHeight - (38 + offset));
		creditsButton.setSize(91, 30);
		
		// First original display
		loginButton.setLocation(frameWidth - 370, frameHeight - (231 + offset));
		loginButton.setSize(dm);
		
		newAccountButton.setLocation(frameWidth - 529, frameHeight - (230 + offset));
		newAccountButton.setSize(dm);
		
		// Buttons that show up after you click loginButton
		searchButton.setLocation(frameWidth - 442, frameHeight - (204 + offset));
		searchButton.setSize(dm);
		
		lookUp.setLocation(frameWidth - 425, frameHeight - (285 + offset));
		lookUp.setSize(125, 20);
		
		
		searchButton.setOpaque(false);
		searchButton.setBackground(Color.black);
		searchButton.setBorderPainted(false);
		searchButton.setContentAreaFilled(false);
		searchButton.setVisible(false);
		searchButton.setFocusable(false);
		
		lookUp.setOpaque(true);
		lookUp.setBackground(new Color(72, 75, 84));
		lookUp.setForeground(Color.white);
		lookUp.setBorder(BorderFactory.createEmptyBorder());
		lookUp.setVisible(false);
		lookUp.setFocusable(true);
		
		newAccountButton.setOpaque(false);
		newAccountButton.setBorderPainted(false);
		newAccountButton.setContentAreaFilled(false);
		newAccountButton.setBackground(Color.black);
		newAccountButton.setFocusable(false);
		
		loginButton.setOpaque(false);
		loginButton.setBackground(Color.BLACK);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setFocusable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);  // Don't allow the frame to be resized, we don't want it to distort the login picture
		getContentPane().add(loginButton);
		getContentPane().add(newAccountButton);
		getContentPane().add(lookUp);
		getContentPane().add(bg);  // Add the runescape login picture to the frame
		getContentPane().add(searchButton);
		getContentPane().add(creditsButton);
		bg.setSize(this.getSize().width, this.getSize().height);
		setComponentZOrder(searchButton, 0);
		setComponentZOrder(loginButton, 0);
		setComponentZOrder(lookUp, 0);
		setComponentZOrder(newAccountButton, 0);
		setComponentZOrder(creditsButton, 0);
		setComponentZOrder(bg, 1);
		setSize(frameWidth, frameHeight);  // Don't change this! This is the perfect size for the rsLogin picture!
		
		creditsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(content, "Credits: " + "\n" 
			+ "Cameron Kurtz - Lead Developer, only developer.");
			}
		});
		
		loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("Registered existing character click...");
                newAccountButton.setEnabled(false);
                newAccountButton.setVisible(false);
                loginButton.setEnabled(false);
                loginButton.setVisible(false);
                bg.setIcon(rsLgn);
                lookUp.setIgnoreRepaint(true);
                lookUp.setVisible(true);
                lookUp.requestFocusInWindow();
                searchButton.setVisible(true);
            }
        });
		lookUp.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER && !lookUp.getText().isEmpty()) {
						try {
							RunescapeCharacter.readStats(lookUp.getText().toLowerCase().toString());
						} catch (Throwable e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						lookUp.setText("");
						lookUp.requestFocusInWindow();
				}
			}
		});
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ayy!");
				if(lookUp.getText().isEmpty()) {
					System.out.println("There should be text here!");
				}
				if(lookUp.getText() == null) {
					System.out.println("They need to  enter text here!");
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
				System.out.println("Character import...");
				newAccountButton.setEnabled(false);
                newAccountButton.setVisible(false);
                loginButton.setEnabled(false);
                loginButton.setVisible(false);
			}
		});
		
		
	}
	
	private int getScreenResolution() {
		int screenResolution = Toolkit.getDefaultToolkit().getScreenResolution();
		int offset;
		if(screenResolution == 144) {
			offset = 0;
		}
		else {
			offset = (144 - screenResolution) / 6;
		}
		return offset;
	}

	private static void debugScreenResolution() {
		final JFrame box = new JFrame("Screen Res.");
		box.setAlwaysOnTop(true);
		box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		box.setSize(600, 100);
		box.setLayout(new GridLayout(1,3));
		box.setVisible(true);
		int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JLabel wid = new JLabel("Width: " + String.valueOf(screenSize.getWidth()));
		JLabel hei = new JLabel("Height: " + String.valueOf(screenSize.getHeight()));
		JLabel res = new JLabel("Resolution: " + String.valueOf(screenRes));
		box.add(wid);
		box.add(hei);
		box.add(res);
		
		
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
	
	public void getAssets() {
		
	}
	
	public static void main(String[] args) {
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
