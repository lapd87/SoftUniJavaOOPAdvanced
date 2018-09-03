package _002WarningLevels;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 09:41 ч.
 */
public class Message {

    private Enum importance;
    private String note;

    public Message(String importance, String note) {
        this.importance = Enum.valueOf(Importance.class,
                importance);
        this.note = note;
    }

    public Enum getImportance() {
        return importance;
    }

    @Override
    public String toString() {
        return importance.name() + ": " + note;
    }
}