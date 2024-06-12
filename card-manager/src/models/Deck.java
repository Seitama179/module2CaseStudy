package models;


import java.util.HashMap;
import java.util.Map;

public class Deck {
    private String deckName;
    private Map<String, Integer> cards;

    public Deck(String deckName) {
        this.deckName = deckName;
        this.cards = new HashMap<>();
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public Map<String, Integer> getCards() {
        return cards;
    }

    public void setCards(Map<String, Integer> cards) {
        this.cards = cards;
    }

    public void addCard(String cardId, int quantity) {
        cards.put(cardId, cards.getOrDefault(cardId, 0) + quantity);
    }

    public void removeCard(String cardId) {
        cards.remove(cardId);
    }

    @Override
    public String toString() {
        return String.format("Deck{deckName='%s', cards=%s}", deckName, cards);
    }
}