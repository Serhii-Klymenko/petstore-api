/*
package test;

import endPoint.PetEndpoint;
import model.Pet;
import model.Status;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class GetPetTest {

    @Steps
    private PetEndpoint petEndpoint;
    private long petId;

    @Before
    public void createPet() {
        //Pet pet = new Pet(0, "Bob", Status.AVAILABLE);
       */
/* Pet pet = Pet.builder()
                .id()
                .name()
                .status()
                .build();*//*

        Pet pet = Pet.builder()
                .id("0")
                .name("chupacabra")
                .status(Status.AVAILABLE)
                //.category(new Category("0", "NEW"))
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
    public void getPetById() {
        petEndpoint.getPet(petId);
    }
}*/
