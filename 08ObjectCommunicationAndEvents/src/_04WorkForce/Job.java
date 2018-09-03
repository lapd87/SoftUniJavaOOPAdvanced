package _04WorkForce;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 14:34 ч.
 */
public class Job {

    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;

    public Job(String name, int hoursOfWorkRequired,
               Employee employee) {
        this.name = name;
        this.hoursOfWorkRequired = hoursOfWorkRequired;
        this.employee = employee;
    }

    public boolean update() {
        this.hoursOfWorkRequired -= this.employee.getWorkHours();

        if (hoursOfWorkRequired <= 0) {
            System.out.println(String.format("Job %s done!",
                    name));
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d",
                name, hoursOfWorkRequired);
    }
}