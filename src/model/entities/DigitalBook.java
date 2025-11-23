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
public class DigitalBook extends Book {
    
    private boolean hasHyperlink;
    private String hyperlink;

    public DigitalBook(String title, ArrayList<Author> authors, String isbn, String genre, String format, double value, Publisher publisher) {
        super(title, authors, isbn, genre, format, value, publisher);
        this.hasHyperlink = false;
        this.hyperlink = null;
    }
    
    public DigitalBook(String title, ArrayList<Author> authors, String isbn, String genre, String format, double value, Publisher publisher, String hyperlink) {
        super(title, authors, isbn, genre, format, value, publisher);
        this.hasHyperlink = true;
        this.hyperlink = hyperlink;
    }

    public boolean hasHyperlink() {
        return hasHyperlink;
    }
    
    public String getHyperlink() {
        return hyperlink;
    }

    @Override
    public DigitalBook deepCopy() {
        DigitalBook copy = new DigitalBook();
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