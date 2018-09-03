package _02Blobs.observers;



/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 15:36 ч.
 */
public abstract class AbstractObserver {

    protected Subject subject;

    public abstract void update();
}