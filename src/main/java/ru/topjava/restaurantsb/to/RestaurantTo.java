package ru.topjava.restaurantsb.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.topjava.restaurantsb.model.Restaurant;

import java.util.Set;
import java.util.stream.Collectors;

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
