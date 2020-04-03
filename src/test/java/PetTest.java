import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.*;
import static org.hamcrest.Matchers.*;

public class PetTest {

int id = 228;

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

        addNewPetToStore();
    }

    @After
    public void after() {
        deletePetById();
    }

    @Test
    public void getPetById() {
        given()
                .when()
                .get("/pet/{id}", id)
                .then()
                .log()
                .all()
                .body("id", anyOf(is(id), is("available")));
    }

    @Test
    public void getPetByStatusAvailable() {
        String status = "available";
        given()
                .when()
                .get("/pet/findByStatus?status={status}", status)
                .then()
                .log()
                .all()
                .body("status", everyItem(equalTo(status)));
    }

    @Test
    public void getPetByStatusSold() {
        String status = "sold";
        given()
                .when()
                .get("/pet/findByStatus?status={status}", status)
                .then()
                .log()
                .all()
                .body("status", everyItem(equalTo(status)));
    }

    @Test
    public void getPetByStatusPending() {
        String status = "pending";
        given()
                .when()
                .get("/pet/findByStatus?status={status}", status)
                .then()
                .log()
                .all()
                .body("status", everyItem(equalTo(status)));
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

    @Test
    public void updatePetByDataForm() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .param("name", "Jackie")
                .param("status", "Sold")
                .when()
                .post("/pet/{id}", id)
                .then()
                .log()
                .all()
                .body("message", is(String.valueOf(id)));
    }

    @Test
    public void updateExistingPet() {
        String body = "{\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"Homer\",\n" +
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
                .put("/pet")
                .then()
                .log()
                .all()
                .body("name", anyOf(is(id), is("Homer")));
    }
    @Test
    public void deletePetById() {
        given()
                .when()
                .delete("/pet/{id}", id)
                .then()
                .log()
                .all()
                .body("message", is(String.valueOf(id)));
    }
}
