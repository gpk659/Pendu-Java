package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AcceuilView extends ZContainer {

	public AcceuilView(Dimension dim){
		super(dim);
		init();
	}
	
	public void init(){
		//JPanel panel = new JPanel();
		JLabel titre = new JLabel("Bienvenue...\nVous voici dans notre jeu du pendu...\n\n\n\n");
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setFont(new Font("comics30", Font.PLAIN, 15));
		
		this.panel.add(titre,BorderLayout.NORTH);
		
		
		//JLabel image = new JLabel(new ImageIcon("images/pendu_.jpg"));
		//image.setHorizontalAlignment(SwingConstants.CENTER);
		//this.panel.add(image, BorderLayout.CENTER);
		
		
		JTextArea texte = new JTextArea("Un peu de lecture...\n"
										+"Bienvenue sur notre jeu du pendu.\n Vous avez 6 chances pour trouver un mot.\n"
										+"Vous aurez un certain nombre de point en fonction du nombre de fautes que vous avez comises.\n"
										+"Alors vous �tes pr�t ? A vous de jouer !\n"
										+"Cliquer sur 'File' et ensuite sur 'Niew' pour commencer une partie... ENJOY ! :)");
		texte.setFont(new Font("comics30", Font.PLAIN, 25));
		texte.setEditable(false);
		texte.setBackground(Color.white);
		
		this.panel.add(texte, BorderLayout.SOUTH);
	}

}
