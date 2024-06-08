package controller;
import java.util.List;
import java.util.Scanner;

import models.Card;
import service.CardService;
import service.DeckService;
import view.CardView;
import view.DeckView;
import view.Menu;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        CardView cardView = new CardView(scanner);
        DeckView deckView = new DeckView(scanner);
        CardService cardService = new CardService();
        DeckService deckService = new DeckService();


        List<Card> cards;

        while (true) {
            int mainOption = menu.displayMainMenu();
            if(mainOption == 0) {
                System.out.println("Program terminated.");
                break;
            }
            switch (mainOption) {
                case 1:
                    int  subOption1;
                    do {
                        subOption1 = cardView.displayCardMenu();
                        cardManage(subOption1, cardService);
                    } while (subOption1 != 0);
                    break;
                case 2:
                    int  subOption2;
                    do {
                        System.out.println("displayDeckMenu");
                        subOption2 = deckView.displayDeckMenu();
                        deckManage(subOption2, deckService);
                    } while (subOption2 != 0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }


    private static void cardManage(int choice, CardService cardService) {
        switch (choice) {
            case 1:
                System.out.println("list all cards");
                break;
            case 2:
                System.out.println("add card");
                break;
            case 3:
                System.out.println("remove card");
                break;
            case 4:
                System.out.println("edit card");
                break;
            case 5:
                System.out.println("search card");
                break;
            case 0:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid action. Please try again.");
        }
    }

    private static void deckManage(int choice, DeckService deckService) {
        switch (choice) {
            case 1:
                System.out.println("add deck");
                break;
            case 2:
                System.out.println("remove deck");
                break;
            case 3:
                System.out.println("list all decks");
                break;
            case 4:
                System.out.println("view a deck");
                break;
            case 5:
                System.out.println("edit a deck");
                break;
            case 0:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid action. Please try again.");
        }
    }
}
