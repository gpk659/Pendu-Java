package view;
/**
 * @author Grégory Pyck, Simon Barré, Amine Nafia 2TL1 G4
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
