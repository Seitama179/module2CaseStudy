package models;

import java.io.Serializable;

public abstract class Card implements Serializable {
    private String id;
    private String cardName;
    private int cost;
    private String region;
    private double price;
    private byte quantity; // 1-3
    private String cardText;
    private String keyword;
    public Card(String id, String cardName, int cost, String region, double price, byte quantity, String cardText, String keyword) {
        this.id = id;
        this.cardName = cardName;
        this.cost = cost;
        this.region = region;
        this.price = price;
        this.quantity = quantity;
        this.cardText = cardText;
        this.keyword = keyword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte getQuantity() {
        return quantity;
    }

    public void setQuantity(byte quantity) {
        this.quantity = quantity;
    }

    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
