package endPoint;

import io.restassured.response.ValidatableResponse;
import model.Order;
import net.thucydides.core.annotations.Step;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

public class StoreEndpoint extends BaseStepClass{

    private final static String CREATE_ORDER = "/store/order";
    private final static String GET_ORDER_BY_ID = "/store/order/{id}";
    private final static String DELETE_ORDER_BY_ID = "/store/order/{id}";
    private final static String GET_INVENTORIES_BY_STATUS = "/store/inventory";

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
        return response.extract().path("id");
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
