package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BeerServiceImpl implements BeerService {

    private static String BEER_PATH_V1 = "/api/v1/beer";
    private static String BEER_UPC_PATH_V1 = "/beerUpc";
    private final RestTemplate restTemplate;
    private String beerServiceHost;

    public BeerServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setBeerServiceHost(String beerServiceHost) {
        this.beerServiceHost = beerServiceHost;
    }

    @Override
    public Optional<BeerDto> getById(UUID id) {
        return Optional.of(this.restTemplate.getForObject(this.beerServiceHost + BEER_PATH_V1 + "/" + id, BeerDto.class));
    }

    @Override
    public Optional<BeerDto> getByUpc(String upc) {
        return Optional.of(this.restTemplate.getForObject(this.beerServiceHost + BEER_PATH_V1 + BEER_UPC_PATH_V1 + "/" + upc, BeerDto.class));
    }
}
