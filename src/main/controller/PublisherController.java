package controller;

import model.Publisher;
import model.Person;
import model.Stand;
import repository.PublisherRepository;
import repository.PersonRepository;
import repository.StandRepository;
import utils.Response;
import utils.BusinessException;
import utils.StatusCode;
import java.util.ArrayList;

public class PublisherController {
    private final PublisherRepository repo = new PublisherRepository();
    private final PersonRepository personRepo = new PersonRepository();

    public Response<Publisher> crear(String nit, String nombre, String direccion, String gerenteId) {
        try {
            Person gerente = personRepo.getAll().stream()
                .filter(p -> p.getId().equals(gerenteId) && "Gerente".equals(p.getTipo()))
                .findFirst().orElse(null);

            if (gerente == null) throw new BusinessException(StatusCode.NOT_FOUND, "Gerente no encontrado");

            Publisher pub = new Publisher(nit, nombre, direccion, gerente);
            repo.save(pub);
            return new Response<>(pub, "Editorial creada", true);
        } catch (BusinessException e) {
            return new Response<>(null, e.getMessage(), false);
        }
    }

    public Response<ArrayList<Publisher>> getAll() {
        return new Response<>(repo.getAll(), "OK", true);
    }
}