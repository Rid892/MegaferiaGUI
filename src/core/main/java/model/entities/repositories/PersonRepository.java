package model.repositories;

import model.Response;
import model.StatusCode;
import model.entities.*;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private final List<Person> people = new ArrayList<>();

    public Response<Author> createAuthor(long id, String name, String lastName) {
        if (id < 0 || String.valueOf(id).length() > 15 || name.isBlank() || lastName.isBlank())
            return new Response<>(null, "Datos inválidos", StatusCode.BAD_REQUEST);
        if (people.stream().anyMatch(p -> p.getId() == id))
            return new Response<>(null, "ID duplicado", StatusCode.CONFLICT);

        Author author = new Author(id, name, lastName);
        people.add(author);
        return new Response<>(author.deepCopy(), "Autor creado", StatusCode.SUCCESS);
    }

    // Repite para Manager y Narrator (copia-pega y cambia clase)
    public Response<Manager> createManager(long id, String name, String lastName) {
        // igual que arriba pero crea Manager
        Manager m = new Manager(id, name, lastName);
        people.add(m);
        return new Response<>(m.deepCopy(), "Gerente creado", StatusCode.SUCCESS);
    }

    public Response<Narrator> createNarrator(long id, String name, String lastName) {
        Narrator n = new Narrator(id, name, lastName);
        people.add(n);
        return new Response<>(n.deepCopy(), "Narrador creado", StatusCode.SUCCESS);
    }

    public List<Person> getAll() {
        return people.stream().map(Person::deepCopy).toList();
    }
}