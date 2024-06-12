package repository;

import models.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeckRepository {
    private static final String FILE_NAME = "DeckData.csv";
    private Map<String, Deck> decks;

    public DeckRepository() {
        decks = new HashMap<>();
        loadFromFile();
    }



    public void createDeck(String deckName) {
        if (!decks.containsKey(deckName)) {
            decks.put(deckName, new Deck(deckName));
            saveToFile();
        } else {
            System.out.println("Deck with this name already exists.");
        }
    }

    public void removeDeck(String deckName) {
        if (decks.remove(deckName) != null) {
            saveToFile();
        } else {
            System.out.println("Deck not found.");
        }
    }

    public List<Deck> listDecks() {
        return new ArrayList<>(decks.values());
    }

    public Deck getDeck(String deckName) {
        return decks.get(deckName);
    }

    public void renameDeck(String oldName, String newName) {
        if (decks.containsKey(oldName) && !decks.containsKey(newName)) {
            Deck deck = decks.remove(oldName);
            deck.setDeckName(newName);
            decks.put(newName, deck);
            saveToFile();
        } else {
            System.out.println("Rename failed. Either deck not found or new name already exists.");
        }
    }

    public void updateDeck(Deck deck) {
        decks.put(deck.getDeckName(), deck);
        saveToFile();
    }

    public void addCardToDeck(String deckName, String cardId, int quantity) {
        if (decks.containsKey(deckName)) {
            decks.get(deckName).addCard(cardId, quantity);
        }
    }

    public void removeCardFromDeck(String deckName, String cardId) {
        Deck deck = decks.get(deckName);
        if (deck != null) {
            deck.removeCard(cardId);
            saveToFile();
            System.out.println("Card removed from deck successfully.");
        } else {
            System.out.println("Deck not found.");
        }

    }

    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length <= 2) continue;
                String deckName = data[0];
                Deck deck = new Deck(deckName);
                if (data.length > 2) {
                    for (int i = 1; i < data.length; i += 2) {
                        String cardId = data[i];
                        int quantity = Integer.parseInt(data[i + 1]);
                        deck.addCard(cardId, quantity);
                    }
                }
                decks.put(deckName, deck);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Deck deck : decks.values()) {
                bw.write(deckToCSVString(deck));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Saved to " + FILE_NAME);
    }

    public String deckToCSVString(Deck deck) {
        StringBuilder sb = new StringBuilder();
        sb.append(deck.getDeckName());
        for (Map.Entry<String, Integer> entry : deck.getCards().entrySet()) {
            sb.append(",").append(entry.getKey()).append(",").append(entry.getValue());
        }
        return sb.toString();
    }
}
