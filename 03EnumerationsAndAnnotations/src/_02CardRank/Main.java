package _02CardRank;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 12:05 ч.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");

        for (CardRank cardRank : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    cardRank.ordinal(),
                    cardRank.name());
        }
    }
}