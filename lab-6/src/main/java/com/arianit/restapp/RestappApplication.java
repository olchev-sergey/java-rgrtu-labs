package com.arianit.restapp;

import com.arianit.restapp.domain.Hobby;
import com.arianit.restapp.service.HobbiesService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class RestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestappApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(HobbiesService hobbiesService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();

            TypeReference<List<Hobby>> typeReference = new TypeReference<List<Hobby>>(){};

            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/hobbies.json");
            try {

                List<Hobby> gears = mapper.readValue(inputStream, typeReference);
                hobbiesService.saveAll(gears);
                System.out.println("Hobby data successfully saved!");
            } catch (IOException e) {
                System.out.println("Unable to save hobby data: " + e.getMessage());
            }
        };
    }
}
