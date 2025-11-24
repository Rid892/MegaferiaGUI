package controller;

import model.Person;
import repository.PersonRepository;
import utils.Response;
import utils.BusinessException;
import utils.StatusCode;
import java.util.ArrayList;

public class PersonController {
    private final PersonRepository repo = new PersonRepository();

    public Response<Person> crear(String id, String nombre, String apellido, String tipo) {
        try {
            if (id.isBlank() || nombre.isBlank() || apellido.isBlank())
                throw new BusinessException(StatusCode.VALIDATION_ERROR, "Todos los campos son obligatorios");

            Person p = new Person(id, nombre, apellido, tipo);
            repo.save(p);
            return new Response<>(p, tipo + " creado exitosamente", true);
        } catch (BusinessException e) {
            return new Response<>(null, e.getMessage(), false);
        }
    }

    public Response<ArrayList<Person>> getAll() {
        return new Response<>(repo.getAll(), "OK", true);
    }
}