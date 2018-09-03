package _004BookComparator;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.7.2018 г.
 * Time: 15:02 ч.
 */
public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        return book1.compareTo(book2);
    }
}