package _06GenericCountMethodDouble;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.7.2018 г.
 * Time: 14:05 ч.
 */
public class ComparableBox<T extends Comparable<T>> extends Box implements Comparable<ComparableBox<T>> {

    @Override
    public int compareTo(ComparableBox<T> other) {

       T element = (T) super.getElement();

        return element.compareTo((T) other.getElement());
    }
}