package _003GenericScale;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 11.7.2018 г.
 * Time: 12:52 ч.
 */
public class Main {
    public static void main(String[] args) {

        Scale<String> stringScale = new Scale<>("a","c");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(1,2);
        System.out.println(integerScale.getHeavier());
    }
}