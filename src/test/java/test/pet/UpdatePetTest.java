package test.pet;

import endPoint.BaseStepClass;
import endPoint.PetEndpoint;
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
public class UpdatePetTest extends BaseStepClass {

    @Steps
    private PetEndpoint petEndpoint;
    private long petId;

    @Before
    public void createPet() {
        Pet pet = Pet.builder()
                .id(0)
                .name("Bob")
                .status(PetStatus.AVAILABLE)
                .category(Category
                        .builder()
                        .build())
                .build();
        petId = petEndpoint.createPet(pet);
    }

    @After
    public void deletePet() {
        petEndpoint.deletePet(petId);
    }

    @Test
    public void updateExistingPet() {
        Pet pet = Pet.builder()
                .id(0)
                .name("UmaTurman")
                .status(PetStatus.PENDING)
                .category(Category
                        .builder()
                        .build())
                .build();
        petEndpoint.updatePet(pet);
    }
}
