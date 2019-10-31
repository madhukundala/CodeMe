package com.me.interview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket trasactionsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.me.interview.controller"))
                .paths(regex("/api.*"))
                .build().apiInfo(metaData());
    }

    /**
     * @return
     */
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "CodeMe Challenge REST API",
                "CodeMe Challenge REST API for ME Bank",
                "1.0",
                "Terms of service",
                "Madhu Kundala",
                "https://www.apache.org/licenses/LICENSE-2.0", "");
        return apiInfo;
    }
}