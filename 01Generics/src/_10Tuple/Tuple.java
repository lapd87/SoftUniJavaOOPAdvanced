package _10Tuple;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 13.7.2018 г.
 * Time: 09:34 ч.
 */
public class Tuple<T> {

    private T item1;
    private T item2;

    public Tuple(T item1, T item2) {
        setItem1(item1);
        setItem2(item2);
    }

    private void setItem1(T item1) {
        this.item1 = item1;
    }

    private void setItem2(T item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return item1 + " -> " + item2;
    }
}