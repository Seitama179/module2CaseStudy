package view;

import java.util.Scanner;

public class DeckView {

    public int displayDeckMenu(Scanner scanner){
        System.out.println("-------Deck manager menu------");
        System.out.println("1. Create a Deck");
        System.out.println("2. Remove a Deck");
        System.out.println("3. List of Decks");
        System.out.println("4. Display a Deck");
        System.out.println("5. Edit a Deck");
        System.out.println("0. Back");

        int choice;
        while(true){
            try {
                choice = scanner.nextInt();
                if(choice >= 0 && choice <= 5){
                    break;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return choice;
    }

    public int showEditDeckMenu(Scanner scanner) {
        System.out.println("Edit Deck Menu");
        System.out.println("1. Add card to deck");
        System.out.println("2. Remove card from deck");
        System.out.println("3. Rename deck");
        System.out.println("0. Back");
        return scanner.nextInt();
    }
}
