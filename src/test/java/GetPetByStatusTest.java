import org.junit.Test;

public class GetPetByStatusTest {

    private PetEndpoint petEndpoint = new PetEndpoint();

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
