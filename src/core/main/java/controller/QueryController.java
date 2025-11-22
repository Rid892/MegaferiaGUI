package controller;

import model.entities.*;
import model.repositories.BookRepository;
import java.util.*;
import java.util.stream.Collectors;

public class QueryController {
    private final BookRepository bookRepo = new BookRepository();

    public List<Book> getBooksByFormat(String format) {
        return bookRepo.getAll().stream()
                .filter(b -> {
                    if ("Impreso".equals(format)) return b instanceof PrintedBook;
                    if ("Digital".equals(format)) return b instanceof DigitalBook;
                    if ("Audiolibro".equals(format)) return b instanceof Audiobook;
                    return false;
                })
                .toList();
    }

    public Map<Publisher, List<Author>> getAuthorsWithMostBooksInDifferentPublishers() {
        Map<Author, Set<Publisher>> authorPublishers = new HashMap<>();
        for (Book b : bookRepo.getAll()) {
            for (Author a : b.getAuthors()) {
                authorPublishers.computeIfAbsent(a, k -> new HashSet<>()).add(b.getPublisher());
            }
        }
        Map<Publisher, List<Author>> result = new HashMap<>();
        authorPublishers.forEach((author, pubs) -> {
            if (pubs.size() > 1) {
                for (Publisher p : pubs) {
                    result.computeIfAbsent(p, k -> new ArrayList<>()).add(author);
                }
            }
        });
        return result;
    }
}