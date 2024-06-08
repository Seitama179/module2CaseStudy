package view;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int displayMainMenu() {
        System.out.println("-------Main Menu------");
        System.out.println("1. Card Manage");
        System.out.println("2. Deck Manage");
        System.out.println("0. Exit Program");
        System.out.println("Enter your choice: ");
        return scanner.nextInt();
    }
}
