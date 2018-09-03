package _08CardGame;

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

        String firstPlayerName = bufferedReader.readLine();
        String secondPlayerName = bufferedReader.readLine();

        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);

        CardDeck deck = new CardDeck();
        CardGame cardGame = new CardGame(firstPlayer, secondPlayer);

        while (true) {
            if (secondPlayer.hasFullHand()) {
                System.out.println(cardGame.getWinner());
                return;
            }

            String[] cardArgs = bufferedReader.readLine()
                    .split(" of ");

            Card card;
            try {
                card = new Card(cardArgs[0], cardArgs[1]);
            } catch (IllegalArgumentException iae) {
                System.out.println("No such card exists.");
                continue;
            }

            if (deck.hasCard(card)) {
                deck.removeCard(card);

                if (!firstPlayer.hasFullHand()) {
                    firstPlayer.addCard(card);
                } else if (!secondPlayer.hasFullHand()) {
                    secondPlayer.addCard(card);
                }
            } else {
                System.out.println("Card is not in the deck.");
            }
        }
    }
}