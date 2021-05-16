package ru.topjava.restaurant.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.MenuRepository;
import ru.topjava.restaurant.to.DishTo;
import ru.topjava.restaurant.to.MenuTo;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/menu")
@AllArgsConstructor
@Slf4j
public class DishRestController {
    private final DishRepository dishRepository;
    private final MenuRepository menuRepository;

    @GetMapping(value = "/{menuId}/dish", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DishTo> findAllDishesForMenu(@PathVariable Integer menuId) {
        log.info("find all dishes for menu {}", menuId);
        return dishRepository.findByMenuId(menuId).stream().map(DishTo::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{menuId}/dish/{dishId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuTo findMenuByIdForRestaurant(@PathVariable Integer menuId,
                                            @PathVariable Integer dishId) {
        log.info("find dish {} for menu {}", dishId, menuId);
        return new MenuTo(dishRepository.findByMenuIdAndId(menuId, dishId));
    }

    @PostMapping(value = "/{menuId}/dish", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public DishTo createDish(@PathVariable Integer menuId, @Valid @RequestBody Dish dish) {
        log.info("add dish {} for menu {}", dish, menuId);
        return menuRepository.findById(menuId)
                .map(menu -> {
                    dish.setMenu(menu);
                    dishRepository.save(dish);
                    return new DishTo(dish);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Menu ID " + menuId + "not found"));
    }

}
