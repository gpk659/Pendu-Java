/**
 * 
 */
package observer;

import model.*;
import javax.swing.ImageIcon;
/**
 * @author Gr�gory
 *
 */
public interface Observer {
	public void update(String mot, int pts, String imgPath, int nbreMot);
	public void restart(String word);
	
	public void accueil();
}
