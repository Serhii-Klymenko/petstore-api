public enum Status {

    AVAILABLE("available"),
    SOLD("sold"),
    PENDING("pending");

    private String value;

    public String getValue() {
        return this.value;
    }

    Status(String value) {
        this.value = value;
    }
}