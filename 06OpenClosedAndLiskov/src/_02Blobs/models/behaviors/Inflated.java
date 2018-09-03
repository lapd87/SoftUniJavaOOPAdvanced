package _02Blobs.models.behaviors;

import _02Blobs.models.Blob;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 13:44 ч.
 */
public class Inflated extends AbstractBehavior {

    private static final int INFLATED_HEALTH_INCREMENT = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 10;

    @Override
    public void trigger(Blob source) {
        if (super.isTriggered()) {
            throw new IllegalStateException();
        }

        super.setIsTriggered(true);
        source.setHealth(source.getHealth() + INFLATED_HEALTH_INCREMENT);
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setHealth(source.getHealth() - INFLATED_HEALTH_DECREMENT);
        }
    }
}