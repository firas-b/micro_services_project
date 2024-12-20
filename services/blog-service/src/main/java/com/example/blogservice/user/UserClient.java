package com.example.blogservice.user;


import com.example.blogservice.config.FeignRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * I used this FeignRequestInterceptor class  to inject the jwt access token issued by the
 * keycloak server into  every feign request header. This is for handling the internal microservices
 * communication security without invoking any other approaches (You can use Api-keys , mutual-TLS and
 * service mesh to do the job ). Better to define the FeignRequestInterceptor  as a bean
 * to work along with every feign-client you define in your app, in a way  there is no need to
 * call this class in every implementation of the  @FeignClient InInterface .
 */


@FeignClient(
        name = "user-service",
        url = "${application.config.user-url}",
        configuration = FeignRequestInterceptor.class

)
public interface UserClient {
    @GetMapping("/{user-id}")
    Optional<UserResponse>findUserById(@PathVariable("user-id") String userId);


}