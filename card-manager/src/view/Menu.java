package view;

import java.util.Scanner;

public class Menu {

    public int displayMainMenu(Scanner scanner) {
        System.out.println("-------Main Menu-------");
        System.out.println("1. Card Manage");
        System.out.println("2. Deck Manage");
        System.out.println("0. Exit Program");
        System.out.println("Enter your choice: ");
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid choice. Please try again.");
            scanner.next();
        }
        return choice;
    }
}
