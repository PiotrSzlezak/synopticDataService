package pl.ideopolis.synopticDataService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SynopticDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SynopticDataServiceApplication.class, args);
	}

}
