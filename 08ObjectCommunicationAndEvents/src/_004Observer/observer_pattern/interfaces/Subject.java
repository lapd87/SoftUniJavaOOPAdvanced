package _004Observer.observer_pattern.interfaces;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 4.8.2018 г.
 * Time: 19:33 ч.
 */
public interface Subject {
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();

}
