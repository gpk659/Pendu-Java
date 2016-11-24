/**
 * 
 * @author Grégory
 * @groupe Groupe n°4
 * @classe 2TL1
 * 
 */

package model;
import static org.junit.Assert.*;

import org.junit.Test;

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
