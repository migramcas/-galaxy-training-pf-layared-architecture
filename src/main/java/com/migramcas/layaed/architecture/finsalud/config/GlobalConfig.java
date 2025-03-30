package com.migramcas.layaed.architecture.finsalud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GlobalConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
