package controler;
/**
 * @author Gr�gory Pyck, Simon Barr�, Amine Nafia 2TL1 G4
 */
import model.Model;
import observer.Observable;

public class Controler {

	private Model model;

	/**
	 * @param mod : on passe le modele en param�tre
	 */
	public Controler(Observable mod){
		this.model = (Model)mod;
	}

	/**
	 * @param c  la lettre qu'on propose pour deviner le mot
	 */
	public void control(char c){
		switch(c){
			case 'E':
				char tabE[] = {'�', '�', '�', '�', c};
				this.model.verifLettre(tabE);
				//model.notifyObserver();
				break;
			case 'C':
				char tabC[] = {'�', c};
				this.model.verifLettre(tabC);
				//model.notifyObserver();
				break;
			case 'A':
				char tabA[] = {'�', '�', '�', c};
				this.model.verifLettre(tabA);
				//model.notifyObserver();
				break;
			case 'I':
				char tabI[] = {'�', '�', c};
				this.model.verifLettre(tabI);
				//model.notifyObserver();
				break;
			case 'O':
				char tabO[] = {'�', '�', c};
				this.model.verifLettre(tabO);
				//model.notifyObserver();
				break;
			case 'U':
				char tabU[] = {'�', '�', c};
				this.model.verifLettre(tabU);
				//model.notifyObserver();
				break;
			default :
				this.model.verifLettre(c);
				//model.notifyObserver();
		}
	}
}
