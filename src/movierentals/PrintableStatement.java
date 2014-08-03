package movierentals;

public class PrintableStatement extends Statement {
    public String print() {
        return printCustomer() + printRentals() + printTotalOwed() + printFrequentRenterPoints();
    }

    private String printCustomer() {
        return String.format("Rent Statement for %s:\n", customerName);
    }

    private String printRentals() {
        String rentalLines = "";
        for (Rental rental : rentals) rentalLines += printRental(rental);
        return rentalLines;
    }

    private String printRental(Rental rental) {
        return String.format("\t%s\t%d\t%.2f\n", rental.getMovieTitle(), rental.getDaysRented(), rental.getAmountOwed());
    }

    private String printTotalOwed() {
        return String.format("Total Owed: %.2f\n", totalOwed);
    }

    private String printFrequentRenterPoints() {
        return String.format("Frequent Renter Points: %d", frequentRenterPoints);
    }
}