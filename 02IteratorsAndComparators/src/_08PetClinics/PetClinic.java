package _08PetClinics;

import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 17.7.2018 г.
 * Time: 16:29 ч.
 */
public class PetClinic implements Iterable<Pet> {

    private String name;
    private Pet[] rooms;

    public PetClinic(String name, int count) {
        setName(name);
        setRooms(count);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRooms(int count) {
        if (count % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        rooms = new Pet[count];
    }

    public boolean addPet(Pet pet) {
        Iterator<Integer> petAddIterator = new RoomIteratorAddPet();
        while (petAddIterator.hasNext()) {
            int index = petAddIterator.next();
            if (rooms[index] == null) {
                rooms[index] = pet;
                return true;
            }
        }
        return false;
    }


    public boolean releasePet() {
        Iterator<Integer> petReleaseIterator = new RoomIteratorReleasePet();
        while (petReleaseIterator.hasNext()) {
            int index = petReleaseIterator.next();
            if (rooms[index] != null) {
                rooms[index] = null;
                return true;
            }
        }
        return false;
    }


    public boolean hasEmptyRooms() {
        for (Pet room : rooms) {
            if (room == null) {
                return true;
            }
        }
        return false;
    }

    public void printAllRooms() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pet room : rooms) {
            if (room == null) {
                stringBuilder.append("Room empty")
                        .append(System.lineSeparator());
            } else {
                stringBuilder.append(room)
                        .append(System.lineSeparator());
            }
        }

        System.out.print(stringBuilder.toString());
    }

    public void printRoom(int roomNumber) {
        if (rooms[roomNumber - 1] == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(rooms[roomNumber - 1]);
        }
    }

    @Override
    public Iterator<Pet> iterator() {
        return new RoomIterator();
    }

    private class RoomIterator implements Iterator<Pet> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < rooms.length - 1;
        }

        @Override
        public Pet next() {
            return rooms[cursor++];
        }
    }

    private class RoomIteratorAddPet implements Iterator<Integer> {

        private int cursor = rooms.length == 1 ? -1 : rooms.length / 2;
        private int previousCursorDistance = 0;


        @Override
        public boolean hasNext() {
            return cursor < rooms.length - 1;
        }

        @Override
        public Integer next() {
            if (cursor < 0) {
                cursor++;
            }

            if (previousCursorDistance % 2 == 0) {
                cursor += previousCursorDistance;
            } else {
                cursor -= previousCursorDistance;
            }

            previousCursorDistance++;

            return cursor;
        }

    }

    private class RoomIteratorReleasePet implements Iterator<Integer> {

        private int cursor = rooms.length / 2;

        @Override
        public boolean hasNext() {
            return cursor != Math.abs(rooms.length / 2 - 1);
        }

        @Override
        public Integer next() {
            if (cursor > rooms.length - 1) {
                cursor = 0;
            }

            return cursor++;
        }
    }
}