package com.migramcas.layaed.architecture.finsalud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
		return new OpenAPI()
				.info(new Info()
						.title("FinSalud")
						.version(appVersion)
						.description("Servicios de salud financieros")
						.termsOfService("http://swagger.io/terms/")
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")
						)
				);
	}

}
