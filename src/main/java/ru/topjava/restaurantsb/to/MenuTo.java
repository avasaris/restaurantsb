package ru.topjava.restaurantsb.to;

import lombok.Data;
import ru.topjava.restaurantsb.model.Menu;
import ru.topjava.restaurantsb.model.Restaurant;

import java.time.LocalDate;

@Data
public class MenuTo extends BaseTo {
    private final int restaurant_id;
    private final LocalDate date;

    public MenuTo(Integer id, int restaurant_id, LocalDate date) {
        super(id);
        this.restaurant_id = restaurant_id;
        this.date = date;
    }

    public MenuTo(Menu r) {
        this(r.id(), r.getRestaurant().id(), r.getDate());
    }
}
