package controller;
import java.util.List;
import models.Card;
import service.CardService;
import service.ICardService;
import view.CardView;

public class MainController {
    public static void main(String[] args) {
        CardView cardView = new CardView();
        ICardService cardService = new CardService();
        List<Card> cards;
        int choice;

        while (true) {
            choice = cardView.viewCardMenu();
            switch (choice) {
                case 1:
                    cards = cardService.getAll();
                    cardView.viewAllCards(cards);
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
}
