import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

public class DeletePetTest {

    private PetEndpoint petEndpoint = new PetEndpoint();
    private long petId;

    @Before
    public void createPet() {
        Pet pet = new Pet(0, "Bob", "available");
        ValidatableResponse response = petEndpoint.createPet(pet);
        petId = response.extract().path("id");
    }

    @Test
    public void deletePetById() {
        petEndpoint.deletePet(petId);
    }
}
