package model;
/**
 * @author Grégory
 */
import java.util.ArrayList;

import javax.swing.ImageIcon;

import observer.Observable;
import observer.Observer;
import view.ConsoleView;
import view.GameView;
import view.PenduViewGui;

public class Model implements Observable {
	
	
	private Score score;
	private Mot mot;
	private ImageIcon image;
	private int nombreMot = 0;
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	private String msgResultat;
	
	
	public Model(){
		this.score = new Score();
		this.mot = new Mot();
		//this.image = new ImageIcon("images/trump.jpg");
		//this.scoreSerializer = new ScoreSerializer();
		
	}
	
	public Mot getMot(){
		return mot;
	}
	
	public void reset(){
		this.mot.initWord();
		this.mot.setNombreErreur(0);
		//this.mot.nombreMot=0;
		this.score= new Score();
	}
	
	
	
	public void verifLettre(char c){
		ConsoleView.msgVConsole("Vous avez cliqué sur la lettre : "+c);
		//PenduViewGui.msgViewGui("Vous avez cliqué sur la lettre : "+c,"click");
if(this.mot.verifyWord(c) != -1){
			
			if(this.mot.isFinished()){
				this.score.initPoint(this.mot.getNombreErreur());
				this.score.setNombreMot(this.score.getNombreMot()+1);

				msgResultat = "Vous avez trouvé le mot " + this.mot.getWord() +
                        " en " +
                        this.mot.getNombreCoup() + " coup" + ((this.mot.getNombreCoup() > 1) ? "s" : "") +
						", avec " + this.mot.getNombreErreur() +
                        " erreur" + ((this.mot.getNombreErreur() > 1) ? "s" : "") + ".\n" +
                        "\tVous marquez donc " +
                        this.score.getPointMarque() + " pts.\n" +
						"\tVotre avez maintenant un total de " +
						this.score.getPoint() + " pts.";
				
				ConsoleView.msgVConsole(msgResultat);
				PenduViewGui.msgViewGui(msgResultat, "Résultats");
				this.mot.initWord();
				this.mot.setNombreErreur(0);
				this.nombreMot++;
				this.restartObserver();
			}
			else
				this.notifyObserver();
		}
		else{
			this.mot.setNombreErreur(this.mot.getNombreErreur()+1);
			this.notifyObserver();
			
			if(this.mot.getNombreErreur() == 7){
				
				msgResultat= "Le mot était :\n\t" +
                        this.mot.getWord();
				ConsoleView.msgVConsole(msgResultat);
				PenduViewGui.msgViewGui(msgResultat, "Vous avez perdu...");
				
			/*	if(this.scoreSerializer.isAccpeted(this.score)){
					String nom = "";
					nom  = (String)JOptionPane.showInputDialog(null,
										"Entrez votre pseudonyme :", "Félicitations",
										JOptionPane.QUESTION_MESSAGE);
					 
					this.score.setNom(nom);
					this.scoreSerializer.serialize();
					this.scoreObserver();
				}
				else{
					JOptionPane.showMessageDialog(null,
				            "Désolé, vous avez perdu…\n" +
				            "\n\n\tVous n'avez malheureusement pas assez de points pour enregistrer votre score.\n" +
				            "Retentez votre chance à l'occasion !",
				            "Vous avez perdu", JOptionPane.NO_OPTION);
					this.accueilObserver();
				}	*/
				this.mot.initWord();
				this.mot.setNombreErreur(0);
			}
			else{
				this.notifyObserver();
			}
		}	
	}
	
	public void verifLettre(char[] c){
		ConsoleView.msgVConsole("Vous avez cliqué sur la lettre : "+c);
		//PenduViewGui.msgViewGui("Vous avez cliqué sur la lettre : "+c,"click");
if(this.mot.verifyWord(c) != -1){
			
			if(this.mot.isFinished()){
				this.score.initPoint(this.mot.getNombreErreur());
				this.score.setNombreMot(this.score.getNombreMot()+1);

				msgResultat = "Vous avez trouvé le mot " + this.mot.getWord() +
                        " en " +
                        this.mot.getNombreCoup() + " coup" + ((this.mot.getNombreCoup() > 1) ? "s" : "") +
						", avec " + this.mot.getNombreErreur() +
                        " erreur" + ((this.mot.getNombreErreur() > 1) ? "s" : "") + ".\n" +
                        "\tVous marquez donc " +
                        this.score.getPointMarque() + " pts.\n" +
						"\tVotre avez maintenant un total de " +
						this.score.getPoint() + " pts.";
				ConsoleView.msgVConsole(msgResultat);
				PenduViewGui.msgViewGui(msgResultat, "Résultats");
				this.mot.initWord();
				this.mot.setNombreErreur(0);
				this.nombreMot++;
				this.restartObserver();
			}
			else
				this.notifyObserver();
		}
		else{
			this.mot.setNombreErreur(this.mot.getNombreErreur()+1);
			this.notifyObserver();
			
			if(this.mot.getNombreErreur() == 7){
				
				msgResultat = "Le mot était :\n\t" +
                        this.mot.getWord();
				ConsoleView.msgVConsole(msgResultat);
				PenduViewGui.msgViewGui(msgResultat, "Vous avez perdu...");
				
			/*	if(this.scoreSerializer.isAccpeted(this.score)){
					String nom = "";
					nom  = (String)JOptionPane.showInputDialog(null,
										"Entrez votre pseudonyme :", "Félicitations",
										JOptionPane.QUESTION_MESSAGE);
					 
					this.score.setNom(nom);
					this.scoreSerializer.serialize();
					this.scoreObserver();
				}
				else{
					JOptionPane.showMessageDialog(null,
				            "Désolé, vous avez perdu…\n" +
				            "\n\n\tVous n'avez malheureusement pas assez de points pour enregistrer votre score.\n" +
				            "Retentez votre chance à l'occasion !",
				            "Vous avez perdu", JOptionPane.NO_OPTION);
					this.accueilObserver();
				}	*/
				this.mot.initWord();
				this.mot.setNombreErreur(0);
			}
			else{
				this.notifyObserver();
			}
		}		
	}
	
	
	
	//methode Observer & Observable
	public void addObserver(Observer obs){
		this.listObserver.add(obs);
		this.notifyObserver();
	}
	
	public void deleteObserver(){
		this.listObserver = new ArrayList<Observer>();
	}
	
	public void notifyObserver(){
		this.image = new ImageIcon("images/t"+ this.mot.getNombreErreur() +".jpg");
		
		for(Observer obs : this.listObserver){
			obs.update(this.mot.getSecretWord(), this.score.getPoint(), "images/t"+ this.mot.getNombreErreur() +".jpg", this.nombreMot);
		}
	}
	
	public void restartObserver(){
		for(Observer obs : this.listObserver){
			obs.restart(this.mot.getSecretWord());
		}
	}
	
	public void accueilObserver(){
		for(Observer obs : this.listObserver){
			obs.accueil();
		}
	}


	
	
	
	
	
	

}
