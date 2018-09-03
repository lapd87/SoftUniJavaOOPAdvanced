package _04WorkForce;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 14:37 ч.
 */
public class WokrForce {

    private List<Job> jobs;
    private Map<String, Employee> employees;

    public WokrForce() {
        this.jobs = new ArrayList<>();
        this.employees = new LinkedHashMap();
    }

    public void addEmployee(Employee employee) {
        this.employees.put(employee.getName(), employee);
    }

    public void addJob(Job job) {
        this.jobs.add(job);
    }

    public Employee getEmployeeByName(String name) {
        return employees.get(name);
    }

    public void updateJobs() {
        this.jobs = jobs.stream()
                .filter(Job::update)
                .collect(Collectors.toList());
    }

    public void printStatus() {
        jobs.forEach(System.out::println);
    }
}