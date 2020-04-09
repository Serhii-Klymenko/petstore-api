import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.*;
import static org.hamcrest.Matchers.is;

public class CreatePetTest {

    int id = 444;

    @Before
    public void before() {
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec.setBaseUri("https://petstore.swagger.io/v2");
        spec.addHeader("Content-Type", "application/json");
        spec.log(ALL);
        RestAssured.requestSpecification = spec.build();

        ResponseSpecBuilder response = new ResponseSpecBuilder();
        response.expectStatusCode(200);
        RestAssured.responseSpecification = response.build();
    }

    @After
    public void after() {
        given()
                .when()
                .delete("/pet/{id}", id)
                .then()
                .log()
                .all()
                .body("message", is(String.valueOf(id)));
    }

    @Test
    public void addNewPetToStore() {
        String body = "{\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"UmaTurman\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        given()
                .body(body)
                .when()
                .post("/pet")
                .then()
                .log()
                .all()
                .body("id", is(id));
    }
}
