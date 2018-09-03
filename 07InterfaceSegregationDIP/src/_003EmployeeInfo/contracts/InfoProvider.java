package _003EmployeeInfo.contracts;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 13:22 ч.
 */
public interface InfoProvider<T> {
    List<T> getByName();

    Iterable<T> getBySalary();
}
