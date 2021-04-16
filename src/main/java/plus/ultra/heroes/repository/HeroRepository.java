package plus.ultra.heroes.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import plus.ultra.heroes.document.Hero;

@EnableScan
public interface HeroRepository extends CrudRepository<Hero, String>{
}
