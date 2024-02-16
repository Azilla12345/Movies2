public class Movie {
    private double userRating;
    private String cast;
    private String title;
    private String director;
    private String overview;
    private int runtime;
    public Movie (double userRating, String title, String director, String overview, int runtime, String cast) {
        this.userRating = userRating;
        this.title = title;
        this.director = director;
        this.overview = overview;
        this.runtime = runtime;
        this.cast = cast;
    }

    public double getUserRating() {
        return userRating;
    }

    public String getCast () {
        return cast;
    }

    public String getTitle () {
        return title;
    }

    public String getDirector () {
        return director;
    }

    public String getOverview () {
        return overview;
    }

    public int getRuntime() {
        return runtime;
    }

    public 
}
