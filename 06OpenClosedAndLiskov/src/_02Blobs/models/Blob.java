package _02Blobs.models;


import _02Blobs.core.commands.ReportEventsCommand;
import _02Blobs.interfaces.Attack;
import _02Blobs.interfaces.Behavior;
import _02Blobs.notifiers.BlobNotifier;
import _02Blobs.observers.AbstractObserver;
import _02Blobs.observers.Subject;

public class Blob extends AbstractObserver {

    private String name;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;
    private int initialHealth;
    private boolean hasReportEvent;


    public Blob(String name, int health, int damage,
                Behavior behavior, Attack attack,
                Subject subject) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;
        this.initialHealth = health;
        this.hasReportEvent = new ReportEventsCommand().shouldReport();
        subject.attach(this);
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            if (hasReportEvent) {
                new BlobNotifier().showMessage(String
                        .format("Blob %s was killed",
                                this.name));
            }
            this.currentHealth = 0;
        }

        if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.behavior.trigger(this);
            if (hasReportEvent) {
                new BlobNotifier().showMessage(String
                        .format("Blob %s toggled %sBehavior",
                                this.name,
                                this.behavior.getClass()
                                        .getSimpleName()));
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    public void attack(Blob target) {
        if (this.getHealth() == 0 || target.getHealth() == 0) {
            return;
        }

        this.attack.execute(this, target);
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED",
                    this.getName());
        }

        return String.format("Blob %s: %s HP, %s Damage",
                this.getName(),
                this.getHealth(),
                this.getDamage());
    }

    @Override
    public void update() {
        if (this.behavior.isTriggered()) {
            this.behavior.applyRecurrentEffect(this);
        }
    }
}
