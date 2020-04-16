import org.junit.Test;

public class GetPetByStatusTest {

    PetEndpoint petEndpoint = new PetEndpoint();

    @Test
    public void getPetByStatusAvailable() {
        String status = "available";
        petEndpoint.getPetByStatus(status);
    }

    @Test
    public void getPetByStatusSold() {
        String status = "sold";
        petEndpoint.getPetByStatus(status);
    }

    @Test
    public void getPetByStatusPending() {
        String status = "pending";
        petEndpoint.getPetByStatus(status);
    }
}
