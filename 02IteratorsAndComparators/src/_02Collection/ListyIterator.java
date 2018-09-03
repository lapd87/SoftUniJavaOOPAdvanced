package _02Collection;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.7.2018 г.
 * Time: 16:44 ч.
 */
public class ListyIterator implements Iterable<String> {

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
        return index < getElements().size() - 1;
    }

    public void printAll() {
        for (String s : this) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyIteratorIterator();
    }

    private class ListyIteratorIterator implements Iterator<String> {

        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < elements.size();
        }

        @Override
        public String next() {
            return elements.get(counter++);
        }
    }
}