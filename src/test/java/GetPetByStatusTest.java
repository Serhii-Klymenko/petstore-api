import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;

public class GetPetByStatusTest {

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
}
