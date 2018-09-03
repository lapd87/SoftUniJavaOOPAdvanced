package _01Logger.enums;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 29.7.2018 г.
 * Time: 16:29 ч.
 */
public enum ReportLevel {

    INFO, WARNING, ERROR, CRITICAL, FATAL;

    @Override
    public String toString() {
        return super.name();
    }
}
