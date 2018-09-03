package _003EmployeeInfo.contracts;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 13:19 ч.
 */
public interface Database<T> {
    List<T> readAll();
}
