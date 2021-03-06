package _08CardGame;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 12:16 ч.
 */
public class Card implements Comparable<Card> {

    private Enum rank;
    private Enum suit;
    private int power;

    public Card(String rank, String suit) {
        this.rank = Enum.valueOf(CardRank.class, rank);
        this.suit = Enum.valueOf(CardSuit.class, suit);
        this.power = Enum.valueOf(CardRank.class, rank).getPower()
                + Enum.valueOf(CardSuit.class, suit).getPower();
    }

    @Override
    public String toString() {
        return String.format("%s of %s",
                rank, suit);
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(power, o.power);
    }
}