package _004Recharge.models;

import _004Recharge.contracts.Sleeper;

public class Employee extends Worker implements Sleeper {

    public Employee(String id) {
        super(id);
    }

    @Override
    public void sleep() {
        // sleep...
    }
}
