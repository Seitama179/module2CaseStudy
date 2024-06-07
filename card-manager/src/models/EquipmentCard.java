package models;

public class EquipmentCard extends Card {
    private int bonusPower;
    private int bonusHealth;
    public EquipmentCard(String id, String cardName, int cost, String region, long price, byte quantity, String cardText, String keyword, int bonusPower, int bonusHealth) {
        super(id, cardName, cost, region, price, quantity, cardText, keyword);
        this.bonusPower = bonusPower;
        this.bonusHealth = bonusHealth;
    }
    public int getBonusPower() {
        return bonusPower;
    }
    public void setBonusPower(int bonusPower) {
        this.bonusPower = bonusPower;
    }

    public int getBonusHealth() {
        return bonusHealth;
    }
    public void setBonusHealth(int bonusHealth) {
        this.bonusHealth = bonusHealth;
    }

    public String toString() {
        return "ID: " + getId() + " is an Equipment card"
                + ", Card Name: " + getCardName()
                + ", Cost: " + getCost()
                + ", Region: " + getRegion()
                + ", Price: " + getPrice()
                + ", Quantity: " + getQuantity()
                + ", Power: " + getBonusPower()
                + ", Health: " + getBonusHealth();
    }
}
