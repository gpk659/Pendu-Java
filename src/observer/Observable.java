package observer;

import model.Score;

/**
 * @author Grégory Pyck, Simon Barré, Amine Nafia 2TL1 G4
 *
 */
public interface Observable {
	public void addObserver(Observer obs);
	public void notifyObserver();
	public void restartObserver();
	public void deleteObserver();
	public void reset();
}
