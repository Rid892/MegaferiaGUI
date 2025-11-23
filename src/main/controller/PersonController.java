package controller;

import model.Response;
import model.StatusCode;
import model.entities.*;
import model.repositories.PersonRepository;

public class PersonController {
    private final PersonRepository repo = new PersonRepository();

    public Response<Author> createAuthor(long id, String name, String lastName) {
        return repo.createAuthor(id, name, lastName);
    }

    public Response<Manager> createManager(long id, String name, String lastName) {
        return repo.createManager(id, name, lastName);
    }

    public Response<Narrator> createNarrator(long id, String name, String lastName) {
        return repo.createNarrator(id, name, lastName);
    }

    public List<Person> getAllPersons() {
        return repo.getAll();
    }
}