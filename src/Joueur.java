/**
 * 
 */

/**
 * @author Grégory
 *
 */
public class Joueur {

	public String nom;
	public String prenom;
	public int [] score;
	public int vie;
	public int etat;
	
	private String motFinal;
	protected String motEnCours;
	
	
	// getters & setters pour y acceder depuis les autres classes
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
		return "Joueur [nom=" + nom + ", prenom=" + prenom + ", motEnCours=" + motEnCours + "]";
	}
	
	
	

}
