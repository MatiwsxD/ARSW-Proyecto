package edu.eci.arsw.warGameApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "edu.eci.arsw.warGame" })
public class WarGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarGameApplication.class, args);
	}

}
