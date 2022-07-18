package co.com.sofka.usecase.createheroe;

import co.com.sofka.model.heroe.Heroe;
import co.com.sofka.model.heroe.gateways.HeroeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateHeroeUseCase {

    private final HeroeRepository repository;

    public Mono<Heroe> createHeroe(Heroe heroe){
        return repository.save(heroe);
    }

}
