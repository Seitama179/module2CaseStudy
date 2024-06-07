package repository;

import models.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardRepository {

    public List<Card> getAll() {
        List<Card> cards = new ArrayList<>();
        Collections.copy(cards, cards);
        return cards;
    }

}
