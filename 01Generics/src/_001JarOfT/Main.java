package _001JarOfT;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 11.7.2018 г.
 * Time: 10:15 ч.
 */
public class Main {
    public static void main(String[] args) {

        Jar<String> jarOfString = new Jar<>();

        jarOfString.add("test");
        jarOfString.add("test2");

        String result = jarOfString.remove();

        System.out.println(result);
    }
}