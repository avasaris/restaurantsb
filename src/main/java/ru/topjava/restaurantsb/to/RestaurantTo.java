package ru.topjava.restaurantsb.to;

import lombok.Data;

@Data
public class RestaurantTo extends BaseTo {
    private final String name;

    public RestaurantTo(Integer id, String name) {
        super(id);
        this.name = name;
    }
}
