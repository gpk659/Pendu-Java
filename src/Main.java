import java.util.Scanner;

/**
 * 
 */

/**
 * @author Grégory
 *
 */
public class Main extends Joueur {

	/**
	 * classe main
	 * notre classe principale
	 * c'est ici que tout ce lancera 
	 *
	 */
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Joueur j1 = new Joueur();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quel est votre nom ? ");
		String strNom = sc.nextLine();
		j1.nom= strNom;
		
		System.out.println("Quel est votre prenom ? ");
		String strPrenom = sc.nextLine();
		j1.nom= strPrenom;
		
		System.out.println("Quel mot voulez vous mettre ? ");
		String strMot = sc.nextLine();
		j1.motEnCours= strMot;
		
		System.out.println(j1);

	}

}
