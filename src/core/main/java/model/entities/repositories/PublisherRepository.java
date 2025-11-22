package model.repositories;

import model.Response;
import model.StatusCode;
import model.entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PublisherRepository {
    private final List<Publisher> publishers = new ArrayList<>();
    private final PersonRepository personRepo = new PersonRepository();

    private boolean isValidNIT(String nit) {
        return Pattern.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d", nit);
    }

    public Response<Publisher> create(String nit, String name, Manager manager) {
        if (!isValidNIT(nit))
            return new Response<>(null, "NIT inválido (formato XXX.XXX.XXX-X)", StatusCode.BAD_REQUEST);
        if (name.isBlank() || manager == null)
            return new Response<>(null, "Nombre o gerente vacío", StatusCode.BAD_REQUEST);
        if (publishers.stream().anyMatch(p -> p.getNit().equals(nit)))
            return new Response<>(null, "NIT duplicado", StatusCode.CONFLICT);

        Publisher pub = new Publisher(nit, name, manager);
        publishers.add(pub);
        publishers.sort((a, b) -> a.getNit().compareTo(b.getNit()));
        return new Response<>(pub.deepCopy(), "Editorial creada", StatusCode.SUCCESS);
    }

    public List<Publisher> getAll() {
        return publishers.stream().map(Publisher::deepCopy).toList();
    }
}