package pl.ksiegarnia.database;

import pl.ksiegarnia.model.Book;

import java.util.List;

public interface IBookDAO {
    List<Book> getBooks();
    List<Book> getBooksByPattern(String pattern);

}
