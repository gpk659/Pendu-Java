/**
 * 
 */
package modèle;

import java.nio.file.Files;

/**
 * @author Amine
 *
 */
public class Mot {

		private Files dico;
		private String motChoisi;
		private int nbLettres;
		private int error = 0;
		
		/*
	     * Constructeurs 
	     */
		
		public Mot(String v, int x) {
			motChoisi = v;
			nbLettres = x;
		}
		
		/*
	     * Getters and Setters 
	     */
		public void choisirMot(Files dico) {
			this.dico = dico;
		}
		public String getMotChoisi() {
			return motChoisi;
		}
		public void setMotChoisi(String motChoisi) {
			this.motChoisi = motChoisi;
		}
		public int getNbLettres() {
			return nbLettres;
			}
		public void setNbLettres(int nbLettres) {
			this.nbLettres = nbLettres;
		}
		

	}
