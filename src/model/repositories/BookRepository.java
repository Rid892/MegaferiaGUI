package model.repositories;

import model.entities.Book;
import java.util.ArrayList;

public class BookRepository {
    private final ArrayList<Book> books = new ArrayList<>();
    public void save(Book b) { books.add(b); }
    public ArrayList<Book> getAll() { return new ArrayList<>(books); }
}