package view.admin;

import controller.IOController;
import controller.ViewController;

import java.io.IOException;

public class SystemSettingView extends ViewController {
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }

    private void displayMenu() throws IOException, ClassNotFoundException {
        while(true) {
            IOController.printTitle("System setting");
            System.out.println("1. Configure ticket prices of cinemas");
            System.out.println("2. Configure top 5 movie ranking");
            System.out.println("3. Configure holidays");
            System.out.println("4. Return");

            int choice = IOController.getChoice(1, 4);
            switch (choice) {
                case 1:
                    //                configureTicket();
                    break;
                case 2:
                    changeView(this, new Top5SettingView());
                    break;
                case 3:
                    //                configureHolidays();
                    break;
                case 4:
                    return;
            }
        }
    }
}
