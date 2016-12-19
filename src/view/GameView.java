package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controler.Controler;


public class GameView extends ZContainer {

	private Dimension dimension = new Dimension();
	private int pts = 0;
	private ImageIcon img;
	private String mot;
	private JLabel 	nombreMot, score, motSecret;
	private ImageLabel imageLabel;
	private JButton bouton[];

	private Controler controler;

	public GameView(Dimension dim){
		super(dim);
		init();
	}

	protected void init(){
		
		JPanel leftContent = new JPanel();
		JPanel rightContent = new JPanel();
		//System.out.println("Size : " + this.dimension.getWidth());
		//Dimension dim = new Dimension((int)(this.dimension.getWidth()/2), (int)this.dimension.getHeight());
		
		JPanel head = new JPanel();
		this.imageLabel = new ImageLabel(); 
		this.imageLabel.setPreferredSize(new Dimension(450, 650));
		this.imageLabel.setVerticalAlignment(JLabel.CENTER);
		this.nombreMot = new JLabel();
		this.score = new JLabel(); 
		
		this.dimension = new Dimension(450, 600); 
		rightContent.setPreferredSize(this.dimension);
		rightContent.add(this.imageLabel, BorderLayout.CENTER);
		rightContent.setBackground(Color.white);
		
		leftContent.setPreferredSize(this.dimension);
		
		Dimension dim = new Dimension(410, 300);
		head.setPreferredSize(new Dimension(410, 100));
		
		this.nombreMot.setText("Nombre de mots trouvés : 0");
		this.nombreMot.setPreferredSize(new Dimension(300, 20));
		this.nombreMot.setHorizontalAlignment(JLabel.CENTER);
		this.nombreMot.setFont(arial);
		
		head.add(this.nombreMot, BorderLayout.NORTH);
		
		this.score.setText("Votre score actuel est de 0 point.");
		this.score.setPreferredSize(new Dimension(300, 20));
		this.score.setHorizontalAlignment(JLabel.CENTER);
		this.score.setFont(arial);
		head.add(this.score, BorderLayout.SOUTH);
		head.setBackground(Color.white);
		
		this.motSecret = new JLabel("fffffffffffffffffff");
		this.motSecret.setPreferredSize(new Dimension(400, 60));
		this.motSecret.setForeground(Color.blue);
		this.motSecret.setFont(comics30);
		this.motSecret.setHorizontalAlignment(JLabel.CENTER);
		head.add(this.motSecret);
		
		JPanel body = new JPanel();
		body.setPreferredSize(dim);
		body.setBackground(Color.white);
		char carac[] = {'a', 'b','c', 'd', 'e', 'f',
						'g', 'h', 'i', 'j', 'k', 'l', 
						'm', 'n', 'o', 'p', 'q', 'r', 
						's', 't' ,'u', 'v', 'w', 'x', 
						'y', 'z'};
		
		BoutonListener bl = new BoutonListener();
		Dimension buttonDimension = new Dimension(50,30);
		this.bouton = new JButton[26];
		int i = 0;
		for(char c : carac){
			this.bouton[i] = new JButton(String.valueOf(c).toUpperCase());
			bouton[i].addActionListener(bl);
			bouton[i].setPreferredSize(buttonDimension);
			body.add(bouton[i]);
			i++; 
		}
		
		leftContent.add(head, BorderLayout.NORTH);
		leftContent.add(body, BorderLayout.CENTER);
		leftContent.setBackground(Color.white);
		
		this.panel.add(leftContent);
		this.panel.add(rightContent);
		
	}
	
	//methode pour mettre à jour le mot, l'image et le score
	public void update(String mot, int pts, String path, int nbreMot) {
		this.motSecret.setText(mot);
		this.score.setText("Votre score actuel est de " +pts+" point"+((pts > 1) ? "s" : "")+".");
		this.imageLabel.setImagePath(path);
		this.nombreMot.setText("Nombre de mots trouvés : " +nbreMot);	
		
	}
	
	
	
	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			((JButton)e.getSource()).setEnabled(false);
			//controler.control(((JButton)e.getSource()).getText().charAt(0));
		}		
	}

}
