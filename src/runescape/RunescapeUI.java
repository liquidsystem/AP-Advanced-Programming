package runescape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;

public class RunescapeUI extends JFrame {

	/** Don't ask why serialVersionUID exists... Eclipse told me I should include it.
	 * 
	 */
	private static final long serialVersionUID = -9153255398948721284L;
	ClassLoader cl = this.getClass().getClassLoader(); 
	public ImageIcon runescapeLoginIntro = new ImageIcon(cl.getResource("runescape/images/rsLogin.jpg"));  // Get the resource of the rsLogin
	JLabel bg = new JLabel(runescapeLoginIntro);
	JButton loginButton, newAccountButton;
		
	
	public RunescapeUI() {
		//debugMousePosition(this);
		loginButton = new JButton();
		loginButton.setOpaque(false);
		loginButton.setBackground(Color.BLACK);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setBounds(393, 309, (533 - 393), (346 - 309));
		
		loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
        });
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(765, 540);  // Don't change this! This is the perfect size for the rsLogin picture!
		setResizable(false);  // Don't allow the frame to be resized, we don't want it to distort the login picture
		getContentPane().add(loginButton);
		getContentPane().add(bg);  // Add the runescape login picture to the frame
		setComponentZOrder(loginButton, 0);
		setComponentZOrder(bg, 1);
		repaint();
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
