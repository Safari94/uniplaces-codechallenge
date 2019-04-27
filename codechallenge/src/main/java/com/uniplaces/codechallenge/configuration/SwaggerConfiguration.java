package com.uniplaces.codechallenge.configuration;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    @Bean
    public Docket codeChallengeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 .apis(RequestHandlerSelectors.basePackage("com.uniplaces.codechallenge.restcontroller"))
                .paths(any())
                .build()
                .apiInfo(metaData());

    }

    //Information about API
    private ApiInfo metaData() {
        String str5 = "Uniplaces - Code Challenge";
        String str4 = "This is the REST API for interact with Uniplace's Units";
        String str3 = "uniplaces.com";
        return new ApiInfoBuilder().title(str5).description(str4).termsOfServiceUrl(str3).version("1.0").build();

    }
}
