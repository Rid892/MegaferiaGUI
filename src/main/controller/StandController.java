package controller;

import model.Stand;
import repository.StandRepository;
import utils.Response;
import utils.BusinessException;
import utils.StatusCode;
import java.util.ArrayList;

public class StandController {
    private final StandRepository repo = new StandRepository();

    public Response<Stand> crear(String id, double precio) {
        try {
            if (id.trim().isEmpty()) throw new BusinessException(StatusCode.VALIDATION_ERROR, "ID requerido");
            if (precio <= 0) throw new BusinessException(StatusCode.VALIDATION_ERROR, "Precio inválido");
            if (repo.findById(id) != null) throw new BusinessException(StatusCode.DUPLICATE, "Stand ya existe");

            Stand s = new Stand(id, precio);
            repo.save(s);
            return new Response<>(s, "Stand creado", true);
        } catch (BusinessException e) {
            return new Response<>(null, e.getMessage(), false);
        }
    }

    public Response<ArrayList<Stand>> getAll() {
        return new Response<>(repo.getAll(), "OK", true);
    }
}