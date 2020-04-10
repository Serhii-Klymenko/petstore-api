import org.junit.After;
import org.junit.Test;

public class CreatePetTest {

    PetEndpoint petEndpoint = new PetEndpoint();

    long id = 444;

    @After
    public void deletePet() {
        petEndpoint.deletePet(id);
    }

    @Test
    public void addNewPetToStore() {
        String body = "{\n" +
                "  \"id\": \"" + id + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"UmaTurman\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        petEndpoint.createPet(body);
    }
}
