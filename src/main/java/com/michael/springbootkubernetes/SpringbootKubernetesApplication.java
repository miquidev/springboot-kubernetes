package com.michael.springbootkubernetes;

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
	@GetMapping("/message")
	public ModelAndView displayMessage() {
		System.out.println("HOLA DESDE MESSAGE!!");
		return new ModelAndView("message");
	}

	@GetMapping("/list")
	public ResponseEntity<List<Map<String, String>>> list() {
		System.out.println("HOLA DESDE LIST!!");
		List<String> names = Arrays.asList(
				"María García",
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
