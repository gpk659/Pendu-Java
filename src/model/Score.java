
package model;

import java.util.*;

/**
 * @author Grégory Pyck, Simon Barré, Amine Nafia 2TL1 G4
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
	  
	  public void initPoint(int nbErreur){
		  switch (nbErreur){

		      case 0:
		          this.point += 40;
		          this.pointMarque = 40;
		          break;
		
		      case 1:
		    	  this.point += 30;
		    	  this.pointMarque = 30;
		          break;
		
		      case 2:
		    	  this.point += 25;
		    	  this.pointMarque = 25;
		          break;
		
		      case 3:
		    	  this.point += 20;
		    	  this.pointMarque = 20;
		          break;
		
		      case 4:
		    	  this.point += 15;
		    	  this.pointMarque = 15;
		          break;
		
		      case 5:
		    	  this.point += 10;
		    	  this.pointMarque = 10;
		          break;
		
		      case 6:
		    	  this.point += 5;
		    	  this.pointMarque = 5;
		          break;
		
		      case 7:
		    	  this.point +=0;
		    	  this.pointMarque = 0;
		      default:
		    	  this.point += 0;

	      }

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
