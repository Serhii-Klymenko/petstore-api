import java.util.Arrays;
import java.util.List;

public class Pet {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Object> tags;
    private String status;


    public Pet(long id, String name, String status) {
        this.id = id;
        this.category = new Category(3445, "Scooby");
        this.name = name;
        this.photoUrls = Arrays.asList("Photo", "Photo");
        this.status = status;
        this.tags = Arrays.asList(new Tags(65, "Lassy"));
    }

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<Object> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }
}


