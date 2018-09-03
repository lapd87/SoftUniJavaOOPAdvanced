package _11Threeuple;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 13.7.2018 г.
 * Time: 09:39 ч.
 */
public class Threeuple<T> {

    private T item1;
    private T item2;
    private T item3;

    public Threeuple(T item1, T item2, T item3) {
        setItem1(item1);
        setItem2(item2);
        setItem3(item3);
    }

    private void setItem1(T item1) {
        this.item1 = item1;
    }

    private void setItem2(T item2) {
        this.item2 = item2;
    }

    private void setItem3(T item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(item1)
                .append(" -> ")
                .append(item2)
                .append(" -> ")
                .append(item3);

        return stringBuilder.toString();
    }
}