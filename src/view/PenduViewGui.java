package view;
/**
 * @author Gr�gory Pyck, Simon Barr�, Amine Nafia 2TL1 G4
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import com.sun.scenario.effect.AbstractShadow.ShadowMode;

import model.Model;
import observer.Observable;
import observer.Observer;


public class PenduViewGui implements Observer {

	public JFrame fenetre;
	private JMenuBar menu;
	private JMenu fichier;
	private JMenuItem nouveau;
	private JMenuItem score;
	private JMenuItem quitter;
	private JMenu help;
	private JMenuItem infos;
	private JMenuItem regles;
	private JMenuItem apropos;
	private JPanel conteneur = new JPanel();
	private Dimension size;
	private Observable model;
	protected Font policeMenu = new Font("Times New Roman", Font.PLAIN, 14);

	  
	public PenduViewGui(Observable obs) throws IOException{
		fenetre = new JFrame();
		fenetre.setTitle("Jeu du Pendu");
		fenetre.setSize(1000, 700);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
		fenetre.setResizable(false);

		this.model= obs;
		this.model.addObserver(this);
		
		//menu avec les boutons 'fichier' & 'help'
		menu = new JMenuBar();
		fichier = new JMenu("   File   ");
		menu.add(fichier);

		nouveau = new JMenuItem(" Niew ");
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				KeyEvent.CTRL_MASK));
		nouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conteneur.removeAll();
				GameView gv = new GameView(size, model);
				model.addObserver(gv);
				conteneur.add(gv.getPanel(), BorderLayout.CENTER);
				fenetre.add(conteneur);
				conteneur.revalidate();
				initModel();
			}
		});
		fichier.add(nouveau);

		score = new JMenuItem(" Score ");
		score.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				KeyEvent.CTRL_MASK));
		score.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				conteneur.removeAll();
				ScoreView viewScore = new ScoreView(size);
				conteneur.add(viewScore.getPanel(), BorderLayout.CENTER);
				fenetre.add(conteneur);
				conteneur.revalidate();
				model.reset();
			}
		});
		fichier.add(score);

		quitter = new JMenuItem(" Exit ");
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				KeyEvent.CTRL_MASK));
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				System.exit(0);/*permet d'arreter le programme*/ }
		});
		fichier.addSeparator();//pour afficher une ligne pour s�parer
		fichier.add(quitter);

		help = new JMenu("   Help   ");
		menu.add(help);

		infos = new JMenuItem(" Welcome ");
		help.add(infos);
		infos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				KeyEvent.CTRL_MASK));
		infos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome();
				accueil();
			}
		});

		regles = new JMenuItem(" Rules ");
		regles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				KeyEvent.CTRL_MASK));
		regles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(fenetre,
						"Les r�gles : \n\n"+
						"Le pendu est un jeu o� il faut deviner un mot en trouvant une � une les lettres qui le composent en faisant le minimum d'erreurs possibles.\n\n"+
						"Le principe est simple : A chaque fois, vous devez proposer une lettre qui vous semble appartenir au mot cherch�.\n\n"+
						"Si le mot que vous cherchez ne contient pas cette lettre, c'est une erreur. \nA chaque erreur, le jeu rajoute un morceau du dessin qui repr�sente un condamn� que l'on va pendre.\n\n"+ 
						"Si le mot contient la lettre, vous devez proposer une nouvelle lettre jusqu'� ce que vous trouviez le mot.\n\n"+
						"Mais attention, vous n'avez droit qu'� un nombre limit� d'erreurs. \nD�s que le dessin est termin�, c'est que vous avez atteint votre maximum d'erreur : vous perdez donc la partie.\n\n"+
						"Si vous trouvez le mot avant que le dessin ne se termine, vous gagnez la partie.\n\n"+
						"		Mot trouv� sans erreur\t\t 40 pts\n		Mot trouv� avec une erreur 30 pts\n" +
						"		Mot trouv� avec deux erreurs\t 25 pts\n		Mot trouv� avec trois erreurs 20 pts\n\t		Mot trouv� avec quatre erreurs 15 pts\n" +
						"		Mot trouv� avec cinq erreurs\t 10 pts\n		Mot trouv� avec six erreurs 5 pts\n\n\n" +
						"Je vous souhaite bien du plaisir !"
						, "R�gles du Pendu", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/trump-icon.jpg"));
			}
		});
		help.add(regles);

		help.addSeparator();//pour afficher une ligne pour s�parer
		apropos = new JMenuItem(" About ");
		help.add(apropos);
		apropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				KeyEvent.CTRL_MASK));
		apropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(fenetre,"Projet Java Ephec 2016-2017.\n"
						+" Created by Gr�gory, Simon & Amine.\n"
						,"About", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/copyright.png"));	
			}
		});

		this.conteneur.setPreferredSize(this.size);
		conteneur.setBackground(Color.white);
		this.conteneur.add(new AcceuilView(size).getPanel());
		//fenetre.setContentPane(this.conteneur);
		fenetre.add(conteneur);

		fenetre.setJMenuBar(menu);

		//ici toutes les polices 
		fichier.setFont(policeMenu);
		help.setFont(policeMenu);
		nouveau.setFont(policeMenu);
		score.setFont(policeMenu);
		quitter.setFont(policeMenu);
		infos.setFont(policeMenu);
		regles.setFont(policeMenu);
		apropos.setFont(policeMenu);

		//welcome();
	}

	//m�thode qui se lance au d�marage du jeu
	public void welcome(){
		JOptionPane.showMessageDialog(fenetre,
			"Retour vers l'accueil"
			, "Bienvenue...Vous voici dans notre jeu du pendu...", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/penduVintage.jpg"));
	}
	public static void msgViewGui(String msg, String titre){
		JOptionPane.showMessageDialog(null, msg, titre, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void msgErrorVGui(String msg, String titre){

		JOptionPane.showMessageDialog(null, msg, titre, JOptionPane.ERROR_MESSAGE);
	}
	public static void msgFinPartie(String msg, String titre, String img){
		JOptionPane.showMessageDialog(null,msg
				,titre, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(img));	
	}
 
	
	private void initModel(){
		this.model = new Model();
		this.model.addObserver(this);
	}
	public void update(String mot, int pts, String imgPath, int nbreMot) {}
	public void restart(String word) {}
	
	public void accueil(){
		System.out.println("retour vers l'acceuil");
		conteneur.removeAll();
		conteneur.add(new AcceuilView(size).getPanel());
		conteneur.revalidate();
	}
}
