package _01EventImplementation.models;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 11:48 ч.
 */
public class EventNameChange extends EventObject {

    private String changedName;

    public EventNameChange(String changedName) {
        this.changedName = changedName;
    }

    public String getChangedName() {
        return changedName;
    }
}