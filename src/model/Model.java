package model;

import java.util.Observable;


public class Model extends Observable {
	
	public final static int NBESSAIS = 6;

	protected Joueur tabNbJoueur[]; 
	protected int points[] = {30,20,15,10,5,1,0};
	
	public void definirJoueurActif(){}
	
	public Model() {
		System.out.println("testm");
	}
		
	
	public Model(int nbJ, String pseudo) {
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
	
	
	public void updateScore(Joueur j){
		//j.LettreFausses.
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
	    Model other = (Model) obj;
	    if (other.tabNbJoueur.length==0 && this.tabNbJoueur.length!=0)
	    	return false;
	    if (other.tabNbJoueur.length != this.tabNbJoueur.length)
	    	return false;
	   return true;
	}
}
