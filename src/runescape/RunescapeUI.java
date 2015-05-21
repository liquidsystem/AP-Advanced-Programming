package runescape;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RunescapeUI extends JFrame {

	/** Don't ask why serialVersionUID exists... Eclipse told me I should include it.
	 * 
	 */
	private static final long serialVersionUID = -9153255398948721284L;
	public ImageIcon imageIcon = new ImageIcon("get path name here pls");
	JLabel imageLabel = new JLabel(imageIcon);
	
	public RunescapeUI() {
		setSize(765, 503);
		setResizable(false);
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
