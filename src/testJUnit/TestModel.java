package testJUnit;

/**
 * @author Simon Barre 2TL1 G4
 */

import static org.junit.Assert.*;
import org.junit.Test;

import model.Model;

public class TestModel {

	@Test
	public void testModelTrue() {
		Model p1 = new Model(2, "test");
		Model p2 = new Model(2, "test");
		
		assertTrue(p1.equals(p2));
	}
	
	@Test
	public void testModelFalse() {
		Model p1 = new Model(1, "test");
		Model p2 = new Model(2, "test");
		
		assertFalse(p1.equals(p2));
		
		Model p3 = new Model(1, "test");
		Model p4 = new Model(2, "test2");
		
		assertFalse(p3.equals(p4));
	}

}
