package view;

import models.Card;
import java.util.List;
import java.util.Scanner;

public class CardView {
    Scanner scanner = new Scanner(System.in);

    public int cardMenu() {
        System.out.println("-------Card View-------");
        System.out.println("1.View All Cards");
        System.out.println("2.Add a card");
        System.out.println("3.Remove a card");
        System.out.println("4.Edit a card");
        System.out.println("5.Search card");
        System.out.println("0.Exit");
        return Integer.parseInt(scanner.nextLine());
    }
    public void viewAllCards(List<Card> cards) {
        System.out.println("List of Cards");
        for(Card card : cards) {
            System.out.println(card.toString());
        }
    }

}
