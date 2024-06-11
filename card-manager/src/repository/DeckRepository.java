package repository;

import models.Card;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeckRepository {
    private Map<String, List<Card>> decks;
    private CardRepository cardRepository;

    public DeckRepository(CardRepository cardRepository) {
        this.decks = new HashMap<>();
        this.cardRepository = cardRepository;
    }



    public void createDeck(String deckName) {
        decks.put(deckName, new ArrayList<>());
        saveToFile("DeckData.csv");
    }

    public void removeDeck(String deckName) {
        decks.remove(deckName);
    }

    public List<String> listDecks() {
        return new ArrayList<>(decks.keySet());
    }

    public List<Card> displayDeck(String deckName) {
        return decks.get(deckName);
    }

    public void addCardToDeck(String deckName, Card card) {
        if (decks.containsKey(deckName)) {
            decks.get(deckName).add(card);
        }
    }

    public void removeCardFromDeck(String deckName, String cardId) {
        if (decks.containsKey(deckName)) {
            decks.get(deckName).removeIf(card -> card.getId().equals(cardId));
        }
    }

    public void renameDeck(String oldName, String newName) {
        if (decks.containsKey(oldName)) {
            decks.put(newName, decks.remove(oldName));
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            decks.clear();
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String deckName = fields[0];
                String cardId = fields[1];

                Card card = cardRepository.searchCard(cardId);
                if (!decks.containsKey(deckName)) {
                    decks.put(deckName, new ArrayList<>());
                }
                decks.get(deckName).add(card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("deckName,cardID");
            writer.newLine();

            for (Map.Entry<String, List<Card>> entry : decks.entrySet()) {
                String deckName = entry.getKey();
                for (Card card : entry.getValue()) {
                    writer.write(String.format("%s,%s%n", deckName, card.getId()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Saved to " + filename);
    }
}
