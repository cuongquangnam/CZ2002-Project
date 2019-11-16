import view.*;

import java.io.IOException;


/**
 * This class contains the main method of the program
 */
public class MOBLIMA {
    /**
     * This method is used to run the whole program
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new MainView().initialize();
    }

}
