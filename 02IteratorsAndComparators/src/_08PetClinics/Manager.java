package _08PetClinics;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 17:00 ч.
 */
public class Manager {

    private Map<String, PetClinic> clinics;
    private Map<String, Pet> pets;

    public Manager() {
        this.pets = new LinkedHashMap<>();
        clinics = new LinkedHashMap<>();
    }

    public void createClinic(String name, int rooms) {
        try {
            PetClinic petClinic = new PetClinic(name, rooms);
            clinics.putIfAbsent(name, petClinic);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    public void createPet(String name, int age, String kind) {
        Pet pet = new Pet(name, age, kind);
        pets.putIfAbsent(name, pet);
    }

    public boolean addPetToClinic(String petName, String clinicName) {
        Pet pet = pets.remove(petName);
        PetClinic petClinic = clinics.get(clinicName);

        return petClinic.addPet(pet);
    }

    public boolean releasePetFromClinic(String clinicName) {
        PetClinic petClinic = clinics.get(clinicName);

        return petClinic.releasePet();
    }

    public boolean hasEmptyRooms(String clinicName) {
        PetClinic petClinic = clinics.get(clinicName);

        return petClinic.hasEmptyRooms();
    }

    public void printClinic(String clinicName) {
        PetClinic petClinic = clinics.get(clinicName);

        petClinic.printAllRooms();
    }

    public void printClinicRoom(String clinicName, int roomNumber) {
        PetClinic petClinic = clinics.get(clinicName);

        petClinic.printRoom(roomNumber);
    }
}