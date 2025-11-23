package model.repositories;

import model.Response;
import model.StatusCode;
import model.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    private boolean isValidISBN(String isbn) {
        return Pattern.matches("\\d{3}-\\d-\\d{2}-\\d{6}-\\d", isbn);
    }

    public Response<Book> create(String isbn, String title, List<Author> authors, Publisher publisher, double price, String type, Narrator narrator) {
        if (!isValidISBN(isbn)) return new Response<>(null, "ISBN inválido", StatusCode.BAD_REQUEST);
        if (books.stream().anyMatch(b -> b.getIsbn().equals(isbn))) return new Response<>(null, "ISBN duplicado", StatusCode.CONFLICT);
        if (price <= 0 || title.isBlank() || authors.isEmpty() || publisher == null) return new Response<>(null, "Datos incompletos", StatusCode.BAD_REQUEST);
        if ("Audiolibro".equals(type) && narrator == null) return new Response<>(null, "Narrador requerido", StatusCode.BAD_REQUEST);

        Book book = switch (type) {
            case "Impreso" -> new PrintedBook(isbn, title, authors, publisher, price);
            case "Digital" -> new DigitalBook(isbn, title, authors, publisher, price);
            case "Audiolibro" -> new Audiobook(isbn, title, authors, publisher, price, narrator);
            default -> null;
        };

        if (book == null) return new Response<>(null, "Tipo inválido", StatusCode.BAD_REQUEST);

        books.add(book);
        books.sort((a, b) -> a.getIsbn().compareTo(b.getIsbn()));
        return new Response<>(book.deepCopy(), "Libro creado", StatusCode.SUCCESS);
    }

    public List<Book> getAll() {
        return books.stream().map(Book::deepCopy).toList();
    }

    public List<Book> getByAuthor(Author author) {
        return books.stream()
                .filter(b -> b.getAuthors().contains(author))
                .map(Book::deepCopy)
                .toList();
    }
}