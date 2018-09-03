package _07_1984;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 17:23 ч.
 */
public class BaseSubject implements Subject {

    private String id;
    private String name;
    private List<Observer> observers;

    protected BaseSubject(String id, String name) {
        this.id = id;
        this.name = name;
        this.observers = new ArrayList<>();
    }

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        notifyAllObservers(
                String.format("--%s(ID:%s) changed name(String) from %s to %s",
                        this.getClass().getSimpleName(),
                        this.getId(),
                        this.name,
                        name), "name");

        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers(String log, String observerField) {
        observers.stream()
                .filter(o -> Arrays.stream(o.getWatchedFields())
                        .anyMatch(field -> field.equals(observerField)))
                .forEach(o -> o.update(log));
    }
}