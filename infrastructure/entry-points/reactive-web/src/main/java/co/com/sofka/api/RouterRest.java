package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(POST("/api/usecase/heroe"), handler::createHeroePOSTUseCase)
                .and(route(GET("/api/heroe"), handler::listarGETUseCase))
                .and(route(GET("/api/heroebyid/{id}"), handler::listarByIdGETUseCase))
                .and(route(DELETE("/api/heroe/{id}"), handler::deleteGETUseCase))
                .and(route(POST("/api/heroe/{id}"), handler::updatePOSTUseCase));
//    .and(route(GET("/api/otherusercase/path"), handler::createPetPOSTUseCase))
//    .andRoute(GET("/api/usecase/path"), handler::createPetPOSTUseCase)
    }
}
