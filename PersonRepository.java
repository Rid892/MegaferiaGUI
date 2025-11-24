package model.repositories;

import model.entities.Person;
import java.util.ArrayList;

public class PersonRepository {
    private final ArrayList<Stand> stands = new ArrayList<>();

    public void save(Stand s) {
        stands.add(s);
    }

    public ArrayList<Stand> getAll() {
        return new ArrayList<>(stands);
    }
}