package view;

import java.util.Observable;
import java.util.Observer;
import controller.*;
import model.*;
import view.*;


public class ConsoleView extends View implements Observer {

	
	public ConsoleView(Controller controller, Model model) {
        super(controller, model);
    }

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub	
	}
	
	public void display(String msg) {
        System.out.println(msg);
    }
}
