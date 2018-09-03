package _001Weekdays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 09:30 ч.
 */
public class WeeklyCalendar {

    private List<WeeklyEntry> calendar;

    public WeeklyCalendar() {
        calendar = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes) {
        WeeklyEntry weeklyEntry = new WeeklyEntry(weekday, notes);
        calendar.add(weeklyEntry);
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        Collections.sort(calendar, WeeklyEntry.COMPARATOR_BY_WEEKDAY);
        return this.calendar;
    }
}