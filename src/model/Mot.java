package model;

/**
 * @author Grégory
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.swing.JOptionPane;

public class Mot{

	private String word = "", secretMot = "";
	private char[] tabChar;
	private int error = 0;
	private int nbreCoup = 0;

	public Mot(){
		initWord();
		//System.out.println(word);
		System.out.println(secretMot);
	}
	public Mot(String mot){
		this.word=mot;
		initWord();
		System.out.println(secretWord);
	}
	
	public void initWord(){
		
		int i = (int)(Math.random() * 14); //14 pour 14 lignes dans le fichier dictionnaire
		while(i > 14){
			 i /= 2;
		}
		
		try {//ouverture du fichier
			LineNumberReader fnr = new LineNumberReader(new FileReader(new File("files/dictionnaire.txt")));
			int carac;
			this.word = "";
			this.secretMot= "";
			while((carac = fnr.read()) != -1){
				if(fnr.getLineNumber() == (i+1))
					break;
				
				else{
					if(fnr.getLineNumber() == i){
						this.word += (char)carac;						
					}
				}
			}
			
			/**
			 * trim() : est utilisé pour supprimer les espaces au début et à la fin du mot
			 * toUpperCase() : convertit tous les caractères de la chaîne en majuscules
			 */
			this.word = this.word.trim().toUpperCase();
			
			for(int j = 0; j < this.word.length(); j++)
			{//	on injecte une * pour chaque caractère en parcourant le mot avec charAt
				this.secretMot += (this.word.charAt(j) != '\'' && this.word.charAt(j) != '-') ? "*" : this.word.charAt(j);
			}
			
			fnr.close();//on ferme l'ouverture du fichier
			this.nbreCoup = 0;
		} catch (FileNotFoundException e) {//gestions des erreurs si l'ouverture du fichier n'est pas réussie
			JOptionPane.showMessageDialog(null, "Erreur de chargement depuis le fichier de mots !", "ERREUR", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erreur de chargement depuis le fichier de mots !", "ERREUR", JOptionPane.ERROR_MESSAGE);
		}
		
		/**
		 * toCharArray : convertit les * en tableau de charactère
		 */
		this.tabChar = this.secretMot.toCharArray();
		this.error = 0;
	}

	
	public void verifyWord(char c){
		
		boolean bok=false;
		
		for(int i = 0; i < this.word.length(); i++){
			
			if(word.toUpperCase().charAt(i) == c){
				this.tabChar[i] = c;
				System.out.println("bonne lettre !!!!!!!");
				bok = true;
			}
		}if(bok==false){
			System.out.println("Mauvaise lettre!!!!!");
			error++;
		}
		
		//++this.nbreCoup;
		this.secretMot = new String(this.tabChar);
		System.out.println("Mot secret = " + this.secretMot);
		//System.out.println("Mot = "+this.word);
		//return (bok == true) ? 1 : -1;
	}
	
	public int verifyWord(char[] tc){
		
		boolean bok = false;
		
		for(char c : tc)
		{
			for(int i = 0; i < this.word.length(); i++){
				
				if(this.word.toUpperCase().charAt(i) == c){
					this.tabChar[i] = c;
					System.out.println("OK !");
					bok = true;
				}
			}
		}	
		++this.nbreCoup;	
		this.secretMot = new String(this.tabChar);
		System.out.println("Mot secret = " + this.secretMot);
		System.out.println("Mot = "+this.word);
		
		return (bok == true) ? 1 : -1;
	}
	
	//methode equals
	public boolean equals(Object obj){
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    Mot other = (Mot) obj;
	    if (other.word == null && this.word != null)
	    	return false;
	    if (other.word != this.word)
	    	return false;
	   return true;
	}
	
	public String getWord() {
		return word;
	}

	public String getSecretWord() {
		return secretMot;
	}
	
	public int getNombreErreur(){
		return this.error;
	}
	
	public void setNombreErreur(int nbre){
		this.error = nbre;
	}

	public int getNombreCoup() {
		return nbreCoup;
	}
}
