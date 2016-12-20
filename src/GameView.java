package view;
/**
 * @author Grégory 2TL1 Groupe n°4
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.Controler;

public class GameView extends Container {

	private Dimension dimension = new Dimension();
	private int pts = 0;
	private ImageIcon img;
	private String mot;
	private JLabel 	nombreMot, score, motSecret;
	private ImagePendu imagePendu;
	private JButton bouton[];

	private Controler controler;
	
	/**
	 * @param dim : La classe Dimension encapsule la largeur et la hauteur d'un composant (en précision d'entier) dans un seul objet.
	 */
	public GameView(Dimension dim){
		super(dim);
		init();
	}

	protected void init(){
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		//System.out.println("Size : " + this.dimension.getWidth());
		//Dimension dim = new Dimension((int)(this.dimension.getWidth()/2), (int)this.dimension.getHeight());
		JPanel enTete = new JPanel();
		
		this.imagePendu = new ImagePendu(); 
		this.imagePendu.setPreferredSize(new Dimension(450, 650));
		this.imagePendu.setVerticalAlignment(JLabel.CENTER);
		this.nombreMot = new JLabel();
		this.score = new JLabel(); 

		this.dimension = new Dimension(450, 600); 
		rightPanel.setPreferredSize(this.dimension);
		rightPanel.add(this.imagePendu, BorderLayout.CENTER);
		rightPanel.setBackground(Color.white);

		leftPanel.setPreferredSize(this.dimension);

		Dimension dim = new Dimension(410, 300);
		enTete.setPreferredSize(new Dimension(410, 100));

		this.nombreMot.setText("Nombre de mots trouvés : 0");
		this.nombreMot.setPreferredSize(new Dimension(300, 20));
		this.nombreMot.setHorizontalAlignment(JLabel.CENTER);
		this.nombreMot.setFont(arial);
		enTete.add(this.nombreMot, BorderLayout.NORTH);

		this.score.setText("Votre score actuel est de 0 point.");
		this.score.setPreferredSize(new Dimension(300, 20));
		this.score.setHorizontalAlignment(JLabel.CENTER);
		this.score.setFont(arial);
		enTete.add(this.score, BorderLayout.SOUTH);
		enTete.setBackground(Color.white);

		this.motSecret = new JLabel("ppppppppppppppp");
		this.motSecret.setPreferredSize(new Dimension(400, 60));
		this.motSecret.setForeground(Color.blue);
		this.motSecret.setFont(comics30);
		this.motSecret.setHorizontalAlignment(JLabel.CENTER);
		enTete.add(this.motSecret);

		JPanel corps = new JPanel();
		corps.setPreferredSize(dim);
		corps.setBackground(Color.white);
		char carac[] = {'a', 'b','c', 'd', 'e', 'f',
				'g', 'h', 'i', 'j', 'k', 'l', 
				'm', 'n', 'o', 'p', 'q', 'r', 
				's', 't' ,'u', 'v', 'w', 'x', 
				'y', 'z'};

		BoutonListener bPendu = new BoutonListener();
		Dimension buttonDimension = new Dimension(50,30);
		this.bouton = new JButton[26];
		int i = 0;
		for(char c : carac){//pour afficher toutes les lettres sous forme de boutons en majuscule
			this.bouton[i] = new JButton(String.valueOf(c).toUpperCase());
			bouton[i].addActionListener(bPendu);
			bouton[i].setPreferredSize(buttonDimension);
			corps.add(bouton[i]);
			i++; 
		}

		leftPanel.add(enTete, BorderLayout.NORTH);
		leftPanel.add(corps, BorderLayout.CENTER);
		leftPanel.setBackground(Color.white);

		this.panel.add(leftPanel);
		this.panel.add(rightPanel);

	}

	/**
	 * @param mot : mot récupré dans le dictionnaire 
	 * @param pts : nombre de points du Joueur
	 * @param path : chemin du fichier image à afficher
	 * @param nbreMot : nombre de mot trouvé par le Joueur
	 */
	public void update(String mot, int pts, String path, int nbreMot) {
		this.motSecret.setText(mot);
		this.score.setText("Votre score actuel est de " +pts+" point"+((pts > 1) ? "s" : "")+".");
		this.imagePendu.setImagePath(path);
		this.nombreMot.setText("Nombre de mots trouvés : " +nbreMot);
	}

	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			((JButton)e.getSource()).setEnabled(false);
			//controler.control(((JButton)e.getSource()).getText().charAt(0));
		}		
	}

}
