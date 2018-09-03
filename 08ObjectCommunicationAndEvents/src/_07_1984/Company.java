package _07_1984;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 17:26 ч.
 */
public class Company extends BaseSubject {

    private int turnover;
    private int revenue;

    public Company(String id, String name,
                   int turnover, int revenue) {
        super(id, name);
        this.turnover = turnover;
        this.revenue = revenue;
    }

    private int getTurnover() {
        return turnover;
    }

    private int getRevenue() {
        return revenue;
    }

    public void setTurnover(String turnover) {
        super.notifyAllObservers(
                String.format("--%s(ID:%s) changed turnover(int) from %d to %s",
                        this.getClass().getSimpleName(),
                        super.getId(),
                        this.getTurnover(),
                        turnover),"turnover");

        this.turnover = Integer.parseInt(turnover);
    }

    public void setRevenue(String revenue) {
        super.notifyAllObservers(
                String.format("--%s(ID:%s) changed revenue(int) from %d to %s",
                        this.getClass().getSimpleName(),
                        super.getId(),
                        this.getRevenue(),
                        revenue),"revenue");

        this.revenue = Integer.parseInt(revenue);
    }
}