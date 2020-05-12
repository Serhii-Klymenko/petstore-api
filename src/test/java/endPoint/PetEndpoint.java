package endPoint;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import model.Pet;
import model.Status;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

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
        SerenityRest.filters(new RequestLoggingFilter(LogDetail.ALL));
        SerenityRest.filters(new ResponseLoggingFilter(LogDetail.ALL));
    }

    private RequestSpecification given() {
        return SerenityRest
                .given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON);
    }

    @Step
    public long createPet(Pet pet) {
        ValidatableResponse response =
                given()
                .body(pet)
                .when()
                .post(CREATE_PET)
                .then()
                .body("name", is(pet.getName()))
                .statusCode(SC_OK);
        return response.extract().path("id");
    }

    @Step
    public ValidatableResponse getPet(long petId) {
        return given()
                .when()
                .get(GET_PET_BY_ID, petId)
                .then()
                .body("id", is(petId))
                .statusCode(SC_OK);
    }

    @Step
    public ValidatableResponse deletePet(long petId) {
        return given()
                .when()
                .delete(DELETE_PET_BY_ID, petId)
                .then()
                .body("message", is(String.valueOf(petId)))
                .statusCode(SC_OK);
    }

    @Step
    public ValidatableResponse updatePet(Pet pet) {
        return given()
                .body(pet)
                .when()
                .put(UPDATE_PET_BY_ID)
                .then()
                .body("name", is(pet.getName()))
                .statusCode(SC_OK);
    }

    @Step
    public ValidatableResponse updatePetByFormData(long petId, String petName, Status status) {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .param("name", petName)
                .param("status", status)
                .when()
                .post(UPDATE_PET_BY_FORM_DATA, petId)
                .then()
                .body("message", is(String.valueOf(petId)))
                .statusCode(SC_OK);

    }

    @Step
    public ValidatableResponse getPetByStatus(Status status) {
        return given()
                .when()
                .get(GET_PET_BY_STATUS, status)
                .then()
                .body("status", everyItem(equalTo(status)))
                .statusCode(SC_OK);

    }

    @Step
    public ValidatableResponse uploadImage(long petId, String additionalData, String fileName, int statusCode) {
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        return given()
                .contentType("multipart/form-data")
                .param("additionalMetadata", additionalData)
                .multiPart(file)
                .when()
                .post(UPLOAD_IMAGE, petId)
                .then()
                .body("message", anything(file.getName()))
                .statusCode(statusCode);
    }

}