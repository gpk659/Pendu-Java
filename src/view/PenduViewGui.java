package view;

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



public class PenduViewGui {
	
	public JFrame fenetre;
	private Fond imageFond;
	
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
	
	
	public PenduViewGui() throws IOException{
		fenetre = new JFrame();
		fenetre.setTitle("Jeu du Pendu");
		fenetre.setSize(1200, 900);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		
		//this.size = new Dimension(this.getWidth(), this.getHeight());
		
		/*JLabel titre = new JLabel("Bienvenue...\nVous voici dans notre jeu du pendu...\n\n\n\n");
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setFont(new Font("comics30", Font.PLAIN, 17));
		
		fenetre.getContentPane().add(titre,BorderLayout.NORTH);
		
		
		JLabel image = new JLabel(new ImageIcon("images/trump.jpg"));
		image.setHorizontalAlignment(SwingConstants.CENTER);
		fenetre.getContentPane().add(image, BorderLayout.CENTER);
		
		
		JTextArea texte = new JTextArea("Un peu de lecture...\n"
										+"Bienvenue sur notre jeu du pendu.\n Vous avez 6 chances pour trouver un mot.\n"
										+"Vous aurez un certain nombre de point en fonction du nombre de fautes que vous avez comises.\n"
										+"Alors vous �tes pr�t ? A vous de jouer !\n"
										+"Cliquer sur 'File' et ensuite sur 'Niew' pour commencer une partie... ENJOY ! :)");
		texte.setFont(new Font("comics30", Font.PLAIN, 20));
		texte.setEditable(false);
		texte.setBackground(Color.white);
		
		
		fenetre.getContentPane().add(texte, BorderLayout.SOUTH);*/
		
		
		//menu avec les boutons 'fichier' & '?'
		menu = new JMenuBar();
		fichier = new JMenu("   File   ");
		menu.add(fichier);
		
		nouveau = new JMenuItem("Niew ");
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                KeyEvent.CTRL_MASK));
		nouveau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				conteneur.removeAll();
				GameView gv = new GameView(size);
				conteneur.add(gv.getPanel(), BorderLayout.CENTER);
				
				fenetre.add(conteneur);
				conteneur.revalidate();
			}
		});
		fichier.add(nouveau);

		
		
		score = new JMenuItem("Score ");
		score.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                KeyEvent.CTRL_MASK));
		fichier.add(score);
		
		quitter = new JMenuItem("Exit ");
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                									  KeyEvent.CTRL_MASK));
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fichier.addSeparator();
		fichier.add(quitter);
		
		help = new JMenu("   Help   ");
		menu.add(help);
		help.setHorizontalAlignment(JMenu.RIGHT);
		
		infos = new JMenuItem("Welcome ");
		help.add(infos);
		infos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(fenetre,
	
						"Un peu de lecture...\n"
								+"Bienvenue sur notre jeu du pendu.\n Vous avez 6 chances pour trouver un mot.\n"
								+"Vous aurez un certain nombre de point en fonction du nombre de fautes que vous avez comises.\n"
								+"Alors vous �tes pr�t ? A vous de jouer !\n"
								+"Cliquer sur 'File' et ensuite sur 'Niew' pour commencer une partie... ENJOY ! :)"
						
						, "Bienvenue...Vous voici dans notre jeu du pendu...", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/trump-icon.jpg"));
			}
		});
		
		
		regles = new JMenuItem("Rules ");
		regles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				  KeyEvent.CTRL_MASK));
		regles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(fenetre,
	
						"Les r�gles : \n\n"+
						"Le pendu est un jeu o� il deviner un mot en trouvant une � une sont les lettres qui le composent en faisant le minimum d'erreurs possible.\n\n"+

						"Le principe est simple : A chaque fois, vous devez proposer une lettre qui vous semble appartenir au mot cherch�.\n\n"+
						"Si le mot que vous cherchez ne contient pas cette lettre, c'est une erreur. Et chaque erreur rajoute un morceau du dessin qui repr�sente un condamn� que l'on va pendre.\n\n"+ 
						"Si le mot contient la lettre, vous devez proposer une nouvelle lettre jusqu'� ce que vous trouviez le mot.\n\n"+

						"Mais attention, vous n'avez droit qu'� un nombre limit� d'erreur. D�s que le dessin est termin�, c'est que vous avez atteint votre maximum d'erreur : vous perdez donc la partie.\n\n"+
						"Si vous trouvez le mot avant que le dessin se termine, vous gagnez la partie.\n\n"+
						
						"		Mot trouv� sans erreur\t\t 100 pts\n		Mot trouv� avec une erreur 50 pts\n" +
						"		Mot trouv� avec deux erreurs\t 35 pts\n		Mot trouv� avec trois erreurs 25 pts\n\t		Mot trouv� avec quatre erreurs 15 pts\n" +
						"		Mot trouv� avec cinq erreurs\t 10 pts\n		Mot trouv� avec six erreurs 5 pts\n\n\n" +
						"Je vous souhaite bien du plaisir !"
						
						, "R�gles du Pendu", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/trump-icon.jpg"));
			}
		});
		help.add(regles);
		
		
		help.addSeparator();
		apropos = new JMenuItem("About ");
		help.add(apropos);
		apropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				  KeyEvent.CTRL_MASK));
		apropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(fenetre,"Projet Java Ephec 2016-2017.\n"
														+" Created by Gr�gory, Simon & Amine.\n"
														+" Licence : Free.","About", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/copyright.png"));	
				}
		});
		
		
		
		/*
		this.conteneur.setPreferredSize(this.size);
		this.conteneur.setBackground(Color.white);
		this.conteneur.add(new AcceuilView(this.size).getPanel());
		fenetre.setContentPane(this.conteneur);*/
		//fenetre.add(conteneur);
		
		fenetre.setJMenuBar(menu);
		//ici toutes les polices 
		fenetre.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		fichier.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		help.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		nouveau.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		score.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		quitter.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		infos.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		regles.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		apropos.setFont(new Font("Arial Unicode MS", Font.PLAIN, 13));
		
		
		
	}
	


	
	
}
