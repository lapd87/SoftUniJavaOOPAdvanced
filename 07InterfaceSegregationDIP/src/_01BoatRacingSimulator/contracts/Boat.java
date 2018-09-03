package _01BoatRacingSimulator.contracts;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 3.8.2018 г.
 * Time: 21:08 ч.
 */
public interface Boat extends Modelable {
    Boolean isSailboat();

    double calculateRaceSpeed(Race currentRace);
}
