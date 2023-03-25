package com.ars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SawaggerConfig {

	//define a bean to configure swagger
    @Bean
    public Docket Api() {
    	
    	//create a new Docket instance ,using swagger2
    	return new Docket(DocumentationType.SWAGGER_2)     
    			 
    			//use controller methods in the API
    		      .select().apis(RequestHandlerSelectors.any())
    		      
    		      //path in tha API
    		      .paths(PathSelectors.any()).build();
    }
}
