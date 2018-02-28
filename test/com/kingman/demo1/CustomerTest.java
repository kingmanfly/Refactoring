package com.kingman.demo1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testStatement() {
        Customer customer = new Customer("zhangsan");
        Movie movie = new Movie("beautiful life", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);

        Assert.assertEquals("Rental Record for zhangsan\n" +
                "\tbeautiful life\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points", customer.statement());

        Customer customer2 = new Customer("lisi");
        Movie movie2 = new Movie("beautiful life2", Movie.CHILDRENS);
        Rental rental2 = new Rental(movie2, 3);
        customer2.addRental(rental2);

        Assert.assertEquals("Rental Record for lisi\n" +
                "\tbeautiful life2\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points",customer2.statement());

        Customer customer3 = new Customer("wangwu");
        Movie movie3 = new Movie("beautiful life3", Movie.REGULAR);
        Rental rental3 = new Rental(movie3, 3);
        customer3.addRental(rental3);
    }
}