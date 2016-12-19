package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

//methode pour afficher une image
public class Fond extends JPanel {
	 
    private Image img;
    private int width;
    private int height;
      
    public Fond(){
        this((Image)null);
    }
      
    public Fond(String path, int width, int height) throws IOException {
        this(new File(path));
        this.width = width;
        this.height = height;
    }
     
    public Fond(File file) throws IOException {
        this(ImageIO.read(file));
    }
     
    public Fond(Image image){
        img = image;
    }
      
    @Override
    public void paintComponent(Graphics g){
        if(img != null) g.drawImage(img, 0, 0, width, height, this);
    }
  
    public void setImagePath(String imagePath) throws IOException {
        this.setImagePath(new File(imagePath));
    }
     
    public void setImagePath(File file) throws IOException {
        this.setImagePath(ImageIO.read(file));
    }
     
    public void setImagePath(Image image){
        img = image;
    }
     
}
