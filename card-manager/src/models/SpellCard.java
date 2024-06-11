package models;

public class SpellCard extends Card{
    private int speed; // 1-4, slow, fast, focus, burst

    public SpellCard(String id, String cardName, int cost, String region,double price, byte quantity, String cardText, String keyword, int speed) {
        super(id, cardName, cost, region, price, quantity, cardText, keyword);
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String toString(){
        return "ID: " + getId() + " is a Spell card"
                + ", Card Name: " + getCardName()
                + ", Cost: " + getCost()
                + ", Region: " + getRegion()
                + ", Price: " + getPrice()
                + ", Quantity: " + getQuantity()
                + ", Speed: " + getSpeed();
    }
}
