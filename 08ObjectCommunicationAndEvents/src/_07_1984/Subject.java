package _07_1984;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 17:23 ч.
 */
public interface Subject {
    String getId();

    void attach(Observer observer);

    void notifyAllObservers(String log, String observerField);
}
