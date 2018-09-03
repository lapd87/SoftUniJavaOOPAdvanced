package _004Observer.models;

import _004Observer.contracts.Attacker;
import _004Observer.contracts.Target;
import _004Observer.logger_pattern.enums.LogType;
import _004Observer.logger_pattern.interfaces.Handler;
import _004Observer.observer_pattern.interfaces.Observer;

public abstract class AbstractHero implements Attacker, Observer {

    private static final String TARGET_NULL_MESSAGE = "Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";
    private static final String GET_AWARD_MESSAGE = "%s gains %s xp";


    private String id;
    private int dmg;
    private Target target;
    private Handler handler;

    public AbstractHero(String id, int dmg, Handler handler) {
        this.id = id;
        this.dmg = dmg;
        this.handler = handler;
    }

    public void setTarget(Target target) {
        if (target == null) {
            handler.handle(LogType.TARGET, TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            handler.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, target));
        }
    }

    protected Handler getHandler() {
        return handler;
    }

    public final void attack() {
        if (this.target == null) {
            handler.handle(LogType.TARGET, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            handler.handle(LogType.TARGET, String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg);
        }
    }

    @Override
    public void update(int reward) {
        this.handler.handle(LogType.EVENT, String.format(GET_AWARD_MESSAGE, this, reward));    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(Target target, int dmg);
}
