package view;
/**
 * @author Grégory 2TL1 Groupe n°4
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
		JLabel image = new JLabel(new ImageIcon("images/accueil.jpg"));	
		this.panel.add(image, BorderLayout.CENTER);		
	}
}
