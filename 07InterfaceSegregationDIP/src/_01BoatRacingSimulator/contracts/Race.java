package _01BoatRacingSimulator.contracts;

import _01BoatRacingSimulator.exceptions.DuplicateModelException;

import java.util.List;

public interface Race<T> {
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsEngines();

    void addParticipant(T t) throws DuplicateModelException;

    List<T> getParticipants();
}
