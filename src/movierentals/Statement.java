package movierentals;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    protected String customerName;
    protected double totalOwed;
    protected int frequentRenterPoints;
    protected List<Rental> rentals = new ArrayList<>();

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void addRental(Movie movie, int daysRented) {
        Rental rental = new Rental(movie, daysRented);
        totalOwed += rental.getAmountOwed();
        frequentRenterPoints += rental.getFrequentRenterPoints();
        rentals.add(rental);
    }
}