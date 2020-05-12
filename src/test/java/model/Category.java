package model;

import lombok.Builder;
import lombok.Getter;
@Builder
@Getter
public class Category {
    private long id;
    private String name;
}