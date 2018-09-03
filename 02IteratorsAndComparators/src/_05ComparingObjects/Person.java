package _05ComparingObjects;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 14:16 ч.
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        int compareNames = name.compareTo(person.name);
        if (compareNames != 0) {
            return compareNames;
        }

        int compareAge = age - person.age;
        if (compareAge != 0) {
            return compareAge;
        }

        return town.compareTo(person.town);
    }
}