package model;

public enum OrderStatus {
    PLACED("placed");

    private final String orderStatus;

    OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatus() {
        return orderStatus;
    }
}
