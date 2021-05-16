package ru.topjava.restaurant.to;

import lombok.Data;
import ru.topjava.restaurant.model.Restaurant;

@Data
public class RestaurantTo extends BaseTo {
    private final String name;
//    private final Set<MenuTo> menu;

//    public RestaurantTo(Integer id, String name, Set<MenuTo> menu) {
   public RestaurantTo(Integer id, String name) {
        super(id);
        this.name = name;
//        this.menu = menu;
    }

    public RestaurantTo(Restaurant r) {
        this(r.id(), r.getName());
//        this(r.id(), r.getName(), r.getMenus().stream().map(MenuTo::new).collect(Collectors.toSet()));
    }
}
