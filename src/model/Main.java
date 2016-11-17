package model;

import java.util.Scanner;

/**
 * 
 */

/**
 * @author Grégory
 *
 */
public class Main extends Joueur {

	/**
	 * classe main
	 * notre classe principale
	 * c'est ici que tout ce lancera 
	 *
	 */
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Joueur j1 = new Joueur();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quel est votre nom ? ");
		String strNom = sc.nextLine();
		j1.nom= strNom;
		
		System.out.println("Quel est votre prenom ? ");
		String strPrenom = sc.nextLine();
		j1.nom= strPrenom;
		
		System.out.println("Quel mot voulez vous mettre ? ");
		String strMot = sc.nextLine();
		j1.motEnCours= strMot;
		
		Joueur j2 = new Joueur();
		Scanner scJ2 = new Scanner(System.in);
		
		System.out.println("Quel est votre nom ? ");
		String strNomJ2 = sc.nextLine();
		j2.nom= strNomJ2;
		
		System.out.println("Quel est votre prenom ? ");
		String strPrenomJ2 = sc.nextLine();
		j2.nom= strPrenomJ2;
		
		System.out.println(j1.equals(j2));

	}

}
