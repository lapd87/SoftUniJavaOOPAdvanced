package _04WorkForce;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 14:32 ч.
 */
public abstract class Employee {
    private String name;
    private int workHours;

    protected Employee(String name, int workHours) {
        this.name = name;
        this.workHours = workHours;
    }

    public int getWorkHours() {
        return workHours;
    }

    public String getName() {
        return name;
    }
}