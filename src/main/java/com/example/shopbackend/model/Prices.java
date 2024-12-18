package com.example.shopbackend.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Embeddable
public class Prices {

    @Min(value = 1, message = "Price must be higher than 1")
    private int price;
    @Min(value = 1, message = "Price must be higher than 1")
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
