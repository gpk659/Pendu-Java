package view;
/**
 * @author Grégory Pyck, Simon Barré, Amine Nafia 2TL1 G4
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AcceuilView extends Container {
	
	/**
	 * @param dim : La classe Dimension encapsule la largeur et la hauteur d'un composant (en précision d'entier) dans un seul objet.
	 */
	
	public AcceuilView(Dimension dim){
		super(dim);
		init();
	}
	
	public void init(){
		JPanel imgPanel = new JPanel();
		JLabel image = new JLabel(new ImageIcon("images/accueil.jpg"));	
		imgPanel.add(image, BorderLayout.CENTER);
		image.setVerticalAlignment(JLabel.CENTER);
		imgPanel.setPreferredSize(new Dimension(1000,700));
		this.panel.add(imgPanel);
		imgPanel.setBackground(Color.white);
	}
}
