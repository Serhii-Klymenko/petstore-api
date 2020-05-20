package endPoint;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import model.Order;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

public class StoreEndpoint {

    private final static String CREATE_ORDER = "/store/order";
    private final static String GET_ORDER_BY_ID = "/store/order/{id}";
    private final static String DELETE_ORDER_BY_ID = "/store/order/{id}";
    private final static String GET_INVENTORIES_BY_STATUS = "/store/inventory";

    private RequestSpecification given() {
        return SerenityRest
                .given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON);
    }

    @Step
    public int createOrder(Order order) {
        ValidatableResponse response =
                given()
                        .body(order)
                        .when()
                        .post(CREATE_ORDER)
                        .then()
                        .body("id", is(order.getId()))
                        .statusCode(SC_OK);
        return response.extract().path("id private RequestSpecification given() {\n" +
                "        return SerenityRest\n" +
                "                .given()\n" +
                "                .baseUri(\"https://petstore.swagger.io/v2\")\n" +
                "                .contentType(ContentType.JSON);\n" +
                "    }");
    }

    @Step
    public ValidatableResponse getOrder(int orderId) {
        return given()
                .when()
                .get(GET_ORDER_BY_ID, orderId)
                .then()
                .body("id", is(orderId))
                .statusCode(SC_OK);
    }

    @Step
    public ValidatableResponse deleteOrder(int orderId) {
        return given()
                .when()
                .delete(DELETE_ORDER_BY_ID, orderId)
                .then()
                .body("message", is(String.valueOf(orderId)))
                .statusCode(SC_OK);
    }

    @Step
    public ValidatableResponse getInventories() {
        return given()
                .when()
                .get(GET_INVENTORIES_BY_STATUS)
                .then()
                .statusCode(SC_OK);
    }
}
