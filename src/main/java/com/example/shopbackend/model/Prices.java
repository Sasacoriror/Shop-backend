package com.example.shopbackend.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Prices {

    private int price;
    private int blackFridayPrice;

    public Prices(int price, int blackFridayPrice) {
        super();
        this.price = price;
        this.blackFridayPrice = blackFridayPrice;
    }

    public Prices() {

    }

    public int getPrice() {
        return price;
    }

    public int getBlackFridayPrice() {
        return blackFridayPrice;
    }

    @Override
    public String toString() {
        return "Prices{" +
                "price=" + price +
                ", blackFridayPrice=" + blackFridayPrice +
                '}';
    }
}
