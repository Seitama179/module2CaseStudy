package service;

import models.*;
import repository.DeckRepository;
import repository.CardRepository;
import java.util.List;
import java.util.Scanner;

public class DeckService implements IDeckService {
    private DeckRepository deckRepository;
    private CardRepository cardRepository;


    public DeckService(DeckRepository deckRepository, CardRepository cardRepository) {
        this.deckRepository = deckRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public void createDeck(Scanner scanner) {
        System.out.println("Enter deck name:");
        String deckName = scanner.next();
        deckRepository.createDeck(deckName);
        System.out.println("Deck created!");
    }

    @Override
    public void removeDeck(Scanner scanner) {
        System.out.println("Enter deck name to remove:");
        String deckName = scanner.next();
        deckRepository.removeDeck(deckName);
        System.out.println("Deck removed!");
    }

    @Override
    public void listDecks() {
        System.out.println("List of decks:");
        List<Deck> decks = deckRepository.listDecks();
        for (Deck deck : decks) {
            System.out.println(deck);
        }
    }

    @Override
    public void displayDeck(String deckName) {
        Deck deck = deckRepository.getDeck(deckName);
        if (deck != null) {
            System.out.println(deck);
        } else {
            System.out.println("Deck not found.");
        }
    }

    @Override
    public void addCardToDeck(Scanner scanner) {
        System.out.println("Enter deck name:");
        String deckName = scanner.next();
        System.out.println("Enter card ID to add:");
        String cardId = scanner.next();

        Card cardToAdd = cardRepository.searchCard(cardId);
        if (cardToAdd == null) {
            System.out.println("Card not found.");
            return;
        }

        System.out.println("Enter Card quantity to add:");
        int cardQuantity = Integer.parseInt(scanner.nextLine());
        if (cardQuantity <= 0 || cardQuantity >3) {
            System.out.println("Card quantity must be between 1 and 3!");
            return;
        }

        deckRepository.addCardToDeck(deckName, cardId, cardQuantity);
        saveToFile();
        System.out.println("Card added to deck successfully!");
    }

    @Override
    public void removeCardFromDeck(Scanner scanner) {
        System.out.println("Enter deck name:");
        String deckName = scanner.next();
        System.out.println("Enter card ID to remove:");
        String cardId = scanner.next();
        deckRepository.removeCardFromDeck(deckName, cardId);
    }

    @Override
    public void renameDeck(Scanner scanner) {
        System.out.println("Enter old deck name:");
        String oldName = scanner.next();
        System.out.println("Enter new deck name:");
        String newName = scanner.next();
        deckRepository.renameDeck(oldName, newName);
    }

    @Override
    public void loadFromFile() {
        deckRepository.loadFromFile();
    }

    @Override
    public void saveToFile() {
        deckRepository.saveToFile();
    }
}


