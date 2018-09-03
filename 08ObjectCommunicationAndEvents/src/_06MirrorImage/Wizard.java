package _06MirrorImage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 15:08 ч.
 */
public class Wizard {

    private static int idCounter = 0;

    private int id;
    private String name;
    private int magicPower;
    private List<Wizard> reflections;

    public Wizard(String name, int magicPower) {
        this.id = idCounter++;
        this.name = name;
        this.magicPower = magicPower;
        this.reflections = new ArrayList<>();
    }

    public void useReflection(int id) {

        Wizard wizard = findById(id);

        if (wizard != null) {
            wizard.useReflection();
        }
    }

    private void useReflection() {
        System.out.println(String.format("%s %d casts Reflection",
                name, id));

        reflections.forEach(Wizard::useReflection);

        if (reflections.size() == 0) {
            for (int i = 0; i < 2; i++) {
                reflections.add(new Wizard(name,
                        magicPower / 2));
            }
        }
    }

    public void useFireBall(int id) {

        Wizard wizard = findById(id);

        if (wizard != null) {
            wizard.useFireBall();
        }
    }

    private void useFireBall() {
        System.out.println(String.format("%s %d casts Fireball for %d damage",
                name, id, magicPower));

        reflections.forEach(Wizard::useFireBall);
    }

    private Wizard findById(int id) {
        Wizard wizard;

        if (this.id == id) {
            wizard = this;
        } else {
            Set<Wizard> allWizards = getReflections();

            wizard = allWizards.stream()
                    .filter(w -> w.id == id)
                    .findFirst()
                    .orElse(null);
        }
        return wizard;
    }

    private Set<Wizard> getReflections() {
        Set<Wizard> allWizards = new HashSet<>();
        allWizards.add(this);

        for (Wizard reflection : reflections) {
            allWizards.addAll(reflection.getReflections());
        }
        return allWizards;
    }
}