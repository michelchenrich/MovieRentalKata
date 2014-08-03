package movierentals;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MovieRentalsTest {
    private Movie regularMovie;
    private Movie childrensMovie;
    private Movie newRelease;

    private void assertRentalAmountOwed(Movie movie, int daysRented, double amountOwed) {
        assertEquals(amountOwed, new Rental(movie, daysRented).getAmountOwed(), .001);
    }

    private void assertRentalFrequentRentalPoints(Movie movie, int daysRented, int frequentRenterPoints) {
        assertEquals(frequentRenterPoints, new Rental(movie, daysRented).getFrequentRenterPoints());
    }

    @Before
    public void setUp() throws Exception {
        regularMovie = new RegularMovie("Regular");
        childrensMovie = new ChildrensMovie("Childrens");
        newRelease = new NewReleaseMovie("New Release");
    }

    @Test
    public void acceptanceTest() {
        PrintableStatement statement = new PrintableStatement();
        statement.setCustomerName("Customer");
        statement.addRental(regularMovie, 1);
        statement.addRental(regularMovie, 2);
        statement.addRental(regularMovie, 3);
        statement.addRental(regularMovie, 4);
        statement.addRental(newRelease, 1);
        statement.addRental(newRelease, 2);
        statement.addRental(newRelease, 3);
        statement.addRental(childrensMovie, 1);
        statement.addRental(childrensMovie, 2);
        statement.addRental(childrensMovie, 3);
        statement.addRental(childrensMovie, 4);
        statement.addRental(childrensMovie, 5);
        assertEquals(
                "Rent Statement for Customer:\n" +
                        "\tRegular\t1\t2.00\n" +
                        "\tRegular\t2\t2.00\n" +
                        "\tRegular\t3\t3.50\n" +
                        "\tRegular\t4\t5.00\n" +
                        "\tNew Release\t1\t3.00\n" +
                        "\tNew Release\t2\t6.00\n" +
                        "\tNew Release\t3\t9.00\n" +
                        "\tChildrens\t1\t1.50\n" +
                        "\tChildrens\t2\t1.50\n" +
                        "\tChildrens\t3\t1.50\n" +
                        "\tChildrens\t4\t3.00\n" +
                        "\tChildrens\t5\t4.50\n" +
                        "Total Owed: 42.50\n" +
                        "Frequent Renter Points: 14",
                statement.print());
    }

    @Test
    public void regularMoviesAreCharged2ForTheFirstTwoDays() {
        assertRentalAmountOwed(regularMovie, 1, 2.0);
        assertRentalAmountOwed(regularMovie, 2, 2.0);
    }

    @Test
    public void regularMoviesAreChargedAdditional1Dot5EachDayAfterTheFirstTwo() {
        assertRentalAmountOwed(regularMovie, 3, 3.5);
        assertRentalAmountOwed(regularMovie, 4, 5.0);
    }

    @Test
    public void childrensMoviesAreCharged1Dot5ForTheFirstThreeDays() {
        assertRentalAmountOwed(childrensMovie, 1, 1.5);
        assertRentalAmountOwed(childrensMovie, 2, 1.5);
        assertRentalAmountOwed(childrensMovie, 3, 1.5);
    }

    @Test
    public void childrensMoviesAreChargedAdditional1Dot5EachDayAfterTheFirstThree() {
        assertRentalAmountOwed(childrensMovie, 4, 3.0);
        assertRentalAmountOwed(childrensMovie, 5, 4.5);
    }

    @Test
    public void newReleasesAreCharged3EachRentedDay() {
        assertRentalAmountOwed(newRelease, 1, 3.0);
        assertRentalAmountOwed(newRelease, 2, 6.0);
    }

    @Test
    public void regularMoviesAlwaysGiveOneFrequentRenterPoint(){
        assertRentalFrequentRentalPoints(regularMovie, 1, 1);
        assertRentalFrequentRentalPoints(regularMovie, 2, 1);
        assertRentalFrequentRentalPoints(regularMovie, 3, 1);
    }

    @Test
    public void childrensMoviesAlwaysGiveOneFrequentRenterPoint(){
        assertRentalFrequentRentalPoints(childrensMovie, 1, 1);
        assertRentalFrequentRentalPoints(childrensMovie, 2, 1);
        assertRentalFrequentRentalPoints(childrensMovie, 3, 1);
        assertRentalFrequentRentalPoints(childrensMovie, 4, 1);
    }

    @Test
    public void newReleasesGivesOnePointIfRentedForOnlyOneDay(){
        assertRentalFrequentRentalPoints(newRelease, 1, 1);
    }

    @Test
    public void newReleasesGivesTwoPointsIfRentedForMoreThanOneDay(){
        assertRentalFrequentRentalPoints(newRelease, 2, 2);
        assertRentalFrequentRentalPoints(newRelease, 3, 2);
    }
}