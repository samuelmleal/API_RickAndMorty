package ConsumindoApi.ApiRickAndMorty.Service;

import ConsumindoApi.ApiRickAndMorty.Response.CharacterResponse;
import ConsumindoApi.ApiRickAndMorty.Response.EpisodeResponse;
import ConsumindoApi.ApiRickAndMorty.Response.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class ApiService {

    private final WebClient webClient;

    public ApiService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findCharacterById(String id){
        log.info("Buscando o personagem com o id [{}] ", id);
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error ->Mono.error(new RuntimeException("Verifique os parâmetros que foram passados")))
                .bodyToMono(CharacterResponse.class);
    }
    public Mono<LocationResponse> findLocationById(String id){
        log.info("Buscando local com o id [{}] ", id);
        return webClient
                .get()
                .uri("/location/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error ->Mono.error(new RuntimeException("Verifique os parâmetros que foram passados")))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findEpisodeById(String id){
        log.info("Buscando episódio com o id [{}] ", id);
        return webClient
                .get()
                .uri("/episode/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error ->Mono.error(new RuntimeException("Verifique os parâmetros que foram passados")))
                .bodyToMono(EpisodeResponse.class);
    }
}
