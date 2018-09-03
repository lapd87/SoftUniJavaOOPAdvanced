package _01ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.7.2018 г.
 * Time: 16:44 ч.
 */
public class ListyIterator {

    private int index;
    private List<String> elements;

    public ListyIterator() {
    }

    private void setIndex(int index) {
        this.index = index;
    }

    public void create(String... elements) {
        if (elements.length == 0) {
            this.elements = new ArrayList<>();
            setIndex(0);
        } else {
            this.elements = new ArrayList<>(Arrays.asList(elements));
            setIndex(0);
        }
    }

    public List<String> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public boolean move() {
        if (index < getElements().size() - 1) {
            index++;
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        if (!getElements().isEmpty()) {
            System.out.println(getElements().get(index));
        }
    }

    public boolean hasNext() {
        if (index < getElements().size() - 1) {
            return true;
        } else {
            return false;
        }
    }
}