package co.com.sofka.model.heroe.gateways;

import co.com.sofka.model.heroe.Heroe;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HeroeRepository {

     Mono<Heroe> save(Heroe heroe);

     Flux<Heroe> findAll();

     Mono<Heroe> findById(String id);

     Mono<Void> delete(String id);

    Mono<Heroe> update(String id, Heroe pet);
}
