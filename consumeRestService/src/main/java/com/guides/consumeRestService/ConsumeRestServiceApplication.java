package com.guides.consumeRestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ConsumeRestServiceApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumeRestServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumeRestServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			DivisorsCount divisorsCount = restTemplate.getForObject(
				"http://localhost:8080/numberData", DivisorsCount.class);
			ObjectMapper mapper = new ObjectMapper();
			log.info(mapper.writeValueAsString(divisorsCount));
		};
	}
}
