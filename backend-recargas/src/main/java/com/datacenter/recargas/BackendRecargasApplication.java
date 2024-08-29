package com.datacenter.recargas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Clase principal para ejecutar el proyecto spring boot.
 */
@SpringBootApplication
@EnableTransactionManagement
public class BackendRecargasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendRecargasApplication.class, args);
	}

}
