package com.apni_dukan;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configurable
@EnableSwagger2
public class Swagger {

	@Bean
	public Docket docket() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.apni_dukan")).build();

	}
}
//http://localhost:8080/swagger-ui.html#/

/*<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		*/
