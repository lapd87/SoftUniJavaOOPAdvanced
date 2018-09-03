package _03StackIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 09:57 ч.
 */
public class Stack implements Iterable<Integer> {

    private List<Integer> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public void push(Integer element) {
        this.elements.add(element);
    }

    public void pop() {
        if (elements.isEmpty()) {
            System.out.println("No elements");
        } else {
            elements.remove(elements.size() - 1);
        }
    }

    public List<Integer> getElements() {
        return Collections.unmodifiableList(elements);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Integer> {

        private int counter = elements.size() - 1;

        @Override
        public boolean hasNext() {
            return counter >= 0;
        }

        @Override
        public Integer next() {
            return elements.get(counter--);
        }
    }
}