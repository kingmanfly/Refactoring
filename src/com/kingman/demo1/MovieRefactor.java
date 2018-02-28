package com.kingman.demo1;

public class MovieRefactor {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    PriceRefactor _price;

    public MovieRefactor(String _title, int _priceCode) {
        this._title = _title;
        setPriceCode(_priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case REGULAR:
                _price = new RegularPriceRefactor();
                break;
            case CHILDRENS:
                _price = new ChildrensPriceRefactor();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePriceRefactor();
                break;
                default:
                    throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

}
