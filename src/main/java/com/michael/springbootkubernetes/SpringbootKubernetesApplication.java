package com.michael.springbootkubernetes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class SpringbootKubernetesApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootKubernetesApplication.class);

	@GetMapping("/message")
	public ModelAndView displayMessage() {
		LOGGER.info("HOLA DESDE MESSAGE!!");
		return new ModelAndView("message");
	}

	@GetMapping("/list")
	public ResponseEntity<List<Map<String, String>>> list() {
		LOGGER.info("HOLA DESDE LIST!!");
		List<String> names = Arrays.asList(
				"Michael Quispe",
				"Juan Rodríguez",
				"Ana Martínez",
				"David López",
				"Sofía Pérez",
				"Carlos Sánchez",
				"Laura Gómez"
		);
		List<Map<String, String>> people = names.stream()
				.map(name -> {
					return Map.of("name", name);
				})
				.collect(Collectors.toList());
		return ResponseEntity.ok(people);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKubernetesApplication.class, args);
	}
}
