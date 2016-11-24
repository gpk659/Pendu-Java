package model;

import java.util.Scanner;

/**
 * @author Gregory Pyck & Simon Barre
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
		String tabNJ[] = new String[nbJoueur+1];
		int i=1;
		while (i<=nbJoueur){
			tabNJ[i]= "joueur" + i;
			//Joueur jN = new Joueur();
			i++;
		}
	}
	
	public void updateScore(){
		
	}
	
	public void affichScore(){
		
	}
}
