package com.kingman.demo1;

import java.util.Enumeration;
import java.util.Vector;

public class CustomerRefactor {
    private String _name;
    private Vector _rentals = new Vector();

    public CustomerRefactor(String _name) {
        this._name = _name;
    }

    public void addRental(RentalRefactor arg){
        _rentals.add(arg);
    }

    public String getName(){
        return _name;
    }

    public String statement(){
        Enumeration rentals  = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()){
            RentalRefactor each = (RentalRefactor) rentals.nextElement();

            //show fingures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each._movie._price.getCharge(each.getDaysRented())) + "\n";
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement(){
        Enumeration rentals  = _rentals.elements();
        String result = "<H1>Rental Record for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()){
            RentalRefactor each = (RentalRefactor) rentals.nextElement();

            //show fingures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each._movie._price.getCharge(each.getDaysRented())) + "</BR>\n";
        }

        //add footer lines
        result += "<P>Amount owed <EM> " + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental You earned <EM>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

    public double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            RentalRefactor each = (RentalRefactor) rentals.nextElement();
            result += each._movie._price.getCharge(each.getDaysRented());
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            RentalRefactor each = (RentalRefactor) rentals.nextElement();
            result += each._movie._price.getFrequentRenterPoints(each.getDaysRented());
        }
        return result;
    }
}
