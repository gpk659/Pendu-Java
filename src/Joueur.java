/**
 * 
 */

/**
 * @author Gr�gory
 *
 */
public class Joueur {

	public String nom;
	public String prenom;
	
	public int vie;
	public int etat;
	
	private String motFinal;
	private String motEnCours;
	
	
	// getters & setters pour y acceder depuis les autres classes
	private String getNom() {
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
	
	

}
