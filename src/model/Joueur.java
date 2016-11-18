/**
 * 
 * @author Grégory 2TL1
 * @groupe Groupe n°4
 * 
 */

package model;

/**
 * 
 * @class 
 *
 */
public class Joueur {

	private String nom;
	private String prenom;
	private static int nbJoueur=0;
	private int idJoueur;
	public int [] score;
	public int vie;
	public int etat;
	private String motFinal;
	protected String motEnCours;
	
	
	/**
	 * 
	 * @return : retourne la variable pour pouvoir y accéder
	 */
	public String getNom() {
		return nom;
	}
	private void setNom(String nom) {
		this.nom = nom;
	}
	private String getPrenom() {
		return prenom;
	}
	private void setPrenom(String prenom) {
		this.prenom = prenom;
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
	
	@Override
	public String toString() {
		return "Joueur n° " + idJoueur + "\n" +"Nom : " + nom + "\n" +"Prénom : " + prenom + "\n"+"Il y a " + nbJoueur + " joueur(s).";
	}
	
	/**
	 * @param nom : nom du joueur
	 * @param prenom : prenom du joueur
	 * 
	 */
	public Joueur(String nom, String prenom) {
		super();
		nbJoueur++;
		idJoueur=nbJoueur;
		this.nom = nom;
		this.prenom = prenom;
		this.idJoueur = idJoueur;
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
	    if(other.nom==null && this.nom!=null)
	        return false;
	     if(!other.nom.equals(this.nom))
	        return false;
	    if(other.prenom==null && this.prenom!=null)
	        return false;
	   if(!other.prenom.equals(this.prenom))
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