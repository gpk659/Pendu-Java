package vue;

import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Fenetre(String title) {
		setTitle(title);
		setSize(1200, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		add(new Accueil());
	
	}

}
