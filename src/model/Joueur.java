/**
 * @author Grégory 2TL1
 * Groupe n°4
 */

package model;

import java.util.Scanner;
import view.*;

public class Joueur {

	private String pseudo;
	private int idJoueur;
	public int [] score;
	public int vie;
	public int etat;
	private String motFinal;
	protected String motEnCours;
	private char [] LettreFausses; 
	private View view;
	//private Scanner sc = new Scanner(System.in);
	
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
		return "Joueur n° " + idJoueur + "\n" +"Peuso : " + pseudo + "\n"+"Il y a " + " joueur(s)."; 
	}
	
	/**
	* @param pseudo : nom du joueur
	*/
	
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public Joueur() {
		//System.out.println("Quel est votre pseudo ?");
		this.view.show("Quel est votre pseudo ?");
		//String strPseudo = sc.nextLine();
		this.pseudo = view.getString();
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