import controller.FileReadWriteController;
import controller.ShowController;
import model.Cinema;
import model.Movie;
import model.Seat;
import model.Show;
import view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static controller.FileReadWriteController.readShowTime;

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

//        ShowController.createCinemaList();
//        HashMap<String, ArrayList<Cinema>> cinemaList = FileReadWriteController.readCinemaList();
//        for(Map.Entry cinema : cinemaList.entrySet()) {
//            System.out.println("Key: "+ cinema.getKey() + " & Value: " + cinema.getValue().toString());
//        }

//        HashMap<Movie, ArrayList<Show>>  movieShowtime = readShowTime();
//        for(Map.Entry movie : movieShowtime.entrySet()) {
//            System.out.println("Key: {"+ movie.getKey() + "} & Value: {" + movie.getValue() + "}");
//        }


//        Seat[][] seats = new Seat[9][17];
//        for (int row = 0; row <= 3; row++) {
//            for (int col = 2; col <= 16; col++) {
//                if (col == 8) continue;
//                seats[row][col] = new Seat(row, col);
//            }
//        }
//
//        for (int row = 4; row <= 7; row++) {
//            for (int col = 0; col <= 16; col++) {
//                if (col == 8) continue;
//                seats[row][col] = new Seat(row, col);
//            }
//        }
//
//        for (int col = 0; col <= 16; col++) {
//            if (col == 8 || col == 9 || col == 10) continue;
//            seats[8][col] = new Seat(8, col);
//        }
//        seats[1][6].isBooked();
//        System.out.println("                    -------Screen------");
//        System.out.println("     1  2  3  4  5  6  7  8     9 10 11 12 13 14 15 16");
//        for (int row = 0; row <= 8; row++) {
//            System.out.print(row + 1 + "   ");
//            for (int col = 0; col <= 16; col++) {
//                if (seats[row][col] == null) System.out.print("   ");
//                else System.out.print(seats[row][col]);
//            }
//            System.out.println();
//        }
//        System.out.println();
    }
}
