import org.junit.After;
import org.junit.Test;

import java.util.Random;

public class CreatePetTest {

    PetEndpoint petEndpoint = new PetEndpoint();
    Random random = new Random();

    int id = random.nextInt(10000);

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
