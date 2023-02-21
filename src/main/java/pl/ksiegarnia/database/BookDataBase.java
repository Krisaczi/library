package pl.ksiegarnia.database;

import org.springframework.stereotype.Component;
import pl.ksiegarnia.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDataBase implements IBookDAO{
    private final List<Book> books = new ArrayList<>();

    public BookDataBase(){
        Book book = new Book(1,
                "I will teach you to be rich",
                "Ramit Sethi",
                112.50,
                5,
                "132-254-587-741");

        this.books.add(book);

        this.books.add(new Book(2,
                "5 Składników",
                "Jamie Olivier",
                84.56,
                7,
                "542-568-523-841"));

        this.books.add(new Book(3,
                "Podstawy Rachunkowości",
                "Małgorzata Jankowska",
                68.00,
                3,
                "548-625-741-159"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public List<Book> getBooksByPattern(String pattern) {

        List<Book> filteredBooks = new ArrayList<>();

        for(Book book : this.books){
            if(book.getTitle().toLowerCase().contains(pattern.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(pattern.toLowerCase())){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
}
