package view.admin;

import controller.IOController;
import controller.ViewController;

import java.io.IOException;

public class SystemSettingView extends ViewController {
    //View to guide the user through changing the system configuration process, provide correct inputs and provide feedback.
    /**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void initialize() throws IOException, ClassNotFoundException {
        displayMenu();
    }
/**
     * @throws IOException
     * @throws ClassNotFoundException
     */
    //Transfer the control to the correct view which is designed to guide the user based on user choice
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
