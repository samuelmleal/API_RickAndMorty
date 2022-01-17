package ConsumindoApi.ApiRickAndMorty.Controller;


import ConsumindoApi.ApiRickAndMorty.Response.CharacterResponse;
import ConsumindoApi.ApiRickAndMorty.Response.EpisodeResponse;
import ConsumindoApi.ApiRickAndMorty.Response.LocationResponse;
import ConsumindoApi.ApiRickAndMorty.Service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class ApiController {

    ApiService service;

    @GetMapping("/character/{id}")
    public Mono <CharacterResponse> getCharacterById (@PathVariable String id){
        return service.findCharacterById(id);
    }

    @GetMapping("/location/{id}")
    public Mono <LocationResponse> getLocationById (@PathVariable String id){
        return service.findLocationById(id);
    }
    @GetMapping("/episode/{id}")
    public Mono <EpisodeResponse> getEpisodeById (@PathVariable String id){
        return service.findEpisodeById(id);
    }
}