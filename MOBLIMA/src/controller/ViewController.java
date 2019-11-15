package controller;

import java.io.IOException;

/**
 * This class is used to switch between different views
 */
public abstract class ViewController {
	
	
    /** The {@code View} before this. */
    public ViewController prevView;  // NULL by default

    /** This method is the first method to be called when change View. */
    public abstract void initialize() throws IOException, ClassNotFoundException;

    /** This method deletes the current {@code View} by going back to the start of the last {@code View}. */
    public void deleteView() throws IOException, ClassNotFoundException {
        if (prevView == null) System.exit(1);  // exit when nowhere to return
        else prevView.initialize();
    }

    /**
     * This method is used to change from one {@code View} to another.
     * @param prev The prevView of {@param cur}
     * @param cur The {@code View} to be started
     */
    public void changeView(ViewController prev, ViewController cur) throws IOException, ClassNotFoundException {
        cur.prevView = prev;
        cur.initialize();
    }

    /**
     * This method is to get the last {@code View} before this.
     * @return The last {@code View}
     */
    public ViewController getPrevView() {
        return prevView;
    }
    
    
}