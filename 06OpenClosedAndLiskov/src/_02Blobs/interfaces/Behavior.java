package _02Blobs.interfaces;

import _02Blobs.models.Blob;

public interface Behavior {
    void trigger(Blob source);

    void applyRecurrentEffect(Blob source);

    boolean isTriggered();
}
