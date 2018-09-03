package _001JarOfT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 11.7.2018 г.
 * Time: 10:15 ч.
 */
public class Jar<T> {

    private List<T> elements;

    public Jar() {
        elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
    }

    public T remove() {
        if (elements.size() > 0) {
            return elements.get(elements.size() - 1);
        }

        return null;
    }
}