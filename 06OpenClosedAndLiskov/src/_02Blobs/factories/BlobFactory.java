package _02Blobs.factories;

import _02Blobs.interfaces.Attack;
import _02Blobs.interfaces.Behavior;
import _02Blobs.models.Blob;
import _02Blobs.observers.Subject;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 15:03 ч.
 */
public class BlobFactory {

    public BlobFactory() {
    }

    public static Blob create(String name,
                              int health, int damage,
                              Behavior behavior,
                              Attack attack, Subject subject) {

        return new Blob(name, health, damage,
                behavior, attack, subject);
    }
}