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
            System.out.println("1. Configure top 5 movie ranking");
            System.out.println("2. Configure holidays");
            System.out.println("3. Configure price modifier");
            System.out.println("4. Return");

            int choice = IOController.getChoice(1, 4);
            switch (choice) {
                case 1:
                    changeView(this, new Top5SettingView());
                    break;
                case 2:
                    changeView(this, new HolidaySettingView());
                    break;
                case 3:
                    changeView(this, new PriceModifierView());
                    break;
                case 4:
                    return;
            }
        }
    }
}
