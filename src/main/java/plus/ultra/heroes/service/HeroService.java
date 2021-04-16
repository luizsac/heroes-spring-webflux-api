package plus.ultra.heroes.service;

import org.springframework.stereotype.Service;
import plus.ultra.heroes.document.Hero;
import plus.ultra.heroes.repository.HeroRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroService {
    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Flux<Hero> findAll() {
        return Flux.fromIterable(this.heroRepository.findAll());
    }

    public Mono<Hero> findById(String id) {
        return Mono.justOrEmpty(this.heroRepository.findById(id));
    }

    public Mono<Hero> save(Hero hero) {
        return Mono.justOrEmpty(this.heroRepository.save(hero));
    }

    public Mono<Boolean> deleteById(String id) {
        heroRepository.deleteById(id);
        return Mono.just(true);
    }

}
