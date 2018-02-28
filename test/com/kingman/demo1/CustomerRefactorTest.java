package com.kingman.demo1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerRefactorTest {

    @Test
    public void testStatement() {
        CustomerRefactor customer = new CustomerRefactor("zhangsan");
        MovieRefactor movie = new MovieRefactor("beautiful life", MovieRefactor.NEW_RELEASE);
        RentalRefactor rental = new RentalRefactor(movie, 3);
        customer.addRental(rental);

        Assert.assertEquals("Rental Record for zhangsan\n" +
                "\tbeautiful life\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points", customer.statement());

        CustomerRefactor customer2 = new CustomerRefactor("lisi");
        MovieRefactor movie2 = new MovieRefactor("beautiful life2", MovieRefactor.CHILDRENS);
        RentalRefactor rental2 = new RentalRefactor(movie2, 3);
        customer2.addRental(rental2);

        Assert.assertEquals("Rental Record for lisi\n" +
                "\tbeautiful life2\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points",customer2.statement());

        CustomerRefactor customer3 = new CustomerRefactor("wangwu");
        MovieRefactor movie3 = new MovieRefactor("beautiful life3", MovieRefactor.REGULAR);
        RentalRefactor rental3 = new RentalRefactor(movie3, 3);
        customer3.addRental(rental3);

        Assert.assertEquals("Rental Record for wangwu\n" +
                "\tbeautiful life3\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points",customer3.statement());
    }
}