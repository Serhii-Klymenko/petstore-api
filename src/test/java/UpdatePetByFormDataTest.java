import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UpdatePetByFormDataTest {

    private PetEndpoint petEndpoint = new PetEndpoint();
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
    public void updatePetByDataForm() {
        petEndpoint.updatePetByFormData(petId, "Jackie", Status.SOLD);
    }

}
