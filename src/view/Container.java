package view;
/**
 * @author Grégory Pyck, Simon Barré, Amine Nafia 2TL1 G4
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JPanel;

public abstract class Container{
	protected JPanel panel;
	//polices d'écritures définies ici pour ne pas avoir à recopier ceci
	protected Font comics30 = new Font("Comics Sans MS", Font.BOLD, 30);
	protected Font comics40 = new Font("Comics Sans MS", Font.BOLD, 40);
	protected Font comics20 = new Font("Comics Sans MS", Font.BOLD, 20);
	protected Font comics15 = new Font("Comics Sans MS", Font.BOLD, 15);
	protected Font arial = new Font("Arial", Font.BOLD, 15);
	protected Font Harlow = new Font("Harlow Solid Italic", Font.BOLD,25);
	
	/**
	 * @param dim : La classe Dimension encapsule la largeur et la hauteur d'un composant (en précision d'entier) dans un seul objet.
	 */
	public Container(Dimension dim){
		this.panel = new JPanel();
		this.panel.setPreferredSize(dim);
		this.panel.setBackground(Color.white);
	}
	
	/**
	 * @return renvoie le JPanel 
	 */
	protected JPanel getPanel(){
		return this.panel;
	}
	
	protected abstract void init() throws IOException;	
	
}

