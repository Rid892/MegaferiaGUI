package controller;

import model.Response;
import model.entities.*;
import model.repositories.PublisherRepository;
import java.util.List;

public class PublisherController {
    private final PublisherRepository repo = new PublisherRepository();

    public Response<Publisher> createPublisher(String nit, String name, Manager manager) {
        return repo.create(nit, name, manager);
    }

    public List<Publisher> getAllPublishers() {
        return repo.getAll();
    }
}