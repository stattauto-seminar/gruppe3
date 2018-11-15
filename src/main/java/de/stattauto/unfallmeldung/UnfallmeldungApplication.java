package de.stattauto.unfallmeldung;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.stattauto.unfallmeldung.entity.Unfallmeldung;
import de.stattauto.unfallmeldung.repository.UnfallRepository;

@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
public class UnfallmeldungApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnfallmeldungApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UnfallRepository unfallrepository) {
		return args -> {
			unfallrepository.save(new Unfallmeldung(null, "Bericht1",1L,1L));
			unfallrepository.save(new Unfallmeldung(null, "Bericht2",2L,2L));
			unfallrepository.save(new Unfallmeldung(null, "Bericht3",1L,2L));
			unfallrepository.save(new Unfallmeldung(null, "Bericht4",1L,1L));
		};
	}
}
