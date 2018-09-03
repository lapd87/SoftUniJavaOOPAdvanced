package _02Blobs.interfaces;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 2.8.2018 г.
 * Time: 14:59 ч.
 */
public interface Repository<T> {

    void add(T t);

    T getByName(String name);

    Collection<T> findAll();
}