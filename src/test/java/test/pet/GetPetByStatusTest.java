package test.pet;

import endPoint.PetEndpoint;
import model.Category;
import model.Pet;
import model.Status;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class GetPetByStatusTest {

    @Steps
    private PetEndpoint petEndpoint;
    private long petId;
    private final Status status;

    public GetPetByStatusTest(Status status) {
        this.status = status;
    }

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {Status.AVAILABLE},
                {Status.SOLD},
                {Status.PENDING},
        });
    }

    @Before
    public void createPet() {
        Pet pet = Pet.builder()
                .id(0)
                .name("Bob")
                .status(Status.AVAILABLE)
                .category(Category.builder()
                        .id(34)
                        .name("Joe")
                        .build())
                .build();
        petId = petEndpoint.createPet(pet);
    }

    @After
    public void deletePet() {
        petEndpoint.deletePet(petId);
    }

    @Test
    public void getPetByStatus() {
        petEndpoint.getPetByStatus(status);
    }
}
