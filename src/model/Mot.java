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
		System.out.println(word);
		System.out.println(secretMot);
	}
	
	public void initWord(){
		
		int i = (int)(Math.random() * 14); //14 pour 14 lignes dans le fichier dictionnaire
		while(i > 14){
			 i /= 2;
		}
		
		try {//ouverture du fichier
			LineNumberReader fnr = new LineNumberReader(new FileReader(new File("file/dictionnaire.txt")));
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
}
