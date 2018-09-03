package _07DeckOfCards;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 12:21 ч.
 */
public class Main {
    public static void main(String[] args) {

        List<CardSuit> cardSuit = Arrays.asList(CardSuit.values());
        List<CardRank> cardRank = Arrays.asList(CardRank.values());

        for (int i = 0; i < cardSuit.size(); i++) {
            for (int j = 0; j < cardRank.size(); j++) {
                Card card = new Card(cardRank.get(j).name(),
                        cardSuit.get(i).name());

                System.out.println(card);
            }
        }
    }
}