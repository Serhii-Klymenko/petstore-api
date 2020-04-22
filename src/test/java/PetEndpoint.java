import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;

public class PetEndpoint {

    private final static String CREATE_PET = "/pet";
    private final static String GET_PET_BY_ID = "/pet/{id}";
    private final static String DELETE_PET_BY_ID = "/pet/{id}";
    private final static String UPDATE_PET_BY_ID = "/pet";
    private final static String UPDATE_PET_BY_FORM_DATA = "/pet/{id}";
    private final static String GET_PET_BY_STATUS = "/pet/findByStatus?status={status}";
    private final static String UPLOAD_IMAGE = "pet/{id}/uploadImage";

    static {
        RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL));
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL));
    }

    private RequestSpecification given() {
        return RestAssured
                .given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON);
    }

    public ValidatableResponse createPet(Pet pet) {
        return given()
                .body(pet)
                .when()
                .post(CREATE_PET)
                .then()
                .statusCode(SC_OK);
    }

    public ValidatableResponse getPet(long petId) {
        return given()
                .when()
                .get(GET_PET_BY_ID, petId)
                .then()
                .body("id", anyOf(is(petId), is(Status.AVAILABLE)))
                .statusCode(SC_OK);
    }

    public ValidatableResponse deletePet(long petId) {
        return given()
                .when()
                .delete(DELETE_PET_BY_ID, petId)
                .then()
                .body("message", is(String.valueOf(petId)))
                .statusCode(SC_OK);
    }

    public ValidatableResponse updatePet(Pet pet) {
        return given()
                .body(pet)
                .when()
                .put(UPDATE_PET_BY_ID)
                .then()
                .body("name", anyOf(is(pet.getId()), is(pet.getName())))
                .statusCode(SC_OK);
    }

    public ValidatableResponse updatePetByFormData(long petId) {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .param("name", "Jackie")
                .param("status", Status.SOLD)
                .when()
                .post(UPDATE_PET_BY_FORM_DATA, petId)
                .then()
                .body("message", is(String.valueOf(petId)))
                .statusCode(SC_OK);

    }

    public ValidatableResponse getPetByStatus(String status) {
        return given()
                .when()
                .get(GET_PET_BY_STATUS, status)
                .then()
                .body("status", everyItem(equalTo(status)))
                .statusCode(SC_OK);

    }

    public ValidatableResponse uploadImage(long petId, String path) {
        File file = new File(path);
        return given()
                .contentType("multipart/form-data")
                .param("additionalMetadata", "Some_text")
                .multiPart(file)
                .when()
                .post(UPLOAD_IMAGE, petId)
                .then()
                .body("message", anything(file.getName()))
                .statusCode(SC_OK);
    }

}