package _08CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.7.2018 г.
 * Time: 15:18 ч.
 */
public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {

    private List<T> elements;

    public CustomListImpl() {
        elements = new ArrayList<>();
    }

    @Override
    public List<T> getElements() {
        return Collections.unmodifiableList(elements);
    }

    private boolean isValidIndex(int index) {
        if (index < elements.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void add(T element) {
        elements.add(element);
    }

    @Override
    public T remove(int index) {
        if (isValidIndex(index)) {
            return elements.remove(index);
        }

        return null;
    }

    @Override
    public boolean contains(T element) {
        if (elements.contains(element)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if (isValidIndex(firstIndex)
                && isValidIndex(secondIndex)) {
            T temp = elements.get(firstIndex);
            elements.set(firstIndex, elements.get(secondIndex));
            elements.set(secondIndex, temp);
        }
    }

    @Override
    public int countGreaterThan(T element) {

        return elements.stream()
                .filter(e -> e.compareTo(element) > 0)
                .collect(Collectors.toList())
                .size();
    }

    @Override
    public T getMax() {
        if (isValidIndex(0)) {
            return elements.stream()
                    .max(Comparator.naturalOrder())
                    .get();
        } else {
            return null;
        }
    }

    @Override
    public T getMin() {
        if (isValidIndex(0)) {
            return elements.stream()
                    .min(Comparator.naturalOrder())
                    .get();
        } else {
            return null;
        }
    }

    @Override
    public void sort() {
        this.elements = this.elements.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}