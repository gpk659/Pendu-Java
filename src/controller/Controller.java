package controller;

import view.*;
import model.*;

public class Controller {
	
	private View view;
	private final Model model;
	private boolean isServer;

	public Controller(View view, Model model) {
	    this.view = view;
	    this.model = model;
	}

	public Controller(Model model) {
	    this.model = model;
	}
	

	
	/* network
    public void netSendMessage(String msg) {
        connection.sendMessage(msg);
        this.view.update(null, "Message sent !");
    }

    public void netReceiveMessage(String msg) {
        if (msg.contains("send")) {
            this.view.update(null, msg.substring(5));
        }
    }
    */
}