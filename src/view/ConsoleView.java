package view;

import model.Joueur;

/**
 * @author Grégory Pyck, Simon Barré, Amine Nafia 2TL1 G4
 */
public class ConsoleView {

	
	public static void msgVConsole(String msg){
		System.out.println(msg);
	}
	public static void msgVConsole(Joueur j){
		System.out.println(j);
	}
}
