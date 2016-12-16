package controller;

import view.*;
import model.*;

public class Controller {
	
	private View view;
	private final Model model;
	private boolean isServer;

	public Controller(View view, Model model) {
	    this.view = view;
	    this.model = model;
	}

	public Controller(Model model) {
	    this.model = model;
	}
	
	public void checkWord(Mot mot, char c) {
		while (mot.getNombreErreur() != Model.NBESSAIS && !(mot.getSecretWord().equals(mot.getWord()))) {
			char lettre = c;			
			mot.verifyWord(lettre);
			view.display("vous avez fait " + mot.getNombreErreur() + " erreur(s)");
		}
		if(mot.getSecretWord().equals(mot.getWord())){
			view.display("Bravo vous avez trouve le mot!");
		}
		if (mot.getNombreErreur() == Model.NBESSAIS){
			view.display("GAME OVER");
		}
		view.display("Fin de la partie");
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