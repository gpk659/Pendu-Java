package model;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestJoueur {

	@Test
	public void testFalse() {
		Joueur j1 = new Joueur();
		j1.nom="Pyck";
		j1.prenom="Grégory";
		j1.motEnCours="Programmation";
		j1.idJoueur= j1.idJoueur+1;
		
		Joueur j2 = new Joueur();
		j2.nom="Ephec";
		j2.prenom="LNN";
		j2.motEnCours="Programmation";
		j2.idJoueur= j1.idJoueur+1;		
		
		assertFalse(j1.equals(j2));
		
	}
	@Test
	public void testTrue(){
		Joueur j1 = new Joueur();
		j1.nom="Ephec";
		j1.prenom="LNN";
		j1.motEnCours="Programmation";
		j1.idJoueur = 1;
		
		Joueur j2 = new Joueur();
		j2.nom="Ephec";
		j2.prenom="LNN";
		j2.motEnCours="Programmation";
		j2.idJoueur = 1;
		assertTrue(j1.equals(j2));
	}

}
