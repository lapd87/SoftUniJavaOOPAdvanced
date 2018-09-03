package _01EventImplementation.models;

import _01EventImplementation.contracts.NameChangeListener;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 11:48 ч.
 */
public class Handler implements NameChangeListener {

    @Override
    public void handleChangedName(EventNameChange eventNameChange) {
        System.out.println(String.format("Dispatcher's name changed to %s.",
                eventNameChange.getChangedName()));
    }
}