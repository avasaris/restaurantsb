package ru.topjava.restaurant.to;

import lombok.Data;
import ru.topjava.restaurant.model.Menu;

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

    public MenuTo(Menu menu) {
        this(menu.id(), menu.getRestaurant().id(), menu.getDate());
    }
}
