package model;

import java.util.Scanner;

/**
 * @author Gregory Pyck & Simon Barre 2TL1 G4
 */
public class Partie {

	private Joueur tabNbJoueur[]; //= new Joueur[1];
	//protected Mot mot;
	//protected int joueurActif;
	protected int point[] = {30,20,15,10,5,1,0};
	private Scanner sc = new Scanner(System.in);
	
	public void definirJoueurActif(){
		
	}
	
	public Partie() {
		System.out.println("Conbien de joueur ?");
		creerJoueur(sc.nextInt());
		// + Creer mot, mais pas encore fini (au 25/11/16)
	}

	public void creerJoueur(int nbJ){
		tabNbJoueur = new Joueur[nbJ];
		int i=0;
		while (i<nbJ){
			tabNbJoueur[i] = new Joueur();
			i++;
		}
	}
	
	public void updateScore(){
		
	}
	
	public void affichScore(){
		
	}
	
	//methode equals
		public boolean equals(Object obj){
		    if (this == obj)
		        return true;
		    if (obj == null)
		        return false;
		    if (getClass() != obj.getClass())
		        return false;
		    Partie other = (Partie) obj;
		    
		   return true;
		}
}
