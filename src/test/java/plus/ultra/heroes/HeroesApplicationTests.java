package plus.ultra.heroes;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import plus.ultra.heroes.repository.HeroRepository;
import static plus.ultra.heroes.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext // limpa o contexto antes de executar novos métodos
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroRepository heroesRepository;

	@Test
	public void getHeroById(){
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"3")
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getHeroByIdNotFound(){
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"10")
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deleteHero(){
		webTestClient.delete().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"),"3")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);
	}

}
