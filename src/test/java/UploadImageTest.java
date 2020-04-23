import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class UploadImageTest {
    private PetEndpoint petEndpoint = new PetEndpoint();
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
    public void uploadImageJpeg() {
        petEndpoint.uploadImage(petId, "Some_Text", "File-example_JPEG_900_kB.jpeg", SC_OK);
    }

    @Test
    public void uploadImageJpg() {
        petEndpoint.uploadImage(petId, "Some_Text", "File-example_JPG_5MB.jpg", SC_OK);
    }

    @Test
    public void uploadImagePng() {
        petEndpoint.uploadImage(petId, "Some_Text", "File_example_PNG_3MB.png", SC_OK);
    }

    //Negative
    @Test
    public void uploadImageGif() {
        petEndpoint.uploadImage(petId, "Some_Text", "File_example_GIF_1MB.gif", SC_BAD_REQUEST);
    }

    @Test
    public void uploadImagePdf() {
        petEndpoint.uploadImage(petId, "Some_Text", "File-example_PDF_500_kB.pdf", SC_BAD_REQUEST);
    }

}
