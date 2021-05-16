package ru.topjava.restaurant.to;

import lombok.Data;
import ru.topjava.restaurant.model.Restaurant;

@Data
public class RestaurantTo extends BaseTo {
    private final String name;

    public RestaurantTo(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public RestaurantTo(Restaurant r) {
        this(r.id(), r.getName());
    }
}
