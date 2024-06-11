package service;

import java.util.Scanner;

public interface ICardService extends IService{
    void viewAllCards();
    void addCard(Scanner scanner);
    boolean removeCard(String cardId);
    void editCard(Scanner scanner);
    void searchCard(Scanner scanner);
}
