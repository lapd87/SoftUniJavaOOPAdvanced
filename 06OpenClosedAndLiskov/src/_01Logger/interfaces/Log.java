package _01Logger.interfaces;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 1.8.2018 г.
 * Time: 17:53 ч.
 */
public interface Log {

    String getDateTime();

    Enum getReportLevel();

    String getMessage();
}
