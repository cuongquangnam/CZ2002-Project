package view;

public abstract class BaseView {
    /** The {@code View} before this. */
    public BaseView prevView;  // NULL by default

    /** This method is the first method to be called when change View. */
    protected abstract void initialize();

    /** This method is to destroy the current {@code View} by going back to the start of the last {@code View}. */
    protected void deleteView() {
        if (prevView == null) System.exit(1);  // exit when nowhere to return
        else prevView.initialize();
    }

    /**
     * This method is used to change from one {@code View} to another.
     * @param prev the prevView of {@param cur}
     * @param cur the {@code View} to be started
     */
    protected void changeView(BaseView prev, BaseView cur) {
        cur.prevView = prev;
        cur.initialize();
    }

    /**
     * This method is to get the last {@code View} before this.
     * @return the last {@code View}
     */
    protected BaseView getPrevView() {
        return prevView;
    }
}
