/**
 * 
 */
package com.optily.OptimalBudgeting;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shaik
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.optily.OptimalBudgeting.controller"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET,
						Arrays.asList(
								new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build(),
								new ResponseMessageBuilder().code(403).message("Forbidden!!!").build()))
				.globalResponseMessage(RequestMethod.POST,
				Arrays.asList(
						new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build(),
						new ResponseMessageBuilder().code(403).message("Forbidden!!!").build()))
				.globalResponseMessage(RequestMethod.PUT,
				Arrays.asList(
						new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build(),
						new ResponseMessageBuilder().code(403).message("Forbidden!!!").build()));
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("Optily Campaign budgeting APIs", "The following APIs are for Optily Campaign Budgeting Application.",
				"Optily"
				, null
				,new Contact("Optily Team", "", "nyamathhh@gmail.com")
				,null
				,null
				,Collections.emptyList());
	}
}
