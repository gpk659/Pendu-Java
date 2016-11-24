package model;

import java.util.Scanner;

/**
 * @author Gregory Pyck & Simon Barre 2TL1 G4
 *
 */
public class Partie {

	private int nbJoueur;
	//protected Mot mot;
	protected int joueurActif;
	protected int point[] = {30,20,15,10,5,1,0};
	private Scanner sc = new Scanner(System.in);
	
	
	public void definirJoueurActif(){
		
	}
	
	public Partie() {
		System.out.println("Conbien de joueur ?");
		nbJoueur = sc.nextInt();
		creerJoueur();
	}

	public void creerJoueur(){
		Joueur tabNJ[] = new Joueur[nbJoueur];
		int i=0;
		while (i<nbJoueur){
			tabNJ[i]= new Joueur();
			i++;
		}
	}
	
	public void updateScore(){
		
	}
	
	public void affichScore(){
		
	}
}
