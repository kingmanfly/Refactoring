package com.kingman.demo1;

abstract class PriceRefactor {
    abstract int getPriceCode();
    abstract double getCharge(int _daysRented);

    int getFrequentRenterPoints(int dayRented) {
        // add frequent renter points
        return 1;
    }
}

class ChildrensPriceRefactor extends PriceRefactor{

    @Override
    int getPriceCode() {
        return MovieRefactor.CHILDRENS;
    }

    @Override
    double getCharge(int _daysRented) {
        double result = 1.5;
        if(_daysRented> 3){
            result += (_daysRented - 3) * 1.5;
        }
        return result;
    }
}

class NewReleasePriceRefactor extends PriceRefactor{

    @Override
    int getPriceCode() {
        return MovieRefactor.NEW_RELEASE;
    }

    @Override
    double getCharge(int _daysRented) {
        return  _daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints(int dayRented) {
        return (dayRented > 1) ? 2 : 1;
    }
}

class RegularPriceRefactor extends PriceRefactor{

    @Override
    int getPriceCode() {
        return MovieRefactor.REGULAR;
    }

    @Override
    double getCharge(int _daysRented) {
        double result = 2;
        if(_daysRented > 2){
            result += (_daysRented - 2) * 1.5;
        }
        return result;
    }
}
