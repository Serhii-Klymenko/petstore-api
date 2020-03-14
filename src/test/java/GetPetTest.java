import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetPetTest {

    @Test
    public void getPetById() {
        int id = 563;
        given()
                .log()
                .all()
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .get("/pet/{id}", id)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void getFindByStatusAvailable() {
        String status = "available";
        given()
                .log()
                .all()
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .get("/pet/findByStatus?status={status}", status)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void getFindByStatusSold() {
        String status = "pending";
        given()
                .log()
                .all()
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .get("/pet/findByStatus?status={status}", status)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void getFindByStatusPending() {
        String status = "sold";
        given()
                .log()
                .all()
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .get("/pet/findByStatus?status={status}", status)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void addNewPetToStore() {
        String body = "{\n" +
                "  \"id\": 4564,\n" +
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
                .log()
                .all()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/pet")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void updatePetByDataForm() {
        int id = 4564;
        given()
                .log()
                .all()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType("application/x-www-form-urlencoded")
                .param("name", "Jackie")
                .param("status", "Sold")
                .when()
                .post("/pet/{id}", id)
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void updateExistingPet() {
        String body = "{\n" +
                "  \"id\": 455,\n" +
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
                .log()
                .all()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/pet")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @Test
    public void deletePetById() {
        int id = 463;
        given()
                .log()
                .all()
                .baseUri("https://petstore.swagger.io/v2")
                .when()
                .delete("/pet/{id}", id)
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
