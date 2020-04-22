import org.junit.After;
import org.junit.Test;

public class CreatePetTest {

    private PetEndpoint petEndpoint = new PetEndpoint();
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
