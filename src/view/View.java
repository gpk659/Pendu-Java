package view;

import java.util.Observable;
import java.util.Observer;
import controller.Controller;
import model.Model;


public abstract class View implements Observer {

    protected Controller controller;
    protected Model model;
    

    public View(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
    }

   
    public void addModel(Observable model) {
        model.addObserver(this);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public abstract void show(String msg);
    
    public abstract String getString();
    
}
