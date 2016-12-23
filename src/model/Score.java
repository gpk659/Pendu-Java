/**
 * 
 */
package model;

import java.util.*;

/**
 * @author Grégory
 *
 */
public class Score {
	
	private String nom;
	  private int point, pointMarque;
	  private int nbreMot;

	  public Score(){
		    nom = new String("........");
		    point = 0;
		    nbreMot = 0;
	  }

	  public Score(String nom, int point, int mot){
		  nom = nom;
		  point = point;
		  nbreMot = mot;
	  }

	  public int getPoint(){
		  return point;
	  }
	  
          public void initPoint(Joueur j){
		j.score[j.score.length+1]= Model.mot.getNombreErreur();
	  }

	  public String getNom(){
		  return nom;
	  }
	  
	  public void setNom(String nom){
		  this.nom = (nom != null) ? nom : "........";
	  }

	  public void setNombreMot(int nbre){
		  this.nbreMot = nbre;
	  }
	  
	  public int getNombreMot(){
		  return this.nbreMot;
	  }
	  
	  public String toString(){
		  return " "+nom+" : "+point+" pts ("+nbreMot+" mot"+((nbreMot > 1) ? "s" : "")+")";	  
	  }

	  public int getPointMarque(){
		  return pointMarque;
	  }

}
