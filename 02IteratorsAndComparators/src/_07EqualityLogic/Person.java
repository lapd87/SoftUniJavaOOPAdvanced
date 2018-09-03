package _07EqualityLogic;

import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 15:19 ч.
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }

    @Override
    public int compareTo(Person person) {
        int compareNames = name.compareTo(person.name);
        if (compareNames != 0) {
            return compareNames;
        }

        return age - person.age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) {
            return false;
        }

        Person person = (Person) obj;
        return this.compareTo(person) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}