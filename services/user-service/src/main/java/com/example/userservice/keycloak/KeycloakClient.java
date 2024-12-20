package com.example.userservice.keycloak;


import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;

import org.springframework.stereotype.Service;



import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakClient {

   private final Keycloak keycloak;



   public List<UserRepresentation> getusers() {
      List<UserRepresentation> response = keycloak.realm("microservices").users().list();
      keycloak.realm("microservices").roles();
      keycloak.tokenManager().logout();
      return response;
   }

   public Response addUser(UserRepresentation user) {
      Response  result = keycloak.realm("microservices").users().create(user);
       keycloak.tokenManager().logout();
      return result;
   }



}