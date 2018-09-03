package _001Weekdays;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 09:28 ч.
 */
public class WeeklyEntry {
    public final static Comparator<WeeklyEntry> COMPARATOR_BY_WEEKDAY = getComparatorByWeekday();

    private Enum weekday;

    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", weekday,
                notes);
    }

    private static Comparator<WeeklyEntry> getComparatorByWeekday() {
        return Comparator.comparing(e -> e.weekday);
    }
}