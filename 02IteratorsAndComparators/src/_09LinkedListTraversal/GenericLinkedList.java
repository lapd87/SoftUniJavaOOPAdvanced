package _09LinkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 19:46 ч.
 */
public class GenericLinkedList<T> implements Iterable<T> {

    private List<T> elements;

    public GenericLinkedList() {
        elements = new ArrayList<>();
    }

    public void add(T t) {
        elements.add(t);
    }

    public boolean remove(T t) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).toString()
                    .equals(t.toString())) {
                elements.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return elements.size();
    }


    @Override
    public Iterator<T> iterator() {
        return new GenericLinkedListIterator();
    }

    private class GenericLinkedListIterator implements Iterator<T> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor <= elements.size() - 1;
        }

        @Override
        public T next() {
            return elements.get(cursor++);
        }
    }
}