import controller.*;
import model.*;
import view.*;


public class Main {

	public static void main(String[] args) {
		System.out.println("test");
		
		Model model = new Model();
		System.out.println("test2");

        Controller consoleController = new Controller(model);
        //Controller guiController = new Controller(model);
        
        ConsoleView console = new ConsoleView(consoleController, model);
        
       	}

}
