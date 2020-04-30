import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class GetPetByStatusTest {

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
    public void getPetByStatusAvailable() {
        petEndpoint.getPetByStatus(Status.AVAILABLE);
    }

    @Test
    public void getPetByStatusSold() {
        petEndpoint.getPetByStatus(Status.SOLD);
    }

    @Test
    public void getPetByStatusPending() {
        petEndpoint.getPetByStatus(Status.PENDING);
    }
}
