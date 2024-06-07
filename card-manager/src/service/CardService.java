package service;

import models.Card;
import repository.CardRepository;
import java.util.List;

public class CardService implements ICardService{
    private CardRepository cardRepository = new CardRepository();

    @Override
    public boolean add(Card card) {
        return false;
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.getAll();
    }
}
