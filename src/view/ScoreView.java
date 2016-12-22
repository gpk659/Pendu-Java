package view;
/**
 * @author Grégory 2TL1 Groupe n°4
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ScoreView extends Container {

	private Dimension dimension;
	String pseudo;
	int score;
	DefaultTableModel model;

	/**
	 * @param dim : La classe Dimension encapsule la largeur et la hauteur d'un composant (en précision d'entier) dans un seul objet.
	 */
	public ScoreView(Dimension dim){
		super(dim);
		init();
	}

	/**
	 * @param name : nom du joueur
	 * @param points : score du joueur selon le nombre de fautes comises
	 */
	public void ajoutScore(String name, Joueur j){
		this.pseudo= name;
		this.score = initPoint(j); 
		model.addRow(new Object[]{pseudo, score});
	}

	protected void init(){
		JPanel leftContent = new JPanel();
		JPanel rightContent = new JPanel();
		JPanel head = new JPanel();
		JLabel titre = new JLabel();
		
		titre.setText("Tableau des scores des différents joueurs");
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(Harlow);
		head.add(titre);

		this.dimension = new Dimension(400, 600); 
		rightContent.setPreferredSize(this.dimension);
		rightContent.add(new JLabel(new ImageIcon("images/trump7.jpg")), BorderLayout.CENTER);
		rightContent.setBackground(Color.white);

		this.dimension = new Dimension(500, 600);
		leftContent.setPreferredSize(this.dimension);
		leftContent.setBackground(Color.white);
		
		head.setPreferredSize(new Dimension(450, 50));

		model = new DefaultTableModel();
		//titres du tableau
		model.addColumn("Pseudo");
		model.addColumn("Score (points)");
		//creation d'un nouveau tableau
		JTable table = new JTable(model);
		//Ajoute des données dans le tableau via la méthode ajoutScore();
		ajoutScore("greg", 25);
		ajoutScore("simon",15);
		ajoutScore("joueurCinq",20);
		ajoutScore("amine",29);
		ajoutScore("eric",55);
		ajoutScore("ephec",35);
		ajoutScore("yvan dulait",18);

		table.setFont(arial);
		table.getColumnModel().getColumn(0).setResizable(true);
		table.setAutoCreateRowSorter(true);
		/*
		 * Nous ajoutons notre tableau dans un JScrollPane
		 * Sinon les titres des colonnes ne s'afficheront pas !
		*/
		leftContent.add(head, BorderLayout.NORTH);
		leftContent.add(new JScrollPane(table),BorderLayout.CENTER);

		this.panel.add(leftContent);
		this.panel.add(rightContent);
	}
}
