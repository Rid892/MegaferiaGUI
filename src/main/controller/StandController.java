package controller;

import model.Response;
import model.StatusCode;
import model.entities.Stand;
import model.repositories.StandRepository;
import java.util.List;

public class StandController {
    private final StandRepository repo = new StandRepository();

    public Response<Stand> createStand(long id, double price) {
        return repo.create(id, price);
    }

    public List<Stand> getAllStands() {
        return repo.getAll();
    }
}