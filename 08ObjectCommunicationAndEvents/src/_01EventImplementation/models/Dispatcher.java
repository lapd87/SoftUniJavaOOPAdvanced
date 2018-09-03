package _01EventImplementation.models;


import _01EventImplementation.contracts.NameChangeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 11:48 ч.
 */
public class Dispatcher {

    private String name;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
        this.fireNameChangeEvent(new EventNameChange(name));
    }

    public void addNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.add(nameChangeListener);
    }

    public void removeNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.remove(nameChangeListener);
    }

    public void fireNameChangeEvent(EventNameChange eventNameChange) {
        this.nameChangeListeners
                .forEach(ncl -> ncl.handleChangedName(eventNameChange));
    }
}