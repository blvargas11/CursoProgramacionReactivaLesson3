package com.cine.cinecalidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cine.cinecalidad")
public class CinecalidadApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinecalidadApplication.class, args);
	}

}
