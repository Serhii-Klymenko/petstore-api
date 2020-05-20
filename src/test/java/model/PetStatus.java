package model;

public enum PetStatus {

    AVAILABLE("available"),
    SOLD("sold"),
    PENDING("pending");

    private String value;

    public String getValue() {
        return this.value;
    }

    PetStatus(String value) {
        this.value = value;
    }

}