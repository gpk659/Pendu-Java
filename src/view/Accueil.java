package vue;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Accueil extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Accueil() {
		JLabel titre = new JLabel("Bienvenue dans le jeu du pendu\n");
		titre.setHorizontalAlignment(JLabel.CENTER);
	}
}
