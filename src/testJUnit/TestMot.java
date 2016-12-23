package testJUnit;
/**
 * @author Grégory Pyck, Simon Barré, Amine Nafia 2TL1 G4
 */
import static org.junit.Assert.*;
import org.junit.Test;
import model.Mot;

public class TestMot {


	@Test
	public void testTrue() {
		Mot mot5 = new Mot("JAVA");
		Mot mot6 = new Mot("JAVA");
		
		assertTrue(mot5.equals(mot6));
	}
	
	@Test
	public void testFalse(){
		Mot mot1 = new Mot("bonjour");
		Mot mot2 = new Mot("ephec");

		assertFalse(mot1.equals(mot2));

	}
}
