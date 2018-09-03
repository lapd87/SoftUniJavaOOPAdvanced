package _001SystemResources.impl;

import _001SystemResources.interfaces.TimeProvider;

import java.time.LocalTime;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 10:47 ч.
 */
public class LocalTimeProvider implements TimeProvider {


    @Override
    public int getCurrentHour() {
        return LocalTime.now().getHour();
    }
}