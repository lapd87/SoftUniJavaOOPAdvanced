package _002WarningLevels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 18.7.2018 г.
 * Time: 09:44 ч.
 */
public class Logger {

    private Enum importanceLevel;
    private List<Message> log;

    public Logger(String importanceLevel) {
        log = new ArrayList<>();
        this.importanceLevel = Enum.valueOf(Importance.class,
                importanceLevel.toUpperCase());
    }

    public void addMessage(Message message) {
        if (message.getImportance().compareTo(importanceLevel) >= 0) {
            log.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return log;
    }
}