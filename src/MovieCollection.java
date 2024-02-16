import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieCollection {
    Scanner myScanner = new Scanner(System.in);
    Movie movie;
    ArrayList<Movie> Movies = new ArrayList<Movie>();
    public MovieCollection() {

    }
    public void start() {
        try {
            File myFile = new File("movies_data.csv");
            Scanner input = new Scanner(myFile);
            while (input.hasNext()) {
                String data = myScanner.nextLine();
                String[] dataSplit = data.split(",");
                String title = dataSplit[0];
                String cast = dataSplit[1];
                String director = dataSplit[2];
                String overview = dataSplit[3];
                int runTime = Integer.parseInt(dataSplit[4]);
                double rating = Double.parseDouble(dataSplit[5]);
                Movie movie = new Movie(rating, title, director, overview, runTime, cast);
                Movies.add(movie);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void getMovies() {
    }

    public void MovieRunner() {
        System.out.println("Welcome to the movie collection!");
        String menuOption = "";

        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = myScanner.nextLine();

            if (menuOption.equals("t")) {
                movie.getTitle();
            } else if (menuOption.equals("c")) {
                movie.getCast();
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
                return;
            } else {
                System.out.println("Invalid choice!");
            }
        }

    }
}
