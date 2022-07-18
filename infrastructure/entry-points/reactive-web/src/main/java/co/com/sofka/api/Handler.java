package co.com.sofka.api;

import co.com.sofka.model.heroe.Heroe;
import co.com.sofka.model.heroe.gateways.HeroeRepository;
import co.com.sofka.usecase.createheroe.CreateHeroeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class Handler {
    private final HeroeRepository petRepository;
    private final CreateHeroeUseCase createPetUseCase;

    public Mono<ServerResponse> createHeroePOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Heroe.class)
                .flatMap(element -> createPetUseCase.createHeroe(element)) //es un flujo alterno-proceso de almacenamiento retorna otro flujo ya que el metodo del usecase guarda
                .flatMap(element -> ServerResponse.ok() //es el flujo que combierte la respuesta anterior a un body
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(petRepository.save(element), Heroe.class));
    }

    public Mono<ServerResponse> listarGETUseCase(ServerRequest serverRequest) {
//        Flux<Pet> pets = petRepository.findAll();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(petRepository.findAll(), Heroe.class);
    }

    public Mono<ServerResponse> deleteGETUseCase(ServerRequest serverRequest) {
//        el requestparat lo saco del serverRequest
        var id = serverRequest.pathVariable("id");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON) // expone la respuesta en formato json depende dle mediatype
                .body(petRepository.delete(id), Heroe.class);
    }

    public Mono<ServerResponse> listarByIdGETUseCase(ServerRequest serverRequest) {
//        el requestparat lo saco del serverRequest
        var id = serverRequest.pathVariable("id");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON) // expone la respuesta en formato json depende dle mediatype
                .body(petRepository.findById(id), Heroe.class);
    }

    public Mono<ServerResponse> updatePOSTUseCase(ServerRequest serverRequest) {
//        el requestparat lo saco del serverRequest
        var id = serverRequest.pathVariable("id");

        return serverRequest.bodyToMono(Heroe.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(petRepository.update(id, element), Heroe.class));
    }
}
