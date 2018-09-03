package _002Library;

import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 16.7.2018 г.
 * Time: 14:22 ч.
 */
public class Library implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < books.length - 1;
        }

        @Override
        public Book next() {
            return books[counter++];
        }
    }
}