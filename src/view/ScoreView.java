package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScoreView extends ZContainer {

	private Dimension dimension;
	
	String pseudo;
  	int score;
  	    
  	DefaultTableModel model;
	
	public ScoreView(Dimension dim){
		super(dim);
		init();
	}
	
	public void ajoutScore(String name, int points){
		this.pseudo= name;
		this.score = points;
		model.addRow(new Object[]{pseudo, score});
	}
	
	protected void init(){
		JPanel leftContent = new JPanel();
		JPanel rightContent = new JPanel();
		
		
		JPanel head = new JPanel();
		JLabel titre = new JLabel();
		titre.setText("Tableau des scores des différents joueurs");
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(new Font("comics30", Font.BOLD, 20));
		head.add(titre);
		
		this.dimension = new Dimension(400, 600); 
		rightContent.setPreferredSize(this.dimension);
		rightContent.add(new JLabel(new ImageIcon("images/trump.jpg")), BorderLayout.CENTER);
		rightContent.setBackground(Color.white);
		
		
		
		this.dimension = new Dimension(500, 600);
		leftContent.setPreferredSize(this.dimension);
		leftContent.setBackground(Color.white);
		
		head.setPreferredSize(new Dimension(450, 50));
		
		
		
	    //Les données du tableau
		
		  model = new DefaultTableModel();
		    model.addColumn("Pseudo");
		    model.addColumn("Score (points)");
		    JTable table = new JTable(model);
		    
		    //DefaultTableModel model = (DefaultTableModel) table.getModel();
	        ajoutScore("greg", 25);
	        ajoutScore("simon",15);
	        ajoutScore("joueur 5",2);
	        ajoutScore("amine",29);
	        ajoutScore("eric",55);
	        ajoutScore("ephec",35);
	        ajoutScore("yvan dulait",18);
	       

	    table.setFont(new Font("comics30", Font.PLAIN, 15));
	    table.getColumnModel().getColumn(0).setResizable(true);
	    table.setAutoCreateRowSorter(true);
	    //Nous ajoutons notre tableau à notre contentPane dans un scroll
	    //Sinon les titres des colonnes ne s'afficheront pas !
	    
	    leftContent.add(head, BorderLayout.NORTH);
	    leftContent.add(new JScrollPane(table),BorderLayout.CENTER);
	    
	    
	    this.panel.add(leftContent);
	    this.panel.add(rightContent);
	}
}
