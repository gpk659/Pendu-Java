import static org.junit.Assert.*;

import org.junit.Test;

public class TestJoueur {

	@Test
	public void test() {
		Joueur j1 = new Joueur();
		j1.nom="";
		assertEquals(0, j1.getNom());
		
	}

}
