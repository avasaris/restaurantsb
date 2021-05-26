package ru.topjava.restaurant.to;

import lombok.Data;

@Data
public class VoteTo {
    private final Integer restaurantId;
    private final Long counter;

    public VoteTo(Integer restaurantId, Long counter) {
        this.restaurantId = restaurantId;
        this.counter = counter;
    }
}
