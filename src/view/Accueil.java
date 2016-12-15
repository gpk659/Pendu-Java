package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Accueil extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public Accueil() {
		JLabel titre = new JLabel("Bienvenue, voici le jeu du Pendu !");
		JButton button = new JButton("PLAY");
		JLabel image = new JLabel(new ImageIcon("images/dessin-pendu-1.png"));
		add(image);
		add(titre);
		add(button);
	}
}
