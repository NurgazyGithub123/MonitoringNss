package com.example.monitoringNss.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {

    /*
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.example.monitoringNss.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaDate());
    }

    private ApiInfo metaDate(){
        return new ApiInfoBuilder()
                .title("Сервис регистрации и авторизации")
                .description("test-manager")
                .version("1.0")
                .contact(new Contact("Nurgazy","www.kg.beelineNss","nurgazy_dk@mail.ru"))
                .build();
    }

    */


        public OpenAPI customOpenAPI() {
            return new OpenAPI().info(new Info()
                    .title("VCV Swagger API")
                    .version("1.0.0"));

        }

}
