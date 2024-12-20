package com.example.userservice.keycloak;


import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakClientConfig {

    @Bean
    public Keycloak keycloak(){


        return KeycloakBuilder. builder()
                              .serverUrl("http://localhost:8080")
                                .realm("microservices")
                                .clientId("microservices")
                                .username("admin")
                                .password("100100f")
                                .clientSecret("lHtcaGGL8XJYZMLhGsvygOwfu2KpTwxH")
                                .build();

    }



}
