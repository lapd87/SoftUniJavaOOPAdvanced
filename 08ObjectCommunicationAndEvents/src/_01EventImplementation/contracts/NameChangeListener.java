package _01EventImplementation.contracts;

import _01EventImplementation.models.EventNameChange;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 11:50 ч.
 */
public interface NameChangeListener {

    void handleChangedName(EventNameChange eventNameChange);
}
