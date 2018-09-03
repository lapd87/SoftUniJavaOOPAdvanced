package _003EmployeeInfo.models;

import _003EmployeeInfo.contracts.Database;
import _003EmployeeInfo.contracts.InfoProvider;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider<Employee> {

    private Database<Employee> database;

    public EmployeeInfoProvider(Database<Employee> database) {
        this.database = database;
    }

    @Override
    public List<Employee> getByName() {
        return this.database.readAll().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Employee> getBySalary() {
        return this.database.readAll().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}
