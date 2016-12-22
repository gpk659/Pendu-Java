package view;
/**
 * @author Grégory 2TL1 Groupe n°4
 */
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import model.Model;
import observer.Observable;


public class Main {
	
	public static void main(String[] args) throws IOException {
		Observable model = new Model();
		PenduViewGui window = new PenduViewGui(model);
	}
}
