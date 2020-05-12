package model;

import lombok.Builder;
import lombok.Getter;
import java.util.Arrays;
import java.util.List;


//@Builder
@Getter
public class Pet {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Object> tags;
    private String status;


    public Pet(long id, String name, Status status) {
        this.id = id;
        this.category = new Category(3445, "Scooby");
        this.name = name;
        this.photoUrls = Arrays.asList("Photo", "Photo");
        this.status = status.getValue();
        this.tags = Arrays.asList(new Tags(65, "Lassy"));
    }
}


