package _08CardGame;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 20:49 ч.
 */
public class CardGame {

    private Player firstPlayer;
    private Player secondPlayer;

    public CardGame(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    private int comparePlayers() {
        return firstPlayer.getBestCard()
                .compareTo(secondPlayer.getBestCard());
    }

    public Player getWinner() {
        if (this.comparePlayers() >= 0) {
            return firstPlayer;
        } else {
            return secondPlayer;
        }
    }
}