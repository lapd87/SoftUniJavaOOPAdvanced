package _002GenericArrayCreator;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 11.7.2018 г.
 * Time: 11:12 ч.
 */
public class Main {
    public static void main(String[] args) {

        Object[] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);

        for (Object string : strings) {
            System.out.println(string);
        }

        for (Object integer : integers) {
            System.out.println(integer);
        }
    }
}