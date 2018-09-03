package _002StreamProgressInfo;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 15:34 ч.
 */
public class Main {
    public static void main(String[] args) {

        Streamable file = new File(1000,50);
        Streamable music = new Music(60,23);

        System.out.println(new StreamProgressInfo(file).calculateCurrentPercent());
        System.out.println(new StreamProgressInfo(music).calculateCurrentPercent());
    }
}