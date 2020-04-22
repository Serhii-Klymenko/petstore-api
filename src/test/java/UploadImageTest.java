import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UploadImageTest {
    private PetEndpoint petEndpoint = new PetEndpoint();
    private long petId;

    @Before
    public void createPet() {
        Pet pet = new Pet(0, "Bob", Status.AVAILABLE);
        ValidatableResponse response = petEndpoint.createPet(pet);
        petId = response.extract().path("id");
    }

    @After
    public void deletePet() {
        petEndpoint.deletePet(petId);
    }

    @Test
    public void uploadImage() {
        petEndpoint.uploadImage(petId,"src/test/data/Image11.jpg");
    }
}
