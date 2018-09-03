package _05CardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 12:21 ч.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String rank1 = bufferedReader.readLine();
        String suit1 = bufferedReader.readLine();

        Card card1 = new Card(rank1, suit1);

        String rank2 = bufferedReader.readLine();
        String suit2 = bufferedReader.readLine();

        Card card2 = new Card(rank2, suit2);

        if (card1.compareTo(card2) > 0) {
            System.out.println(card1);
        } else {
            System.out.println(card2);
        }
    }
}