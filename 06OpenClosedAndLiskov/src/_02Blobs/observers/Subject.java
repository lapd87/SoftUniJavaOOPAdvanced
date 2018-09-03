package _02Blobs.observers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 15:37 ч.
 */
public class Subject {

    private List<AbstractObserver> abstractObservers = new ArrayList<>();

    public void attach(AbstractObserver abstractObserver) {
        this.abstractObservers.add(abstractObserver);
    }

    public void notifyAllObservers() {
        for (AbstractObserver abstractObserver : abstractObservers) {
            abstractObserver.update();
        }
    }
}