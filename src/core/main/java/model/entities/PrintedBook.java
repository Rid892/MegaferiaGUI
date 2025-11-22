/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class PrintedBook extends Book {
    
    private int pages;
    private int copies;

    public PrintedBook(String title, ArrayList<Author> authors, String isbn, String genre, String format, double value, Publisher publisher, int pages, int copies) {
        super(title, authors, isbn, genre, format, value, publisher);
        this.pages = pages;
        this.copies = copies;
    }

    public int getPages() {
        return pages;
    }

    public int getCopies() {
        return copies;
    }

    @Override
    public PrintedBook deepCopy() {
        PrintedBook copy = new PrintedBook();
        copy.setIsbn(this.getIsbn());
        copy.setTitle(this.getTitle());
        copy.setPrice(this.getPrice());
        copy.setPublisher(this.getPublisher() != null ? this.getPublisher().deepCopy() : null);
        List<Author> authorsCopy = new ArrayList<>();
        this.getAuthors().forEach(a -> authorsCopy.add(a.deepCopy()));
        copy.setAuthors(authorsCopy);
        return copy;
    }
    
}
