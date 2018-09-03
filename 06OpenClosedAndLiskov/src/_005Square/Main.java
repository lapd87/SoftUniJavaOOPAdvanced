package _005Square;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 16:00 ч.
 */
public class Main {
    public static void main(String[] args) {
        Quadrilateral rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(10);

        Quadrilateral square = new Square();
        square.setHeight(5);

        System.out.println(rectangle.getArea());
        System.out.println(square.getArea());
    }
}