import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class DeletePetTest {

    long petId;

    @Before
    public void before2() {
        RequestSpecBuilder spec = new RequestSpecBuilder();
        spec.setBaseUri("https://petstore.swagger.io/v2");
        spec.addHeader("Content-Type", "application/json");
        spec.log(ALL);
        RestAssured.requestSpecification = spec.build();

        ResponseSpecBuilder response = new ResponseSpecBuilder();
        RestAssured.responseSpecification = response.build();
    }

    @Before
    public void before1() {
        int id = 0;
        String body = "{\n" +
                "  \"id\": \""+ id +"\",\n" +
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
        ValidatableResponse response = given()
                .body(body)
                .when()
                .post("/pet")
                .then()
                .log()
                .all();

        petId = response.extract().path("id");
        System.out.println(petId);
    }

    @After
    public void after() {
        given()
                .when()
                .get("/pet/{id}", petId)
                .then()
                .log()
                .all()
                .statusCode(404);
    }


    @Test
    public void deletePetById() {
        given()
                .when()
                .delete("/pet/{id}", petId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .body("message", is(String.valueOf(petId)));
    }
}
