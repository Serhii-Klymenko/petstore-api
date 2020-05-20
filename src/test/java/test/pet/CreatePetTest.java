package test.pet;

import endPoint.PetEndpoint;
import model.Category;
import model.Pet;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import static model.PetStatus.SOLD;

@RunWith(SerenityRunner.class)
public class CreatePetTest {

    @Steps
    private PetEndpoint petEndpoint;
    private long petId;

    @After
    public void deletePet() {
        petEndpoint.deletePet(petId);
    }

    @Test
    public void addNewPetToStore() {
        Pet pet = Pet.builder()
                .id(0)
                .name("Bob")
                .status(SOLD)
                .category(Category
                        .builder()
                        .build())
                .build();
        petId = petEndpoint.createPet(pet);
    }
}
