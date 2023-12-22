package ma.emsi.Voiture;

import jakarta.transaction.Transactional;
import ma.emsi.Voiture.model.Client;
import ma.emsi.Voiture.model.Voiture;
import ma.emsi.Voiture.repository.VoitureRepository;
import ma.emsi.Voiture.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
public class VoitureApplication {

	@Transactional
	@Bean
	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService cs){


		return args -> {
			Client c1 = cs.clientById(2l);
			Client c2 = cs.clientById(1l);
			Client c3 = cs.clientById(3l);

			voitureRepository.save(new Voiture(Long.parseLong("1"), "Toyota", "A 25 333", "Corolla", c1));
			voitureRepository.save(new Voiture(Long.parseLong("2"), "Toyota", "A 25 333", "Corolla", c1));
			voitureRepository.save(new Voiture(Long.parseLong("3"), "Toyota", "A 25 333", "Corolla", c2));

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VoitureApplication.class, args);
	}

}
