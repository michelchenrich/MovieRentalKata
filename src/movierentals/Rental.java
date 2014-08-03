package movierentals;

public class Rental {
    private final Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getAmountOwed() {
        return movie.getAmountOwed(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}