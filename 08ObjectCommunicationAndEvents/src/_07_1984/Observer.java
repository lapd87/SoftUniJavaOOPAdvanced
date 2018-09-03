package _07_1984;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 17:55 ч.
 */
public abstract class Observer {
    protected List<Subject> subjects;

    protected Observer(Subject... subjects) {
        this.subjects = Arrays.asList(subjects);
        Arrays.stream(subjects)
                .forEach(s -> s.attach(this));
    }

    public abstract String[] getWatchedFields();

    public abstract void update(String log);
}
