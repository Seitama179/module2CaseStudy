package service;
import java.util.Scanner;

public interface IDeckService extends IService{
    void createDeck(Scanner scanner);
    void removeDeck(Scanner scanner);
    void listDecks();
    void displayDeck(Scanner scanner);
    void addCardToDeck(Scanner scanner);
    void removeCardFromDeck(Scanner scanner);
    void renameDeck(Scanner scanner);
}
