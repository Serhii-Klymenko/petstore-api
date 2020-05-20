package test.store;

import endPoint.PetEndpoint;
import endPoint.StoreEndpoint;
import model.Category;
import model.Pet;
import model.PetStatus;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class GetInventoriesByPetStatusTest {

    @Steps
    private PetEndpoint petEndpoint;
    private long petId;

    @Steps
    private StoreEndpoint storeEndpoint;

    @Before
    public void createPet() {
        Pet pet = Pet.builder()
                .id(0)
                .name("Bob")
                .status(PetStatus.AVAILABLE)
                .category(Category.builder()
                        .id(34)
                        .name("Joe")
                        .build())
                .build();
        petId = petEndpoint.createPet(pet);
    }

   @After
    public void deletePet() {
        petEndpoint.deletePet(petId);
    }

    @Test
    public void getInventories() {
        storeEndpoint.getInventories();
    }
}


