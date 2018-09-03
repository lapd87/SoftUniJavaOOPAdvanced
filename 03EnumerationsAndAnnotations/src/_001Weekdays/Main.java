package _001Weekdays;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 09:33 ч.
 */
public class Main {
    public static void main(String[] args) {
        WeeklyCalendar wc = new WeeklyCalendar();

        wc.addEntry("Friday", "sleep");
        wc.addEntry("Monday", "sport");

        Iterable<WeeklyEntry> schedule = wc.getWeeklySchedule();
        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }
    }
}