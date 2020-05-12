package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {
    private int id;
    private long petId;
    private int quantity;
    private long shipDate;
    private String status;
    private boolean complete;
}