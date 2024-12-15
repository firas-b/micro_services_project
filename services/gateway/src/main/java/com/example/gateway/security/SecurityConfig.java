package com.example.gateway.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {


    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange->exchange
                        .pathMatchers("/eureka/**").authenticated()
                        .pathMatchers("/webjars/swagger-ui/**").permitAll()
                        .pathMatchers("/swagger-ui/**").permitAll()
                        .pathMatchers("v3/api-docs/swagger-config").permitAll()
                        .pathMatchers("/user-service/v3/api-docs/**").permitAll()
                        .pathMatchers("/v3/api-docs/**").permitAll()
                        .pathMatchers("/user-service/v3/api-docs").permitAll()



                        .anyExchange()
                                .authenticated()

                )
                .oauth2ResourceServer(oauth2->oauth2.jwt(Customizer.withDefaults()));
        return serverHttpSecurity.build();
    }
}
