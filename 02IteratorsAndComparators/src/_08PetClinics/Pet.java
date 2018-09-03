package _08PetClinics;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 16:25 ч.
 */
public class Pet {

    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + kind;
    }
}