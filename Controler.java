package controler;
/**
 * @author Grégory
 */
import model.Model;
import observer.Observable;

public class Controler {

	private Model model;

	/**
	 * @param mod : on passe le modele en paramètre
	 */
	public Controler(Observable mod){
		this.model = (Model)mod;
	}

	/**
	 * @param c  la lettre qu'on propose pour deviner le mot
	 */
	public void control(char c){

		switch(c){
			case 'A':
				char tabA[] = {'À', 'Â', 'Ä', c};
				this.model.verifLettre(tabA);
				break;
			case 'C':
				char tabC[] = {'Ç', c};
				this.model.verifLettre(tabC);
				break;
			case 'E':
				char tabE[] = {'É', 'È', 'Ê', 'Ë', c};
				this.model.verifLettre(tabE);
				break;
			case 'I':
				char tabI[] = {'Î', 'Ï', c};
				this.model.verifLettre(tabI);
				break;
			case 'O':
				char tabO[] = {'Ô', 'Ö', c};
				this.model.verifLettre(tabO);
				break;
			case 'U':
				char tabU[] = {'Û', 'Ü', c};
				this.model.verifLettre(tabU);
				break;
			default :
				this.model.verifLettre(c);
		}
	}
}
