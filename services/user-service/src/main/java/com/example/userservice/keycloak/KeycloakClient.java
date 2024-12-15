package com.example.userservice.keycloak;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakClient {

   private final  Keycloak keycloak;


   public List<?> getusers() {
      return  keycloak.realm("microservices").users().list();

   }
}
