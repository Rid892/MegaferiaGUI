package repository;

import model.Publisher;
import java.util.ArrayList;

public class PublisherRepository {
    private final ArrayList<Publisher> publishers = new ArrayList<>();
    public void save(Publisher p) { publishers.add(p); }
    public ArrayList<Publisher> getAll() { return new ArrayList<>(publishers); }
}