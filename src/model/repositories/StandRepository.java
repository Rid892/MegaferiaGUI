package model.repositories;

import model.Response;
import model.StatusCode;
import model.entities.Stand;
import java.util.ArrayList;
import java.util.List;

public class StandRepository {
    private final List<Stand> stands = new ArrayList<>();

    public Response<Stand> create(long id, double price) {
        if (id < 0 || String.valueOf(id).length() > 15)
            return new Response<>(null, "ID inválido o >15 dígitos", StatusCode.BAD_REQUEST);
        if (price <= 0)
            return new Response<>(null, "Precio debe ser > 0", StatusCode.BAD_REQUEST);
        if (stands.stream().anyMatch(s -> s.getId() == id))
            return new Response<>(null, "Stand duplicado", StatusCode.CONFLICT);

        Stand stand = new Stand(id, price);
        stands.add(stand);
        stands.sort((a, b) -> Long.compare(a.getId(), b.getId()));
        return new Response<>(stand.deepCopy(), "Stand creado", StatusCode.SUCCESS);
    }

    public List<Stand> getAll() {
        return stands.stream().map(Stand::deepCopy).toList();
    }

    public Stand findById(long id) {
        return stands.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .map(Stand::deepCopy)
                .orElse(null);
    }
}