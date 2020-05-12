package test;

import endPoint.PetEndpoint;
import model.Pet;
import model.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UpdatePetTest {

    @Steps
    private PetEndpoint petEndpoint;
    private long petId;

    @Before
    public void createPet() {
        Pet pet = new Pet(0, "Bob", Status.AVAILABLE);
        petId = petEndpoint.createPet(pet);
    }

    @After
    public void deletePet() {
        petEndpoint.deletePet(petId);
    }

    @Test
    public void updateExistingPet() {
        Pet pet = new Pet(petId, "UmaTurman", Status.PENDING);
        petEndpoint.updatePet(pet);
    }
}
