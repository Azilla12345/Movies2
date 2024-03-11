import java.util.ArrayList;

public class Movie {
    private String title;
    private ArrayList<String> cast;
    private String director;
    private String overview;
    private int runtime;
    private double rating;

    public Movie(String title, String cast, String director, String overview, int runtime, double rating) {
        this.title=title;
        this.cast=new ArrayList<String>();
        this.director=director;
        this.overview=overview;
        this.runtime=runtime;
        this.rating=rating;

        String name = "";
        for (int i = 0; i < cast.length(); i++) {
            if (cast.substring(i, i + 1).equals("|")) {
                this.cast.add(name);
                name = "";
            } else {
                name += cast.substring(i,i+1);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public String getDirector() {
        return director;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public String toString() {
        return String.format(
                "Title: %s\nRuntime: %d minutes\nDirected by: %s\nCast: %s\nOverview: %s\nRating: %f\n",
                title, runtime, director, cast, overview, rating
        );
    }
}