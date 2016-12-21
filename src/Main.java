import controller.*;
import model.*;
import view.*;

public class Main {

	public static void main(String[] args) {
		
		Model model = new Model();

        Controller consoleController = new Controller(model);
        //Controller guiController = new Controller(model);
        
        ConsoleView console = new ConsoleView(consoleController, model);
        
       	}

}
