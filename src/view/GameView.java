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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controler.Controler;
import model.Joueur;
import observer.Observable;
import observer.Observer;
import view.ImagePendu;
import view.ScoreView;

public class GameView extends Container implements Observer{

	private Dimension dimension = new Dimension();
	private int pts = 0;
	private ImageIcon img;
	private String mot;
	private JLabel 	nombreMot, score, motSecret,pseudo;
	private ImagePendu imagePendu;
	private JButton bouton[];
	public Joueur j;

	private Controler controler;
	
	/**
	 * @param dim : La classe Dimension encapsule la largeur et la hauteur d'un composant (en précision d'entier) dans un seul objet.
	 */
	public GameView(Dimension dim, Observable mod){
		super(dim);
		this.controler = new Controler(mod);
		creerJoueur();
		init();
		
	}
	
	public void creerJoueur(){
		String nom = "";
		nom = (String)JOptionPane.showInputDialog(null,"Veuillez entrer votre pseudonyme : ","Nouveau joueur !",JOptionPane.QUESTION_MESSAGE);
		j = new Joueur(nom);
		ConsoleView.msgVConsole(j);
	}
	protected void init(){
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		//System.out.println("Size : " + this.dimension.getWidth());
		//Dimension dim = new Dimension((int)(this.dimension.getWidth()/2), (int)this.dimension.getHeight());
		JPanel enTete = new JPanel();
		
		this.imagePendu = new ImagePendu("images/trump.jpg"); 
		this.imagePendu.setPreferredSize(new Dimension(450, 650));
		this.imagePendu.setVerticalAlignment(JLabel.CENTER);
		this.nombreMot = new JLabel();
		this.score = new JLabel(); 

		this.dimension = new Dimension(450, 600); 
		rightPanel.setPreferredSize(this.dimension);
		rightPanel.add(this.imagePendu, BorderLayout.CENTER);
		rightPanel.setBackground(Color.white);

		leftPanel.setPreferredSize(this.dimension);
		

		Dimension dim = new Dimension(410, 200);
		enTete.setPreferredSize(new Dimension(450, 150));
		
		//this.pseudo.setText("Pseudo : ");
		//this.pseudo.setPreferredSize(new Dimension(300, 20));
		//this.pseudo.setHorizontalAlignment(JLabel.CENTER);
		//this.pseudo.setFont(arial);
		//enTete.add(this.pseudo,BorderLayout.NORTH);
		
		this.nombreMot.setText("Pseudo : / Mots trouvés : 0");
		this.nombreMot.setPreferredSize(new Dimension(300, 20));
		this.nombreMot.setHorizontalAlignment(JLabel.CENTER);
		this.nombreMot.setFont(arial);
		enTete.add(this.nombreMot, BorderLayout.CENTER);

		this.score.setText("Votre score actuel est de 0 point.");
		this.score.setPreferredSize(new Dimension(300, 20));
		this.score.setHorizontalAlignment(JLabel.CENTER);
		this.score.setFont(arial);
		enTete.add(this.score, BorderLayout.SOUTH);
		enTete.setBackground(Color.white);

		this.motSecret = new JLabel("Aucun mot choisi");
		this.motSecret.setPreferredSize(new Dimension(450, 60));
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
		this.nombreMot.setText("Pseudo : " + j.pseudo + " \n Mots trouvés : " +nbreMot);
	}
	public void restart(String word){		
		for(JButton bout : this.bouton)
			bout.setEnabled(true);
		
		this.imagePendu.setImagePath("images/trump.jpg");
		this.motSecret.setText(word);
	}
	public void accueil(){}
	
	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			((JButton)e.getSource()).setEnabled(false);
			controler.control(((JButton)e.getSource()).getText().charAt(0));
		}		
	}
}
