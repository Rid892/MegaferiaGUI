package model.repositories;

import model.entities.Person;
import java.util.ArrayList;

public class PersonRepository {
    private final ArrayList<Person> persons = new ArrayList<>();
    public void save(Person p) { persons.add(p); }
    public ArrayList<Person> getAll() { return new ArrayList<>(persons); }
}