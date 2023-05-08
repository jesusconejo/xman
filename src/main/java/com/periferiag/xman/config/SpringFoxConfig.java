package com.periferiag.xman.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Value("${info.build-timestamp}")
    private String buildTime;
    private static final String PACKAGE_CONTROL = "com.periferiag.xman";



    @Bean
    public Docket api() {
        Set<String> setA = new HashSet<String>();
        setA.add("application/json");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROL))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()).produces(setA).consumes(setA);
    }
    private ApiInfo apiInfo() {
        return new ApiInfo("Api Rest para Charles Javier", "Identificar si la persona es mutante o no.", buildTime,
                "Terms of service", new Contact("CACHE", "XMAN", "mail@ssoc.com"), "License of API", "API license URL",
                Collections.emptyList());

    }
}
