/**
 * @author Grégory
 */
package model;

import java.io.*;
import javax.swing.JOptionPane;

import view.ConsoleView;
import view.PenduViewGui;

public class Mot{

	private String word = "", secretWord = "";
	private char[] tabChar;
	private int error = 0;
	private int nbreCoup = 0;
	private int i;

	public Mot(){
		initWord();
		//ConsoleView.msgVConsole(word);
		ConsoleView.msgVConsole(secretWord);
		
	}
	public void affichMot(){
		for(int j = 0; j < this.word.length(); j++)
		{//	on injecte une * pour chaque caractère en parcourant le mot avec charAt
			ConsoleView.msgVConsole(word);
		}
	}
	/**
	 * @param mot : mot du dictionaire
	 */
	public Mot(String mot){
		this.word=mot;
		initWord();
		ConsoleView.msgVConsole(secretWord);
	}
	
	public void genererNombre(){
		i = (int)(Math.random() * 14); //14 pour 14 lignes dans le fichier dictionnaire
		while(i > 14){
			 i /= 2;
		}
	}
	public void initWord(){
		genererNombre();
		
		try {//ouverture du fichier
			LineNumberReader fnr = new LineNumberReader(new FileReader(new File("file/dictionnaire.txt")));
			int carac;
			this.word = "";
			this.secretWord= "";
			while((carac = fnr.read()) != -1){
				if(fnr.getLineNumber() == (i+1))
					break;
				
				else{
					if(fnr.getLineNumber() == i){
						this.word += (char)carac;						
					}
				}
			}
			
			/*
			 * trim() : est utilisé pour supprimer les espaces au début et Ã  la fin du mot
			 * toUpperCase() : convertit tous les caractères de la chaine en majuscules
			 */
			this.word = this.word.trim().toUpperCase();
			
			for(int j = 0; j < this.word.length(); j++)
			{//	on injecte une * pour chaque caractère en parcourant le mot avec charAt
				this.secretWord += (this.word.charAt(j) != '\'' && this.word.charAt(j) != '-') ? "*" : this.word.charAt(j);
			}
			
			fnr.close();//on ferme l'ouverture du fichier
			this.nbreCoup = 0;
		} catch (FileNotFoundException e) {//gestions des erreurs si l'ouverture du fichier n'est pas réussie
			PenduViewGui.msgErrorVGui("Erreur de chargement depuis le fichier de mots !", "Error");
			ConsoleView.msgVConsole("Erreur de chargement depuis le fichier de mots !");
		} catch (IOException e) {
			PenduViewGui.msgErrorVGui("Erreur de chargement depuis le fichier de mots !", "Error");
			ConsoleView.msgVConsole("Erreur de chargement depuis le fichier de mots !");
		}
		
		// toCharArray : convertit les * en tableau de charactères
		this.tabChar = this.secretWord.toCharArray();
		this.error = 0;
	}

	/**
	 * 
	 * @param c lettre la lettre qu'on propose pour deviner le mot
	 * @return retourne la valeur de bok, true ou false
	 */
	public int verifyWord(char c){
		
		boolean bok=false;
		
		for(int i = 0; i < this.word.length(); i++){
			if(word.toUpperCase().charAt(i) == c){
				this.tabChar[i] = c;
				ConsoleView.msgVConsole("Vous avez entré une bonne lettre !");
				bok = true;
			}
		}if(bok==false){
			ConsoleView.msgVConsole("Vous avez entré une mauvaise lettre ! Recommencez...");
				error++;
			}
		
		++this.nbreCoup;
		this.secretWord = new String(this.tabChar);
		ConsoleView.msgVConsole("Mot secret = " + this.secretWord);
		//ConsoleView.msgVConsole("Mot = " + this.word);
		return (bok == true) ? 1 : -1;
	}
	
	/**
	 * 
	 * @param tc tableau des caractères qu'on propose pour deviner le mot qui se trouve dans controller
	 * @return retourne la valeur de bok, true ou false
	 */
	public int verifyWord(char[] tc){
		
		boolean bok = false;
		
		for(char c : tc)
		{
			for(int i = 0; i < this.word.length(); i++){
				
				if(this.word.toUpperCase().charAt(i) == c){
					this.tabChar[i] = c;
					ConsoleView.msgVConsole("Bonne lettre !");
					bok = true;
				}
			}
		}	
		++this.nbreCoup;	
		this.secretWord = new String(this.tabChar);
		ConsoleView.msgVConsole("Mot secret = " + this.secretWord);
		ConsoleView.msgVConsole("Mot = "+this.word);
		return (bok == true) ? 1 : -1;
	}
	
	
	public boolean isFinished(){
		for(char c : this.tabChar){
			if(c == '*')
				return false;
		}
		return true;
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
		return secretWord;
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