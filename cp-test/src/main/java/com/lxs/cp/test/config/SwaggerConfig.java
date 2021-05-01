package com.lxs.cp.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.lxs.cp.test"))
				.paths(PathSelectors.ant("/cp-test/**"))
				.build();
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot Test")
				.description("Testing microservices with Spring Boot")
				.version("1.0")
				.contact(new Contact("Alexis", "#", "alex200196@hotmail.it"))
				.license("")
				.licenseUrl("")
				.build();
	}
}
