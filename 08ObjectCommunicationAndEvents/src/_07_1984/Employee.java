package _07_1984;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 17:25 ч.
 */
public class Employee extends BaseSubject {

    private int income;

    public Employee(String id, String name, int income) {
        super(id, name);
        this.income = income;
    }

    private int getIncome() {
        return income;
    }

    public void setIncome(String income) {
        super.notifyAllObservers(
                String.format("--%s(ID:%s) changed income(int) from %d to %s",
                        this.getClass().getSimpleName(),
                        super.getId(),
                        this.getIncome(),
                        income),"income");

        this.income = Integer.parseInt(income);
    }
}