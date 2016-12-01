package model;

import java.util.Scanner;


/**
 * @author Gregory Pyck & Simon Barre 2TL1 G4
 */
public class Partie{

	protected Joueur tabNbJoueur[]; //= new Joueur[1];
	private Mot mot;
	//protected int joueurActif;
	protected int point[] = {30,20,15,10,5,1,0};
	private Scanner sc = new Scanner(System.in);
	
	public void definirJoueurActif(){}
	
	public Partie() {
		System.out.println("Conbien de joueur ?");
		creerJoueur(sc.nextInt());

		this.mot = new Mot();
		
		//verification du mot
		while (mot.getNombreErreur() != Jeu.NBESSAIS && !(mot.getSecretWord().equals(mot.getWord()))) {
			System.out.println("Veuillez entrer une lettre.");
			char lettre = sc.next().charAt(0);			
			this.mot.verifyWord(lettre);
			System.out.println("vous avez fait " + this.mot.getNombreErreur() + " erreur(s)");
		}
		if(mot.getSecretWord().equals(mot.getWord())){
			System.out.println("Bravo vous avez trouvÃ© le mot!");
		}
		if (mot.getNombreErreur() == Jeu.NBESSAIS){
			System.out.println("GAME OVER");
		}
		System.out.println("Fin de la partie");
		}
	
	public Partie(int nbJ, String pseudo) {
		creerJoueur(nbJ, pseudo);
		Mot m1 = new Mot();
	}

	public void creerJoueur(int nbJ){
		tabNbJoueur = new Joueur[nbJ];
		int i=0;
		while (i<nbJ){
			tabNbJoueur[i] = new Joueur();
			i++;
		}
	}
	
	public void creerJoueur(int nbJ, String pseudo){
		tabNbJoueur = new Joueur[nbJ];
		int i=0;
		while (i<nbJ){
			tabNbJoueur[i] = new Joueur(pseudo);
			i++;
		}
	}
	
	
	public void updateScore(){
		
	}
	
	public void affichScore(){
		
	}
	
	//getters & setters
	public Joueur[] getTabNbJoueur() {
		return tabNbJoueur;
	}

	public void setTabNbJoueur(Joueur[] tabNbJoueur) {
		this.tabNbJoueur = tabNbJoueur;
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
		    if (other.tabNbJoueur.length==0 && this.tabNbJoueur.length!=0)
		    	return false;
		    if (other.tabNbJoueur.length != this.tabNbJoueur.length)
		    	return false;
		   return true;
		}
}
