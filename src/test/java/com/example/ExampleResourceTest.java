package com.example;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;

import com.example.entities.Vorgang;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given().when().get("/hello").then().statusCode(200).body(
            "message", is("Hello Again!"), 
            "id", is(1239123)
        );
    }

    @Test
    @Transactional
    public void testAnlegenEinesVorgangs() {
        var vorgang = new Vorgang();
        vorgang.name = "asdkawe";
        vorgang.persist();
    }

}