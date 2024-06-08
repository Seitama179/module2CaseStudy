package view;

import models.Card;
import models.UnitCard;

import java.util.List;
import java.util.Scanner;

public class CardView {
    private Scanner scanner;

    public CardView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int displayCardMenu() {
        int choice;
        while (true) {
            System.out.println("-------Card Menu-------");
            System.out.println("1. View All Cards");
            System.out.println("2. Add a card");
            System.out.println("3. Remove a card");
            System.out.println("4. Edit a card");
            System.out.println("5. Search card");
            System.out.println("0. Back");
            choice = scanner.nextInt();

            try {
                System.out.println("Enter your choice");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
            }
            return choice;
        }
    }

    public void viewAllCards(List<Card> cards) {
        System.out.println("List of Cards:");
        for(Card card : cards) {
            System.out.println(card.toString());
        }
    }

//    public Card addCard() {
//        System.out.println("Enter Card ID: ");
//        int id = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter Card Name: ");
//        String cardName = scanner.nextLine();
//        System.out.println("Enter Card Cost: ");
//        int cost = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter Card Region: ");
//        String region = scanner.nextLine();
//        System.out.println("Enter Card Price: ");
//        double price = Double.parseDouble(scanner.nextLine());
//        System.out.println("Enter Card Quantity: ");
//        byte quantity = Byte.parseByte(scanner.nextLine());
//        System.out.println("Enter Card Text: ");
//        String text = scanner.nextLine();
//        System.out.println("Enter Card Keyword: ");
//        String keyword = scanner.nextLine();
//
//        int choice = -1;
//        do {
//            try {
//                System.out.println("Select Card Type:");
//                System.out.println("1.Unit");
//                System.out.println("2.Spell");
//                System.out.println("3.Equipment");
//                choice = Integer.parseInt(scanner.nextLine());
//            }
//            catch (NumberFormatException e) {
//                System.out.println("Invalid choice");
//            }
//        } while (choice < 1 || choice > 3);
//        if (choice == 1) {
//            System.out.print("Enter unit power: ");
//            int power = scanner.nextInt();
//            System.out.print("Enter unit health: ");
//            int health = scanner.nextInt();
//            System.out.print("Is it a champion? (true/false): ");
//            boolean isChampion = scanner.nextBoolean();
//            return new UnitCard(id, cardName, cost, region, price, quantity, text, keyword, power, health, isChampion);
//        } else if (choice == 2) {
//            System.out.print("Enter spell speed: ");
//            int speed = Integer.parseInt(scanner.nextLine());
//            return null;
//        } else if (choice == 3) {
//            return null;
//        } else {
//            return null;
//        }
//        }



    }


