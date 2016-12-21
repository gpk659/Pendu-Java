package view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import controller.*;
import model.*;


public class ConsoleView extends View implements Observer {
	
	private Scanner sc = new Scanner(System.in);
	
	public ConsoleView(Controller controller, Model model) {
        super(controller, model);
    }

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub	
	}
	
	public void show(String msg) {
        System.out.println(msg);
    }
	
	public String getString() {
		return sc.nextLine();
	}
	
	public int begining() {
		System.out.println("Combien de joueur");
		return sc.nextInt();
	}
	
	
}
