package view;

import java.util.Scanner;

public class CardView {
    private Scanner scanner;

    public CardView() {
        scanner = new Scanner(System.in);
    }

    public int displayCardMenu(Scanner scanner) {
        int choice;
        while(true){
        System.out.println("-------Card Menu-------");
        System.out.println("1. View All Cards");
        System.out.println("2. Add a card");
        System.out.println("3. Remove a card");
        System.out.println("4. Edit a card by id");
        System.out.println("5. Search card by id");
        System.out.println("0. Back");
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

    public String getCardId() {
        System.out.print("Enter the card ID: ");
        return scanner.nextLine();
    }
}


