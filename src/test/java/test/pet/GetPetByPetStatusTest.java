package test.pet;

import endPoint.PetEndpoint;
import model.Category;
import model.Pet;
import model.PetStatus;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static model.PetStatus.*;

@RunWith(SerenityParameterizedRunner.class)
public class GetPetByPetStatusTest {

    @Steps
    private PetEndpoint petEndpoint;
    private long petId;
    private final PetStatus status;

    public GetPetByPetStatusTest(PetStatus status) {
        this.status = status;
    }

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {AVAILABLE},
                {SOLD},
                {PENDING},
        });
    }

    @Before
    public void createPet() {
        Pet pet = Pet.builder()
                .id(0)
                .name("Bob")
                .status(AVAILABLE)
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
