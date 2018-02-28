package com.kingman.demo1;

public class RentalRefactor {
    MovieRefactor _movie;
    private int _daysRented;

    public RentalRefactor(MovieRefactor _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public MovieRefactor getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

}
