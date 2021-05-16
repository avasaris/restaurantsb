package ru.topjava.restaurant.to;

import lombok.Data;
import ru.topjava.restaurant.model.Dish;

import java.math.BigDecimal;

@Data
public class DishTo extends BaseTo {
    private final Integer menu_id;
    private BigDecimal price;
    private String name;

    public DishTo(Integer id, Integer menu_id, BigDecimal price, String name) {
        super(id);
        this.menu_id = menu_id;
        this.price = price;
        this.name = name;
    }

    public DishTo(Dish dish) {
        this(dish.id(), dish.getMenu().id(), dish.getPrice(), dish.getName());
    }
}
