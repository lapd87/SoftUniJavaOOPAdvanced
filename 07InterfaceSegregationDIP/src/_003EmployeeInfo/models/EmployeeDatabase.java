package _003EmployeeInfo.models;

import _003EmployeeInfo.contracts.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDatabase implements Database<Employee> {

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
        Collections.addAll(employees,
                new Employee("Pesho", 20),
                new Employee("Gosho", 40));

        return employees;
    }
}
