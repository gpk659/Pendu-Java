package controller;

import view.*;
import model.*;

public class Controller {
	
	private View view;
	private final Model model;
	private model.Mot mot;
	//private boolean isServer;

	public Controller(View view, Model model) {
	    this.view = view;
	    this.model = model;
	    this.mot = new Mot();
	    System.out.println("test");
	    this.view.show("Combien de joueur");
	    System.out.println("test2");
	    this.model.creerJoueur(1);
	   // this.view.show("Combien de joueur");

	}

	public Controller(Model model) {
	    this.model = model;
	}
	
	/*public void addView(View view) {
        this.view = view;
    }*/

	public void checkWord(Mot mot, char c) {
		while (mot.getNombreErreur() != Model.NBESSAIS && !(mot.getSecretWord().equals(mot.getWord()))) {
			char lettre = c;			
			mot.verifyWord(lettre);
			view.show("vous avez fait " + mot.getNombreErreur() + " erreur(s)");
		}
		if(mot.getSecretWord().equals(mot.getWord())){
			view.show("Bravo vous avez trouve le mot!");
		}
		if (mot.getNombreErreur() == Model.NBESSAIS){
			view.show("GAME OVER");
		}
		view.show("Fin de la partie");
	}
	
	/* network
    public void netSendMessage(String msg) {
        connection.sendMessage(msg);
        this.view.update(null, "Message sent !");
    }

    public void netReceiveMessage(String msg) {
        if (msg.contains("send")) {
            this.view.update(null, msg.substring(5));
        }
    }
    */
}