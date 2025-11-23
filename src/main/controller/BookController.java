package controller;

import model.Response;
import model.entities.*;
import model.repositories.BookRepository;
import java.util.List;

public class BookController {
    private final BookRepository repo = new BookRepository();

    public Response<Book> createBook(String isbn, String title, List<Author> authors,
                                   Publisher publisher, double price, String type, Narrator narrator) {
        return repo.create(isbn, title, authors, publisher, price, type, narrator);
    }

    public List<Book> getAllBooks() {
        return repo.getAll();
    }

    public List<Book> getBooksByAuthor(Author author) {
        return repo.getByAuthor(author);
    }
}