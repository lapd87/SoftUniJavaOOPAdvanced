package _04Froggy;

import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 11:06 ч.
 */
public class Lake implements Iterable<Integer> {

    private List<Integer> elements;

    public Lake(List<Integer> elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        private int cursor = elements.size() == 0 ? 0 : -2;

        private boolean isEvenCursor() {
            return cursor % 2 == 0;
        }

        @Override
        public boolean hasNext() {
            if (isEvenCursor() && elements.size() > 2) {
                return true;
            } else if (!isEvenCursor() && elements.size() > 2) {
                return cursor < elements.size() - 2;
            } else {
                return cursor < elements.size() - 1;
            }
        }

        @Override
        public Integer next() {
            cursor += 2;

            if (cursor > elements.size() - 1) {
                cursor = 1;
            }

            return elements.get(cursor);
        }
    }
}