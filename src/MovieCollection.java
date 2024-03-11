import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class MovieCollection {
    public void start() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        try {
            File myFile = new File("src//movie_data.csv");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] splitData = data.split(",");
                String title=splitData[0];
                String cast=splitData[1];
                String director=splitData[2];
                String overview=splitData[3];
                int runtime=Integer.parseInt(splitData[4]);
                double rating=Double.parseDouble(splitData[5]);
                Movie movie = new Movie(title, cast, director, overview, runtime, rating);
                movies.add(movie);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("Welcome to the movie collection!");
        String menuOption = "";
        Scanner scan = new Scanner(System.in);
        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scan.nextLine();

            if (menuOption.equals("t")) {
                searchTitles(scan,movies);
            } else if (menuOption.equals("c")) {
                searchCast(scan,movies);
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }


    public void searchCast(Scanner scan, ArrayList<Movie> movies) {
        System.out.println("Enter a person to search for (first or last): ");
        String castName = scan.nextLine();
        ArrayList<String> castNames = new ArrayList<>();
        for (Movie movie : movies) {
            for (int i = 0; i < movie.getCast().size(); i++) {
                String currentName = movie.getCast().get(i);
                if (currentName.contains(castName) && !castNames.contains(currentName)) {
                    castNames.add(currentName);
                }
            }
        }
        for (int j = 1; j < castNames.size(); j++) {
            String temp = castNames.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.compareTo(castNames.get(possibleIndex - 1)) < 0) {
                castNames.set(possibleIndex, castNames.get(possibleIndex - 1));
                possibleIndex--;
            }
            castNames.set(possibleIndex, temp);
        }
        if (castNames.size() == 0) {
            System.out.println("No results match your search.");
        } else {
            for (int i = 0; i < castNames.size(); i++) {
                System.out.println(i + 1 + ". " + castNames.get(i));
            }

            System.out.println("Which would you like to see all the movies for?");
            System.out.println("Enter a number: ");
            String currentName = castNames.get(scan.nextInt() - 1);
            scan.nextLine();
            ArrayList<Movie> moviesWithCast = new ArrayList<>();
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getCast().contains(currentName)) {
                    moviesWithCast.add(movies.get(i));
                }
            }
            for (int j = 1; j < moviesWithCast.size(); j++) {
                Movie temp = moviesWithCast.get(j);
                int possibleIndex = j;
                while (possibleIndex > 0 && temp.getTitle().compareTo(moviesWithCast.get(possibleIndex - 1).getTitle()) < 0) {
                    moviesWithCast.set(possibleIndex, moviesWithCast.get(possibleIndex - 1));
                    possibleIndex--;
                }
                moviesWithCast.set(possibleIndex, temp);
            }
            for (int i = 0; i < moviesWithCast.size(); i++) {
                System.out.println(i + 1 + ". " + moviesWithCast.get(i).getTitle());
            }
            System.out.println("Which movie would you like to learn more about?");
            System.out.println("Enter number: ");
            Movie currentMovie = moviesWithCast.get(scan.nextInt() - 1);
            scan.nextLine();
            System.out.println(currentMovie);
        }
    }

    public void searchTitles(Scanner scan, ArrayList<Movie>movies){
        ArrayList<Movie>matches=new ArrayList<Movie>();
        System.out.print("Enter a title search term: ");
        String term = scan.nextLine();
        for (Movie movie:movies) {
            if (movie.getTitle().toLowerCase().contains(term.toLowerCase())) {
                matches.add(movie);
            }
        }

        for (int j = 1; j < matches.size(); j++) {
            String temp = matches.get(j).getTitle();
            Movie movie = matches.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.compareTo(matches.get(possibleIndex - 1).getTitle()) < 0) {
                matches.set(possibleIndex, matches.get(possibleIndex - 1));
                possibleIndex--;
            }
            matches.set(possibleIndex, movie);
        }
        if(matches.size()==0){
            System.out.println("NO movies sorrryyyy");
        } else {
            int i=1;
            for (Movie movie:matches) {
                System.out.println(i+". "+movie.getTitle());
                i++;
            }
            System.out.print("Pick a movie to learn about: ");
            int movie_number = Integer.parseInt(scan.nextLine());
            System.out.println(matches.get(movie_number));
            System.out.println("Press enter to continue");
            scan.nextLine();
        }
    }

  /*public ArrayList<Movie>searchCasts(Scanner scan, ArrayList<Movie>movies){

  }*/

    public MovieCollection() {
        start();
    }
}