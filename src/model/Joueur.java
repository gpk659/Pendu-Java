/**
 * @author Grégory Pyck, Simon Barré, Amine Nafia 2TL1 G4
 */

package model;

import java.util.Scanner;

public class Joueur {

	public String pseudo;
	//private static int nbJoueur=0; -> longeur du tableau, voir partie...
	private int idJoueur;
	public int [] score;
	public int vie;
	public int etat;
	private String motFinal;
	protected String motEnCours;
	private char [] LettreFausse; 
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * @return : retourne la variable pour pouvoir y accéder
	 */
	
	public String getNom() {
		return pseudo;
	}
	
	private void setNom(String nom) {
		this.pseudo = nom;
	}

	private int getVie() {
		return vie;
	}
	
	private void setVie(int vie) {
		this.vie = vie;
	}
	
	private int getEtat() {
		return etat;
	}
	
	private void setEtat(int etat) {
		this.etat = etat;
	}
	
	private int[] getScore() {
		return score;
	}
	
	private void setScore(int[] score) {
		this.score = score;
	}
	
	public String toString() {
		return "Joueur n° " + idJoueur + "\n" +"Pseudo : " + pseudo + "\n"+"Il y a " + ""  + " joueur(s)."; //existe plus voir explication plus haut ...
	}
	
	/**
	* @param pseudo : nom du joueur
	*/
	
	public Joueur(String pseudo) {
		//super();       inutile
		//nbJoueur++;    existe plus voir explication plus haut ...
		//idJoueur=nbJoueur;
		this.pseudo = pseudo;
		//this.idJoueur = idJoueur;
	}
	
	public Joueur() {
		
	}
	
	//methode equals
	public boolean equals(Object obj){
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Joueur other = (Joueur) obj;
	    if(other.pseudo==null && this.pseudo!=null)
	        return false;
	     if(!other.pseudo.equals(this.pseudo))
	        return false;
	    if(other.idJoueur == 0 && this.idJoueur!=idJoueur)
	        return false;
	    if(other.idJoueur <0 && !(this.idJoueur<idJoueur))
	    	return false;
	    if(!(other.idJoueur == (this.idJoueur)))
	        return false;
	   return true;
	}
}