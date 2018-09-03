package _07_1984;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 17:26 ч.
 */
public class Institution extends Observer {

    private String id;
    private String name;
    private String[] watchedFields;
    private List<String> logs;

    public Institution(String id,
                       String name,
                       String[] watchedFields,
                       Subject... subjects) {
        super(subjects);
        this.id = id;
        this.name = name;
        this.watchedFields = watchedFields;
        this.logs = new ArrayList<>();
    }

    @Override
    public String[] getWatchedFields() {
        return watchedFields;
    }

    @Override
    public String toString() {
        return String.format("%s: %d changes registered%n%s",
                name,
                logs.size(),
                String.join(System.lineSeparator(), logs));
    }

    @Override
    public void update(String log) {
        logs.add(log);
    }
}