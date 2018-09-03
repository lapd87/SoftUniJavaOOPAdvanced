package _003EmployeeInfo.contracts;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 13:17 ч.
 */
public interface Formatter<T> {

    String format(Iterable<T> t);
}