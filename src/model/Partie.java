package model;

import java.util.Scanner;

/**
 * @author Gregory Pyck & Simon Barre
 *
 */
public class Partie {

	private int nbJoueur;
	protected Mot mot;
	protected int joueurActif;
	protected int point[] = {30,20,15,10,5,1,0};
	private Scanner sc = new Scanner(System.in);
	
	
	public void definirJoueurActif(){
		
	}
	
	public Partie() {
		super();
		creerJoueur();
	}

	public void creerJoueur(){
		/*for (int i = 0; i<nbJoueur;){
			i++;
			System.out.println("Quel est votre nom ? ");
			String strNom = sc.nextLine();
			
			System.out.println("Quel est votre prenom ? ");
			String strPrenom = sc.nextLine();
			
			String nomJoueur = "joueur" + i;
			
			Joueur nomJoueur = new Joueur(strNom,strPrenom);
			
		}*/
		
		System.out.println("Quel est votre nom ? ");
		String strNom = sc.nextLine();
		
		System.out.println("Quel est votre prenom ? ");
		String strPrenom = sc.nextLine();
		
		Joueur j1 = new Joueur(strNom,strPrenom);
	}
	
	public void updateScore(){
		
	}
	
	public void affichScore(){
		
	}
}
