package com.cognizant.academy.qbthon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    @Bean
	public Docket qbthonApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("qbthon-api")
				.apiInfo(apiInfo()).select().paths(qbthonPaths()).build();
	}
	
	@SuppressWarnings("unchecked")
	private Predicate<String> qbthonPaths() {
		return or(regex("/api/events.*"), regex("/api/questions.*"), regex("/api/users.*"));
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("QBThon API")
				.description("QBThon API reference")
				.termsOfServiceUrl("http://academy.cognizant.com")
				.contact("bharathraj.r@cognizant.com").license("Apache License")
				.licenseUrl("bharathraj.r@cognizant.com").version("1.0").build();
	}
}