package view;

import model.Joueur;

/**
 * 
 * @author Gr�gory
 *
 */
public class ConsoleView {

	
	public static void msgVConsole(String msg){
		System.out.println(msg);
	}
	public static void msgVConsole(Joueur j){
		System.out.println(j);
	}
}
