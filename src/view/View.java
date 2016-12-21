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
        model.addObserver(this);
    }
    
    public abstract void show(String msg);
    
    public abstract String getString();
    
}
