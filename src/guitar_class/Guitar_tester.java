package guitar_class;

import javax.swing.JOptionPane;

public class Guitar_tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Guitar poptun = new Guitar();
		Guitar bubby = new Guitar("Fender","Stratocaster","Cherry Red",'f');
		
		System.out.println(poptun);
		System.out.println(bubby);
		JOptionPane.showMessageDialog(null,bubby);
	}

}
