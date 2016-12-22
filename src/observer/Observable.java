package observer;

import model.Score;

/**
 * @author Grégory
 *
 */
public interface Observable {
	public void addObserver(Observer obs);
	public void notifyObserver();
	public void restartObserver();
	//public void scoreObserver();
	public void deleteObserver();
	
	public void reset();
}
