package test.store;

import endPoint.PetEndpoint;
import model.Order;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

@RunWith(SerenityRunner.class)
public class CreateOrderTest {

    @Steps
    private PetEndpoint petEndpoint;
    private int orderId;

    @After
    public void deleteOrder() {
        petEndpoint.deleteOrder(orderId);
    }

    @Test
    public void createOrder() {
        Random random = new Random();
        Order order = Order.builder()
                .id(random.nextInt((10 - 1) + 1) + 1)
                .petId(56)
                .quantity(1)
                .shipDate(System.currentTimeMillis())
                .status("placed")
                .complete(true)
                .build();
        orderId = petEndpoint.createOrder(order);
    }
}
