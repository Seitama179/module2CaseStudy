package service;

import models.Card;
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
        List<String> decks = deckRepository.listDecks();
        for (String deck : decks) {
            System.out.println(deck);
        }
    }

    @Override
    public void displayDeck(Scanner scanner) {
        try {
            System.out.println("Enter deck name to display:");
            String deckName = scanner.next();
            List<Card> cards = deckRepository.displayDeck(deckName);
            for (Card card : cards) {
                System.out.println(card);
            }
        } catch (Exception e) {
            System.out.println("Deck not found!");
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

        List<Card> cardsInDeck = deckRepository.displayDeck(deckName);
        int count = 0;
        for (Card card : cardsInDeck) {
            if (card.getId().equals(cardId)) {
                count += card.getQuantity();
            }
        }

        if (count + cardToAdd.getQuantity() > 3) {
            System.out.println("Cannot add card. Quantity exceeds limit of 3.");
            return;
        }

        deckRepository.addCardToDeck(deckName, cardToAdd);
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
    public void loadFromFile(String filename) {
        deckRepository.loadFromFile(filename);
    }

    @Override
    public void saveToFile(String filename) {
        deckRepository.saveToFile(filename);
    }
}

//    public static void deckManage(int choice) {
//        switch (choice) {
//            case 1:
//                System.out.println("add deck");
//                break;
//            case 2:
//                System.out.println("remove deck");
//                break;
//            case 3:
//                System.out.println("list all decks");
//                break;
//            case 4:
//                System.out.println("view a deck");
//                break;
//            case 5:
//                System.out.println("edit a deck");
//                break;
//            case 0:
//                System.out.println("Returning to main menu...");
//                break;
//            default:
//                System.out.println("Invalid action. Please try again.");
//        }
//    }

