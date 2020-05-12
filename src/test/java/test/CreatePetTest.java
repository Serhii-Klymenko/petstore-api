package test;

import endPoint.PetEndpoint;
import model.Pet;
import model.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

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
        Pet pet = new Pet(0, "Bob", Status.SOLD);
        petId = petEndpoint.createPet(pet);
    }
}
