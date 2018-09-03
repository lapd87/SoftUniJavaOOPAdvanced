package _04CardToString;

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

        String rank = bufferedReader.readLine();
        String suit = bufferedReader.readLine();

        Card card = new Card(rank,suit);

        System.out.println(card);
    }
}