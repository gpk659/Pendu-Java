/**
 * 
 * @author Grégory
 * @groupe Groupe n°4
 * @classe 2TL1
 * 
 */

package model;

import java.util.Scanner;

public class Main extends Joueur {

	/**
	 * classe main
	 * notre classe principale
	 * c'est ici que tout ce lancera 
	 *
	 */
	
	
	public Main(String nom, String prenom) {
		super(nom, prenom);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quel est votre nom ? ");
		String strNom = sc.nextLine();
		
		System.out.println("Quel est votre prenom ? ");
		String strPrenom = sc.nextLine();
		
		System.out.println("Quel mot voulez vous mettre ? ");
		String strMot = sc.nextLine();
		
		Joueur j1 = new Joueur(strNom,strPrenom);
		
		//joueur 2
		Scanner scJ2 = new Scanner(System.in);
		
		System.out.println("Quel est votre nom ? ");
		String strNomJ2 = sc.nextLine();
				
		System.out.println("Quel est votre prenom ? ");
		String strPrenomJ2 = sc.nextLine();
		
		Joueur j2 = new Joueur(strNomJ2,strPrenomJ2);
		
		//tests
		System.out.println(j1.equals(j2));
		System.out.println(j1);
		System.out.println(j2);

	}

}
