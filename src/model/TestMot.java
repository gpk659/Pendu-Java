package model;
/**
 * @author Grégory & Simon
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestMot {

	@Test
	public void testTrue() {
		Mot mot5 = new Mot("java");
		Mot mot6 = new Mot("java");
		
		assertTrue(mot5.equals(mot6));
	}
	
	@Test
	public void testFalse(){
		Mot mot1 = new Mot("bonjour");
		Mot mot2 = new Mot("ephec");

		assertFalse(mot1.equals(mot2));

	}

}
