package _06StrategyPattern;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 15:31 ч.
 */
public class ComparatorPersonAge implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge();
    }
}