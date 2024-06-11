package controller;

import java.util.Scanner;

import service.CardService;
import service.DeckService;
import view.CardView;
import view.DeckView;
import view.Menu;
import repository.CardRepository;
import repository.DeckRepository;

public class MainController {

    private CardView cardView;
    private DeckView deckView;
    private CardService cardService ;
    private DeckService deckService;
    private Menu menu;

    public MainController() {
        CardRepository cardRepository = new CardRepository();
        DeckRepository deckRepository = new DeckRepository(cardRepository);
        cardService = new CardService(cardRepository);
        deckService = new DeckService(deckRepository, cardRepository);
        cardView = new CardView();
        deckView = new DeckView();
        menu = new Menu();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int mainOption = menu.displayMainMenu(scanner);
            switch (mainOption) {
                case 1:
                    handleCardMenu(scanner);
                    break;
                case 2:
                    handleDeckMenu(scanner);
                    break;
                case 0:
                    System.out.println("Program terminated.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void handleCardMenu(Scanner scanner) {
        while (true) {
            int choice = cardView.displayCardMenu(scanner);
            switch (choice) {
                case 1:
                    cardService.viewAllCards();
                    break;
                case 2:
                    cardService.addCard(scanner);

                    break;
                case 3:
                    String cardId = cardView.getCardId();
                    if (cardService.removeCard(cardId)) {
                        System.out.println("Card removed successfully.");
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case 4:
                    cardService.editCard(scanner);
                    break;
                case 5:
                    cardService.searchCard(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void handleDeckMenu(Scanner scanner) {
        while (true) {
            int choice = deckView.displayDeckMenu(scanner);
            switch (choice) {
                case 1:
                    deckService.createDeck(scanner);
                    break;
                case 2:
                    deckService.removeDeck(scanner);
                    break;
                case 3:
                    deckService.listDecks();
                    break;
                case 4:
                    deckService.displayDeck(scanner);
                    break;
                case 5:
                    handleEditDeckMenu(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void handleEditDeckMenu(Scanner scanner) {
        int choice = deckView.showEditDeckMenu(scanner);
        switch (choice) {
            case 1:
                deckService.addCardToDeck(scanner);
                break;
            case 2:
                deckService.removeCardFromDeck(scanner);
                break;
            case 3:
                deckService.renameDeck(scanner);
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }
}


