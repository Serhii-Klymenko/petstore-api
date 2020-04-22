import org.junit.Before;
import org.junit.Test;

public class DeletePetTest {

    private PetEndpoint petEndpoint = new PetEndpoint();
    private long petId;

    @Before
    public void createPet() {
        Pet pet = new Pet(0, "Bob", Status.AVAILABLE);
        petId = petEndpoint.createPet(pet);
    }

    @Test
    public void deletePetById() {
        petEndpoint.deletePet(petId);
    }
}
