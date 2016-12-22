package testJUnit;
/**
 * @author Grégory Groupe n°4 2TL1
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
