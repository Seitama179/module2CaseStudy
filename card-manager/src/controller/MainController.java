package controller;
import java.util.List;
import models.Card;
import service.CardService;
import view.CardView;

public static void main(String[] args) {

    List<Card> cards;
    int choice;


    while (true) {
        choice = CardView.cardMenu();
        switch (choice) {
            case 1:
                cards = CardService.getAll();
                CardView.viewAllCards(cards);
                break;
            case 2:
                break;
            case 3:
            case 4:
            case 5:
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

}
