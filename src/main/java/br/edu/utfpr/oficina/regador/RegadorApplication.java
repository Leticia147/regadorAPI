package br.edu.utfpr.oficina.regador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RegadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegadorApplication.class, args);
	}

}
