package _01GenericBox;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 12.7.2018 г.
 * Time: 14:05 ч.
 */
public class Box<T> {

    private T element;

    public Box() {
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                element.getClass().getName(),
                element);
    }
}