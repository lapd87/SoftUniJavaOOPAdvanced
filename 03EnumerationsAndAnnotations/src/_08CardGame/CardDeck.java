package _08CardGame;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 21:02 ч.
 */
public class CardDeck {

    private List<Card> deck;

    public CardDeck() {
        this.deck = new ArrayList<>();
        seedDeck();
    }

    private void seedDeck() {
        List<CardSuit> cardSuit = Arrays.asList(CardSuit.values());
        List<CardRank> cardRank = Arrays.asList(CardRank.values());

        for (int i = 0; i < cardSuit.size(); i++) {
            for (int j = 0; j < cardRank.size(); j++) {
                Card card = new Card(cardRank.get(j).name(),
                        cardSuit.get(i).name());

                deck.add(card);
            }
        }
    }

    public void removeCard(Card card) {
        deck.remove(deck.stream()
                .filter(c -> c.toString()
                        .equals(card.toString()))
                .findFirst()
                .orElse(null));
    }

    public boolean hasCard(Card card) {
        return this.deck
                .stream()
                .anyMatch(c -> c.toString()
                        .equals(card.toString()));
    }
}