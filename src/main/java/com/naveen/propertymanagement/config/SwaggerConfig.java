package com.naveen.propertymanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer{
	
	@Bean
	public Docket appApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.naveen.propertymanagement"))
				.paths((PathSelectors.regex("/.*"))).build();
		
		return docket;
	}
	
	ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Property Management System")
				.description("This is an assignment by Ranjan Panday following the cource of Zero to Hero in Spring Boot in udemy")
				.license("Udemy")
				.licenseUrl("https://www.udemy.com/course/zero-to-hero-java-springboot-jpa-mastery-with-real-project/")
				.build();
	}

}

//ui link: http://localhost:8080/swagger-ui.html