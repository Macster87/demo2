package com.example;
import com.example.entities.Vorgang;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public String helloAgain() {
        final var message = "Hello Again!";
        final var mapper = new ObjectMapper();
        final var root = mapper.createObjectNode();
        root.put("message", message);
        root.put("id", 1239123);

        final var vorgang = new Vorgang();
        vorgang.name = "Mapster";
        vorgang.persist();

        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}