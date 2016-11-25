package model;

/**
 * @author Simon Barre 2TL1 G4
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestPartie {

	@Test
	public void testPartieTrue() {
		Partie p1 = new Partie(2, "test");
		Partie p2 = new Partie(2, "test");
		
		assertTrue(p1.equals(p2));
	}
	
	@Test
	public void testPartieFalse() {
		Partie p1 = new Partie(1, "test");
		Partie p2 = new Partie(2, "test");
		
		assertFalse(p1.equals(p2));
		
		Partie p3 = new Partie(1, "test");
		Partie p4 = new Partie(2, "test2");
		
		assertFalse(p3.equals(p4));
	}

}
