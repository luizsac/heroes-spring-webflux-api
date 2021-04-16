package plus.ultra.heroes.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plus.ultra.heroes.document.Hero;
import plus.ultra.heroes.repository.HeroRepository;
import plus.ultra.heroes.service.HeroService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static plus.ultra.heroes.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@Slf4j
@RestController
public class HeroController {

    HeroService heroService;
    HeroRepository heroRepository;

    public HeroController(HeroService heroService, HeroRepository heroRepository) {
        this.heroService = heroService;
        this.heroRepository = heroRepository;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Hero> getAllItems() {
        log.info("Requesting the list of all Heroes");
        return heroService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Hero>> findById(@PathVariable String id) {
        log.info("Requesting Hero with id {}", id);
        return heroService.findById(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Hero> createHero(@RequestBody Hero hero) {
        log.info("A new Hero was created");
        return heroService.save(hero);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteById(@PathVariable String id) {
        heroService.deleteById(id);
        log.info("Deleting Hero with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }

}
