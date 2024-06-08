package view;


import java.util.Scanner;

public class DeckView {
    private Scanner scanner;

    public DeckView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int displayDeckMenu(){
        System.out.println("-------Deck manager menu------");
        System.out.println("1. Create a Deck");
        System.out.println("2. Remove a Deck");
        System.out.println("3. List of Decks");
        System.out.println("4. Display a Deck");
        System.out.println("5. Edit a Deck");
        System.out.println("0. Back");
        Scanner scanner = new Scanner(System.in);
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
}
