package com.example.gateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.ws.rs.HttpMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//		return builder
//				.routes()
//				.route(r -> r.path("/user-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://USER-SERVICE"))
//				.route(r -> r.path("/blog-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://BLOG-SERVICE"))
//				//.route(r -> r.path("/product-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://product-service"))
//				.build();
//	}
}
