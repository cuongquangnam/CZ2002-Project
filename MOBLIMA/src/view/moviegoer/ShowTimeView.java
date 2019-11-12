//package view.moviegoer;
//
//import controller.IOController;
//import controller.ViewController;
//import model.Movie;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.Date;
//
//public class ShowTimeView extends ViewController {
//    private Movie movie;
//
//    ShowTimeView(Movie movie) {
//        this.movie = movie;
//    }
//    @Override
//    public void initialize() throws IOException, ClassNotFoundException {
//        displayMenu();
//    }
//
//    private void displayMenu() {
//        Date today = new Date();
//        Date tomorrow = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
//        Date afterTomorrow = new Date(new Date().getTime() + 2* 24 * 60 * 60 * 1000);
//        Date dateChosen;
//
//        if (movie.getShowingStatus() == 2 || movie.getShowingStatus() == 3) {
//            System.out.println("1. " + formatTimeMMdd(today) + " (today)");
//            System.out.println("2. " + formatTimeMMdd(tomorrow) + " (tomorrow)");
//            System.out.println("3. " + formatTimeMMdd(afterTomorrow) + " (after tomorrow)");
//            System.out.println("Please choose a date:");
//            switch (IOController.getChoice(1, 3)) {
//                case 1:
//                    dateChosen = today;
//                    break;
//                case 2:
//                    dateChosen = tomorrow;
//                    break;
//                default:
//                    dateChosen = afterTomorrow;
//                    break;
//            }
//            IOController.printTitle("Showtime on " + formatTimeMMdd(dateChosen));
//
//            ArrayList<Showtime> showtimeList = new ArrayList<>();
//            showtimeList.sort(Comparator.comparing(o -> o.getCinema().getCineplex().toString()));
//
//            if (getMovieShowtime(movie) != null) {
//                for (Showtime s : getMovieShowtime(movie)) {
//                    if (dateEquals(s.getTime(), dateChosen)) showtimeList.add(s);
//                }
//            }
//
//            if (showtimeList.isEmpty()) {
//                printMenu("No showtime on that day.",
//                        "Press ENTER to go back");
//                readString();
//                return;
//            }
//
//            int index = 0;
//            for (Showtime s : showtimeList) {
//                System.out.println(++index + ": " + s);
//            }
//
//            System.out.println("Please choose a showtime (enter 0 to go back):");
//
//            System.out.println();
//            int choice = readChoice(0, showtimeList.size());
//            if (choice == 0) {
//
//                return;
//            }
//
//            Showtime showtime = showtimeList.get(choice - 1);
//            displayShowtimeDetailMenu(showtime);
//        }
//        else {
//            System.out.println("You are not allowed to book this movie");
//        }
//    }
//
//        printHeader("Showtime on " + formatTimeMMdd(dateChosen));
//
//        ArrayList<Showtime> showtimeList = new ArrayList<>();
//        showtimeList.sort(Comparator.comparing(o -> o.getCinema().getCineplex().toString()));
//
//        if (getMovieShowtime(movie) != null) {
//            for (Showtime s : getMovieShowtime(movie)) {
//                if (dateEquals(s.getTime(), dateChosen)) showtimeList.add(s);
//            }
//        }
//
//        if (showtimeList.isEmpty()) {
//            printMenu("No showtime on that day.",
//                    "Press ENTER to go back");
//            readString();
//            destroy();
//            return;
//        }
//
//        int index = 0;
//        for (Showtime s : showtimeList) {
//            System.out.println(++index + ": " + s);
//        }
//
//        System.out.println("Please choose a showtime (enter 0 to go back):");
//
//        System.out.println();
//        int choice = readChoice(0, showtimeList.size());
//        if (choice == 0) {
//            destroy();
//            return;
//        }
//
//        Showtime showtime = showtimeList.get(choice - 1);
//        displayShowtimeDetailMenu(showtime);
//    }
//}
