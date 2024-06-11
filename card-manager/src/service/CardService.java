package service;

import models.*;
import repository.*;

import java.util.List;
import java.util.Scanner;

public class CardService implements ICardService {
    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = new CardRepository();
    }

    @Override
    public void viewAllCards() {
        System.out.println("List of Cards");
        List<Card> cards = cardRepository.getAllCards();
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    @Override
    public void addCard(Scanner scanner) {
        System.out.println("Enter card type (1: UnitCard, 2: SpellCard, 3: EquipmentCard): ");
        int cardType = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter card ID: ");
        String id = scanner.nextLine();
        if (isCardIdExists(id)) {
            System.out.println("Card ID already exists.");
            return;
        }

        System.out.println("Enter card name: ");
        String cardName = scanner.nextLine();
        System.out.println("Enter card cost: ");
        int cost = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter card region: ");
        String region = scanner.nextLine();
        System.out.println("Enter card price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter card quantity: ");
        byte quantity = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Enter card text: ");
        String cardText = scanner.nextLine();
        System.out.println("Enter card keyword: ");
        String keyword = scanner.nextLine();

        Card newCard = null;

        switch (cardType) {
            case 1:
                System.out.println("Enter power: ");
                int power = scanner.nextInt();
                System.out.println("Enter health: ");
                int health = scanner.nextInt();
                System.out.println("Is Champion (true/false): ");
                boolean isChampion = scanner.nextBoolean();
                newCard = new UnitCard(id, cardName, cost, region, price, quantity, cardText, keyword, power, health, isChampion);
                break;
            case 2:
                System.out.println("Enter speed (1: Slow, 2: Fast, 3: Focus, 4: Burst): ");
                int speed = scanner.nextInt();
                newCard = new SpellCard(id, cardName, cost, region, price, quantity, cardText, keyword, speed);
                break;
            case 3:
                System.out.println("Enter bonus power: ");
                int bonusPower = scanner.nextInt();
                System.out.println("Enter bonus health: ");
                int bonusHealth = scanner.nextInt();
                newCard = new EquipmentCard(id, cardName, cost, region, price, quantity, cardText, keyword, bonusPower, bonusHealth);
                break;
            default:
                System.out.println("Invalid card type.");
                return;
        }
        cardRepository.addCard(newCard);
        saveToFile("CardData.csv");
        System.out.println("Card added successfully!");
    }

    @Override
    public boolean removeCard(String cardId) {
        return cardRepository.removeCard(cardId);
    }

    @Override
    public void editCard(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter card ID to edit: ");
        String id = scanner.nextLine();

        Card existingCard = cardRepository.searchCard(id);
        if (existingCard == null) {
            System.out.println("Card not found.");
            return;
        }

        System.out.println("Enter new card name (current: " + existingCard.getCardName() + "): ");
        String cardName = scanner.nextLine();
        System.out.println("Enter new card cost (current: " + existingCard.getCost() + "): ");
        int cost = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new card region (current: " + existingCard.getRegion() + "): ");
        String region = scanner.nextLine();
        System.out.println("Enter new card price (current: " + existingCard.getPrice() + "): ");
        double price = scanner.nextDouble();
        System.out.println("Enter new card quantity (current: " + existingCard.getQuantity() + "): ");
        byte quantity = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Enter new card text (current: " + existingCard.getCardText() + "): ");
        String cardText = scanner.nextLine();
        System.out.println("Enter new card keyword (current: " + existingCard.getKeyword() + "): ");
        String keyword = scanner.nextLine();

        if (existingCard instanceof UnitCard) {
            UnitCard unitCard = (UnitCard) existingCard;
            System.out.println("Enter new power (current: " + unitCard.getPower() + "): ");
            int power = scanner.nextInt();
            System.out.println("Enter new health (current: " + unitCard.getHealth() + "): ");
            int health = scanner.nextInt();
            System.out.println("Is Champion (current: " + unitCard.isChampion() + "): ");
            boolean isChampion = scanner.nextBoolean();
            unitCard.setPower(power);
            unitCard.setHealth(health);
            unitCard.setChampion(isChampion);
        } else if (existingCard instanceof SpellCard) {
            SpellCard spellCard = (SpellCard) existingCard;
            System.out.println("Enter new speed (current: " + spellCard.getSpeed() + ", 1: Slow, 2: Fast, 3: Focus, 4: Burst): ");
            int speed = scanner.nextInt();
            spellCard.setSpeed(speed);
        } else if (existingCard instanceof EquipmentCard) {
            EquipmentCard equipmentCard = (EquipmentCard) existingCard;
            System.out.println("Enter new bonus power (current: " + equipmentCard.getBonusPower() + "): ");
            int bonusPower = scanner.nextInt();
            System.out.println("Enter new bonus health (current: " + equipmentCard.getBonusHealth() + "): ");
            int bonusHealth = scanner.nextInt();
            equipmentCard.setBonusPower(bonusPower);
            equipmentCard.setBonusHealth(bonusHealth);
        }

        existingCard.setCardName(cardName);
        existingCard.setCost(cost);
        existingCard.setRegion(region);
        existingCard.setPrice(price);
        existingCard.setQuantity(quantity);
        existingCard.setCardText(cardText);
        existingCard.setKeyword(keyword);

        cardRepository.editCard(id, existingCard);
        System.out.println("Card edited successfully!");
    }

    @Override
    public void searchCard(Scanner scanner) {
        System.out.println("Enter card ID to search:");
        String id = scanner.next();
        Card card = cardRepository.searchCard(id);
        if (card != null) {
            System.out.println(card);
        } else {
            System.out.println("Card not found.");
        }
    }

    @Override
    public void loadFromFile(String filename) {
        cardRepository.loadFromFile(filename);
    }

    @Override
    public void saveToFile(String filename) {
        cardRepository.saveToFile(filename);
    }

    public boolean isCardIdExists(String cardId) {
        List<Card> allCards = cardRepository.getAllCards();
        for (Card card : allCards) {
            if (card.getId().equals(cardId)) {
                return true;
            }
        }
        return false;
    }
}
