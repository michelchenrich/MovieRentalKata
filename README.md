MovieRentals Kata:
Build the same business logic in the VideoStore Refactoring example from Martin Fowler's book.

The requirements are the following:

The system must be able to print a rent statement with the following template:
Rent Statement for <Customer Name>:
<tab><Movie Title><tab><Days Rented><tab><Owed Amount>
<repeat for each rented movie>
Total Owed: <Total Owed>
Frequent Renter Points: <Frequent Renter Points>

Regular movies are charged 2USD for the first two days, and an extra of 1.5USD for every day after the first two.

Children’s movies are charged 1.5USD for the first three days, and an extra of 1.5USD for every day after the first two.

New releases are charged 3USD per rented day.

Each rent gives the customer a frequent renter point, but for each new release rented for longer than one day, the renter receives a bonus point.