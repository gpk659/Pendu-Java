/**
 * 
 */
package observer;

import model.*;
import javax.swing.ImageIcon;
/**
 * @author Grégory Pyck, Simon Barré, Amine Nafia 2TL1 G4
 *
 */
public interface Observer {
	public void update(String mot, int pts, String imgPath, int nbreMot);
	public void restart(String word);
	public void accueil();
}
