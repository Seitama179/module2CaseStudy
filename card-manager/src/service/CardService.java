package service;

import models.Card;
import repository.CardRepository;
import java.util.List;

public class CardService implements ICardService{

    @Override
    public boolean add(Card card) {
        return false;
    }

    @Override
    public List<Card> getAll() {
        return CardRepository.getAll();
    }
}
