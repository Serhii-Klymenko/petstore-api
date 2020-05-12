package test.pet;

import endPoint.PetEndpoint;
import model.Category;
import model.Pet;
import model.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class DeletePetTest {

    @Steps
    private PetEndpoint petEndpoint;
    private long petId;

    @Before
    public void createPet() {
        Pet pet = Pet.builder()
                .id(0)
                .name("Bob")
                .status(Status.AVAILABLE)
                .category(Category
                        .builder()
                        .build())
                .build();
        petId = petEndpoint.createPet(pet);
    }

    @Test
    public void deletePetById() {
        petEndpoint.deletePet(petId);
    }
}
