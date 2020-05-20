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

import static org.apache.http.HttpStatus.SC_OK;

@RunWith(SerenityParameterizedRunner.class)
public class UploadImageTest {

    @Steps
    private PetEndpoint petEndpoint;

    private long petId;
    private final String fileName;

    public UploadImageTest(String fileName) {
        this.fileName = fileName;
    }

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"File-example_JPEG_55_kB.jpeg"},
                {"File-example_JPG_5MB.jpg"},
                {"File_example_PNG_3MB.png"},
                {"File-example_PDF_55_MB.pdf"},
        });
    }

    @Before
    public void createPet() {
        Pet pet = Pet.builder()
                .id(0)
                .name("Bob")
                .status(PetStatus.AVAILABLE)
                .category(Category
                        .builder()
                        .build())
                .build();
        petId = petEndpoint.createPet(pet);
    }

    @After
    public void deletePet() {
        petEndpoint.deletePet(petId);
    }

    @Test
    public void uploadImage() {
        petEndpoint.uploadImage(petId, "Some_Text", fileName, SC_OK);
    }
}
