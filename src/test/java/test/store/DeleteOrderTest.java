package test.store;

import endPoint.BaseStepClass;
import endPoint.PetEndpoint;
import endPoint.StoreEndpoint;
import model.Category;
import model.Order;
import model.OrderStatus;
import model.Pet;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static model.PetStatus.AVAILABLE;

@RunWith(SerenityRunner.class)
public class DeleteOrderTest extends BaseStepClass {

    @Steps
    private StoreEndpoint storeEndpoint;
    private int orderId;

    @Steps
    private PetEndpoint petEndpoint;
    private long petId;

    @Before

    public void createPrecondition() {
        Pet pet = Pet.builder()
                .id(0)
                .name("Bob")
                .status(AVAILABLE)
                .category(Category
                        .builder()
                        .build())
                .build();
        petId = petEndpoint.createPet(pet);

        Random random = new Random();
        Order order = Order.builder()
                .id(random.nextInt((10 - 1) + 1) + 1)
                .petId(petId)
                .quantity(1)
                .shipDate(System.currentTimeMillis())
                .status(OrderStatus.PLACED)
                .complete(true)
                .build();
        orderId = storeEndpoint.createOrder(order);
    }

    @After
    public void getOrder() {
        storeEndpoint.getOrder(orderId);
    }

    @Test
    public void deleteOrder() {
        storeEndpoint.deleteOrder(orderId);
    }
}