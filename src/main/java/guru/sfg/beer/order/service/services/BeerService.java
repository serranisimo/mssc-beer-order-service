package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.web.model.BeerDto;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<BeerDto> getById(UUID id);

    Optional<BeerDto> getByUpc(String upc);
}
