package com.example.shopbackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;

@Entity
public class shop {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50, message = "Must be between 2 and 50 letters!")
    private String item;
    private Prices prices;

    /*private int price;
    private int blackFridayPrice;*/

    public shop(Long id, String item, Prices prices) {
        super();
        this.id = id;
        this.item = item;
        this.prices = prices;
    }

    public shop() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Prices getPrices() {
        return prices;
    }

    /*
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBlackFridayPrice() {
        return blackFridayPrice;
    }

    public void setBlackFridayPrice(int blackFridayPrice) {
        this.blackFridayPrice = blackFridayPrice;
    }*/


    @Override
    public String toString() {
        return "shop{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", prices=" + prices +
                '}';
    }
}

