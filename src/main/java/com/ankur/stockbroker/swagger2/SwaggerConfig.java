package com.ankur.stockbroker.swagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket postsApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
        .apiInfo(apiInfo()).select().paths(postPaths()).build();
  }

  private Predicate<String> postPaths() {
    return or(regex("/api/.*"), regex("/db-init"));
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Stock Broker API")
        .description("Stock Broker API reference for developers")
        .license("Stock Broker License")
        .licenseUrl("help@stockbroker.com").version("1.0").build();
  }

}
