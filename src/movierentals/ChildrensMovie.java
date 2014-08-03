package movierentals;

public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title);
    }

    public double getAmountOwed(int daysRented) {
        double amountOwed = 1.5;
        if (daysRented > 3)
            amountOwed += (daysRented - 3) * 1.5;
        return amountOwed;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}