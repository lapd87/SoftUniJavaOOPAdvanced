package _001Weekdays;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 09:27 ч.
 */
public enum Weekday {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        return this.name().charAt(0)
                + this.name().substring(1).toLowerCase();
    }
}
