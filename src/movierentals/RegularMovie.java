package movierentals;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    public double getAmountOwed(int daysRented) {
        double amountOwed = 2.0;
        if (daysRented > 2)
            amountOwed += (daysRented - 2) * 1.5;
        return amountOwed;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}