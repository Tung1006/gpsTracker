package com.huyennt.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {
    @Bean
    OpenAPI insmartOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api")
                        .description("Thông báo")
                        .version("0.0.1")
                );
    }
}
