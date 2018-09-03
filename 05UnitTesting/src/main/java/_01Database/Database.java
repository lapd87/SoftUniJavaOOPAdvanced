package _01Database;

import javax.naming.OperationNotSupportedException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.7.2018 г.
 * Time: 16:22 ч.
 */
public class Database {

    private static final int DATABASE_CAPACITY = 16;

    private Integer[] storedInts;

    public Database(Integer[] storedInts) throws OperationNotSupportedException {
        setStoredInts(storedInts);
    }

    private void setStoredInts(Integer[] storedInts) throws OperationNotSupportedException {
        if (storedInts.length != DATABASE_CAPACITY) {
            throw new OperationNotSupportedException();
        }

        this.storedInts = storedInts;
    }

    public Integer[] fetch() {
        return storedInts;
    }

    public void add(Integer integer) throws OperationNotSupportedException {
        if (integer == null) {
            throw new OperationNotSupportedException();
        }

        if (!hasEmptyElement()) {
            throw new OperationNotSupportedException();
        }

        for (int i = 0; i < storedInts.length; i++) {
            if (storedInts[i] == null) {
                storedInts[i] = integer;
                break;
            }
        }
    }

    public void remove() throws OperationNotSupportedException {
        for (int i = DATABASE_CAPACITY - 1; i >= 0; i--) {
            if (storedInts[i] != null) {
                storedInts[i] = null;
                return;
            }
        }

        throw new OperationNotSupportedException();
    }

    private boolean hasEmptyElement() {
        boolean hasEmptyElement = false;
        for (Integer storedInt : storedInts) {
            if (storedInt == null) {
                hasEmptyElement = true;
                break;
            }
        }

        return hasEmptyElement;
    }
}