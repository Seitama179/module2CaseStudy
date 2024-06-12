package repository;

import models.*;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class CardRepository {
    private List<Card> cards;

    public CardRepository() {
        cards = new ArrayList<>();
        loadFromFile("CardData.csv");
    }

    public List<Card> getAllCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean removeCard(String cardId) {
        boolean removed = cards.removeIf(card -> card.getId().equals(cardId));
        if (removed) {
            saveToFile("CardData.csv");
        }
        return removed;
    }

    public void editCard(String id, Card newCard) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getId().equals(id)) {
                cards.set(i, newCard);
                saveToFile("CardData.csv");
                return;
            }
        }

    }

    public Card searchCard(String id) {
        for (Card card : cards) {
            if (card.getId().equals(id)) {
                return card;
            }
        }
        return null;
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String cardName = fields[2].replace("\\=", ",");
                String region = fields[4].replace("\\=", ",");
                String cardText = fields[6].replace("\\=", ",");
                String keyword = fields[7].replace("\\=", ",");
                String type = fields[0];
                Card card = null;
                switch (type) {
                    case "UnitCard":
                        card = new UnitCard(fields[1], cardName, Integer.parseInt(fields[3]), region,
                                Double.parseDouble(fields[5]), cardText, keyword,
                                Integer.parseInt(fields[8]), Integer.parseInt(fields[9]), Boolean.parseBoolean(fields[10]));
                        break;
                    case "SpellCard":
                        card = new SpellCard(fields[1], cardName, Integer.parseInt(fields[3]), region,
                                Double.parseDouble(fields[5]), cardText, keyword,
                                Integer.parseInt(fields[12]));
                        break;
                    case "EquipmentCard":
                        card = new EquipmentCard(fields[1], cardName, Integer.parseInt(fields[3]), region,
                                Double.parseDouble(fields[5]), cardText, keyword,
                                Integer.parseInt(fields[13]), Integer.parseInt(fields[14]));
                        break;
                }
            if (card != null) {
                cards.add(card);
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveSingleCardToFile(Card card, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) { // true to append
            writeCard(writer, card);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("cardType,ID,cardName,cost,region,price,cardText,keyword,power,health,isChampion,speed,bonusPower,bonusHealth");
            writer.newLine();

            for (Card card : cards) {
                writeCard(writer, card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Saved to " + filename);
    }

    private void writeCard(BufferedWriter writer, Card card) throws IOException {
        String cardName = card.getCardName().replace(",", "\\=");
        String region = card.getRegion().replace(",", "\\=");
        String cardText = card.getCardText().replace(",", "\\=");
        String keyword = card.getKeyword().replace(",", "\\=");
        if (card instanceof UnitCard) {
            UnitCard unit = (UnitCard) card;
            writer.write(String.format("UnitCard,%s,%s,%d,%s,%.2f,%s,%s,%d,%d,%b,,,,%n",
                    unit.getId(), cardName, unit.getCost(), region, unit.getPrice(), cardText, keyword, unit.getPower(),
                    unit.getHealth(), unit.isChampion()));
        } else if (card instanceof SpellCard) {
            SpellCard spell = (SpellCard) card;
            writer.write(String.format("SpellCard,%s,%s,%d,%s,%.2f,%s,%s,,,,%d,,,%n",
                    spell.getId(), cardName, spell.getCost(), region, spell.getPrice(), cardText, keyword, spell.getSpeed()));
        } else if (card instanceof EquipmentCard) {
            EquipmentCard equipment = (EquipmentCard) card;
            writer.write(String.format("EquipmentCard,%s,%s,%d,%s,%.2f,%s,%s,,,,,%d,%d%n",
                    equipment.getId(), cardName, equipment.getCost(), region,
                    equipment.getPrice(), cardText, keyword,
                    equipment.getBonusPower(), equipment.getBonusHealth()));
        }
    }
}
