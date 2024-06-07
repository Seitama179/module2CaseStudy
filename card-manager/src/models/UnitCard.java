package models;

public class UnitCard extends Card{
    private int power;
    private int health;
    private boolean isChampion;

    public UnitCard(String id, String cardName, int cost, String region,long price, byte quantity, String cardText, String keyword, int power, int health, boolean isChampion) {
        super(id,cardName,cost,region,price,quantity, cardText, keyword);
        this.power = power;
        this.health = health;
        this.isChampion = isChampion;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isChampion() {
        return isChampion;
    }

    public void setChampion(boolean champion) {
        isChampion = champion;
    }

    public String toString(){
        return "ID: " + getId() + " is an Unit card"
                + ", Card Name: " + getCardName()
                + ", Cost: " + getCost()
                + ", Region: " + getRegion()
                + ", Price: " + getPrice()
                + ", Power: " + getPower()
                + ", Health: " + getHealth()
                + ", isChampion: " + isChampion;
    }
}
