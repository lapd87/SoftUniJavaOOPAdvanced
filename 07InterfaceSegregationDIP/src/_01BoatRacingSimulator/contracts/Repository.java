package _01BoatRacingSimulator.contracts;

import _01BoatRacingSimulator.exceptions.DuplicateModelException;
import _01BoatRacingSimulator.exceptions.NonExistantModelException;

public interface Repository<T extends Modelable> {
    void add(T item) throws DuplicateModelException;

    T getItem(String model) throws NonExistantModelException;
}
