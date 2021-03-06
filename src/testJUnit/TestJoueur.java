package testJUnit;
/**
 * @author Gr�gory Pyck, Simon Barr�, Amine Nafia 2TL1 G4
 */
import static org.junit.Assert.*;
import org.junit.Test;
import model.Joueur;

public class TestJoueur {

	@Test
	public void testFalse() {
		Joueur j1 = new Joueur("blabla");
		
		Joueur j2 = new Joueur("Ephec");
		
		assertFalse(j1.equals(j2));
		
	}
	@Test
	public void testTrue(){
		Joueur j1 = new Joueur("Ephec");
		
		Joueur j2 = new Joueur("Ephec");
		
		assertTrue(j1.equals(j2));
	}

}
