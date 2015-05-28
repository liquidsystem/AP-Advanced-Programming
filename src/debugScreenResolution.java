import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class debugScreenResolution {

	public static void main(String[] args) {
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
		box.setResizable(false);

	}

}
