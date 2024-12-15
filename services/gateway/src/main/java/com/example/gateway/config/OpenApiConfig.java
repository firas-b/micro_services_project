package com.example.gateway.config;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Your API")
                        .version("1.0.0")
                        .description("API documentation with OAuth2 Password Grant"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("oauth2", new SecurityScheme()
                                .type(SecurityScheme.Type.OAUTH2)
                                .description("OAuth2 Password Grant")
                                .flows(new OAuthFlows()
                                        .password(new OAuthFlow()
                                                .tokenUrl("http://localhost:8080/realms/microservices/protocol/openid-connect/token")))))

                .addSecurityItem(new SecurityRequirement().addList("oauth2"));
    }
}
