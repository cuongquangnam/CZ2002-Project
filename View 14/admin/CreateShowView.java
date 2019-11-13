//package view.admin;
//
//import controller.IOController;
//import controller.ViewController;
//import model.Cinema;
//import model.Movie;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class CreateShowView extends ViewController {
//    @Override
//    public void initialize() throws IOException, ClassNotFoundException {
//        displayMenu();
//    }
//
//    private void displayMenu() {
//        try {
//            ArrayList<Movie> movieList = new ArrayList <Movie>();
//            movieList = FileReadWriteController.readMovieList();
//            for(Movie m: movieList)
//            {
//                System.out.println(m.getMovieTitle());
//            }
//            String movieTitle = IOController.readString("Enter the title of the movie to create a show for");
//            for (Movie m: movieList)
//            {
//                if(m.getMovieTitle() == movieTitle)
//                    Movie m_main =m;
//            }
//        } catch (ClassNotFoundException | IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//
//        String cineplex_name = IOController.readString("Enter the Cineplex to create the show in");
//        int cinema_name = IOController.readChoice(1,3);
//
//        Cinema cin = ShowController.whichCinema(cineplex_name, cinema_name);
//
//        System.out.println("HI");
//
//
//
//        String time = IOController.readString("Enter the time of the show ");
//
//        ShowController.createShow(time, cin, m_main, cineplex_name);
//
//
//
//
//    }
//
//}
