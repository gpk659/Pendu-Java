package controler;
/**
 * @author Gr�gory
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
			case 'A':
				char tabA[] = {'�', '�', '�', c};
				this.model.verifLettre(tabA);
				break;
			case 'C':
				char tabC[] = {'�', c};
				this.model.verifLettre(tabC);
				break;
			case 'E':
				char tabE[] = {'�', '�', '�', '�', c};
				this.model.verifLettre(tabE);
				break;
			case 'I':
				char tabI[] = {'�', '�', c};
				this.model.verifLettre(tabI);
				break;
			case 'O':
				char tabO[] = {'�', '�', c};
				this.model.verifLettre(tabO);
				break;
			case 'U':
				char tabU[] = {'�', '�', c};
				this.model.verifLettre(tabU);
				break;
			default :
				this.model.verifLettre(c);
		}
	}
}
