package _003GenericScale;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 11.7.2018 г.
 * Time: 12:47 ч.
 */
public class Scale<T extends Comparable> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left.compareTo(right) > 0) {
            return left;
        }

        if (left.compareTo(right) < 0) {
            return right;
        }

        return null;
    }
}