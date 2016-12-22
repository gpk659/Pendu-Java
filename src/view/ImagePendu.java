package view;
/**
 * @author Grégory 2TL1 Groupe n°4
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class ImagePendu extends JLabel{

	private String imagePath = "images/trump.jpg";
	public ImagePendu(){	}

	/**
	 * @param path : adresse de l'image à afficher
	 */
	public ImagePendu(String path){
		this.imagePath = path;
	}

	public void paint(Graphics g){
		g.setColor(Color.red);
		g.drawRect(0, 0, this.getWidth(), this.getHeight());
		try {
			Image img = ImageIO.read(new File(this.imagePath));
			g.drawImage(img, 0, 0, this);
			ConsoleView.msgVConsole("Chargement de l'image réussie !");
		} catch (IOException e) {
			e.printStackTrace();
			ConsoleView.msgVConsole("Erreur au chargement de l'image..!");
		}
	}
	
	/**
	 * @param path : chemin du fichier image
	 */
	public void setImagePath(String path){
		this.imagePath = path;
		//repaint();
	}
}