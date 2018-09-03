package _08CardGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 20:45 ч.
 */
public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (hand.size() <= 5) {
            hand.add(card);
        }
    }

    public Card getBestCard() {
        return this.hand.stream()
                .max(Card::compareTo)
                .orElse(null);
    }

    public boolean hasFullHand() {
        return this.hand.size() >= 5;
    }

    @Override
    public String toString() {
        return String.format("%s wins with %s.",
                name, getBestCard());
    }
}