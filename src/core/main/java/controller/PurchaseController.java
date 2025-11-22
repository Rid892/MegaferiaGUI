package controller;

import model.Response;
import model.StatusCode;
import model.entities.*;
import model.repositories.StandRepository;
import java.util.List;

public class PurchaseController {
    private final StandRepository standRepo = new StandRepository();

    public Response<String> assignPublishersToStands(List<Stand> stands, List<Publisher> publishers) {
        if (stands.isEmpty() || publishers.isEmpty())
            return new Response<>(null, "Seleccione al menos un stand y una editorial", StatusCode.BAD_REQUEST);

        for (Stand s : stands) {
            Stand stand = standRepo.findById(s.getId());
            if (stand == null) continue;
            for (Publisher p : publishers) {
                if (!stand.getPublishers().contains(p)) {
                    stand.addPublisher(p);
                }
            }
        }
        return new Response<>("Compra realizada con éxito", "Éxito", StatusCode.SUCCESS);
    }
}