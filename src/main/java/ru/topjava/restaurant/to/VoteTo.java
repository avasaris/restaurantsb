package ru.topjava.restaurant.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.topjava.restaurant.model.Restaurant;

@Data
@AllArgsConstructor
public class VoteTo {
    private final Integer restaurantId;
    private final Integer counter;

}
