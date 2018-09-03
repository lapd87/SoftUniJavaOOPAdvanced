package _06StrategyPattern;


import java.util.Comparator;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 15:26 ч.
 */
public class ComparatorPersonName implements Comparator<Person> {

    public ComparatorPersonName() {
    }

    @Override
    public int compare(Person person1, Person person2) {
        int comapareNamesLength = person1.getName().length() -
                person2.getName().length();

        if (comapareNamesLength != 0) {
            return comapareNamesLength;
        }

        int compareFirstChar = person1.getName().toLowerCase().charAt(0) -
                person2.getName().toLowerCase().charAt(0);

        return compareFirstChar;
    }
}