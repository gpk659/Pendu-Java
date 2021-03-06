package view;
/**
 * @author Gr�gory Pyck, Simon Barr�, Amine Nafia 2TL1 G4
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class ImagePendu extends JLabel{

	private String imagePath = "images/trump0.jpg";
	public ImagePendu(){	}

	/**
	 * @param path : adresse de l'image � afficher
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
			ConsoleView.msgVConsole("Chargement de l'image r�ussie !");
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
		
		/*
		 * repaint(); permet de redessiner l'image au moment ou on change de chemin pour afficher une image
		 * sinon l'image ne change pas en fonction des erreurs
		 * on utilise donc repaint pour afficher la nouvelle image en fonction du nombre d'erreurs
		 */
		repaint();
	}
}