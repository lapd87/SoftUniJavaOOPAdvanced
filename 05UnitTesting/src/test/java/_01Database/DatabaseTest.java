package _01Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 28.7.2018 г.
 * Time: 16:36 ч.
 */
public class DatabaseTest {

    private static final int DATABASE_CAPACITY = 16;
    private static final Integer[] DEFAULT_ARRAY = new Integer[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private static final Integer INTEGER_TWENTY = 20;
    private static final Integer INTEGER_NULL = null;

    private Database database;

    @Before
    public void initialize() throws OperationNotSupportedException {
        database = new Database(DEFAULT_ARRAY);
    }

    @Test
    public void fetchArrayLengthMatch() {

        int actualArrayLength = database.fetch().length;
        int expectedArrayLength = DATABASE_CAPACITY;

        Assert.assertEquals(expectedArrayLength, actualArrayLength);
    }

    @Test
    public void fetchArrayElementsMatch() {

        Integer[] actualArray = database.fetch();
        Integer[] expectedArray = DEFAULT_ARRAY;

        for (int i = 0; i < actualArray.length; i++) {
            Assert.assertEquals(expectedArray[i], actualArray[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addElementToFullDatabase() throws OperationNotSupportedException {
        database.add(INTEGER_TWENTY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNullElement() throws OperationNotSupportedException {
        database.add(INTEGER_NULL);
    }

    @Test
    public void addElement() throws OperationNotSupportedException {
        this.database = new Database(new Integer[DATABASE_CAPACITY]);
        database.add(INTEGER_TWENTY);

        Integer actualElement = database.fetch()[0];
        Integer expectedElement = INTEGER_TWENTY;

        Assert.assertEquals(expectedElement, actualElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeFromEmptyDB() throws OperationNotSupportedException {
        this.database = new Database(new Integer[DATABASE_CAPACITY]);

        database.remove();
    }

    @Test
    public void removeFromDB() throws OperationNotSupportedException {
        database.remove();

        Integer actualLastElement = database.fetch()[DATABASE_CAPACITY - 1];

        Integer expectedLastElement = INTEGER_NULL;

        Assert.assertEquals(expectedLastElement, actualLastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorWithDifferentArrayLength() throws OperationNotSupportedException {
        database = new Database(new Integer[DATABASE_CAPACITY - 1]);
    }
}