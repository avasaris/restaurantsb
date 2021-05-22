package ru.topjava.restaurant.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Menu;
import ru.topjava.restaurant.repository.MenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.to.MenuTo;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/restaurant")
@AllArgsConstructor
@Slf4j
public class MenuRestController {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @GetMapping(value = "/{restaurantId}/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MenuTo> findAllMenusForRestaurant(@PathVariable Integer restaurantId) {
        log.info("find all menus for restaurant {}", restaurantId);
        return menuRepository.findByRestaurantId(restaurantId).stream().map(MenuTo::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{restaurantId}/menu/{menuId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MenuTo findMenuByIdForRestaurant(@PathVariable Integer restaurantId,
                                            @PathVariable Integer menuId) {
        log.info("find menu {} for restaurant {}", menuId, restaurantId);
        return new MenuTo(menuRepository.findByRestaurantIdAndId(restaurantId, menuId));
    }

    @PostMapping(value = "/{restaurantId}/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public MenuTo createMenu(@PathVariable Integer restaurantId, @Valid @RequestBody Menu menu) {
        log.info("add menu {} for restaurant {}", menu, restaurantId);
        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> {
                    menu.setRestaurant(restaurant);
                    menuRepository.save(menu);
                    return new MenuTo(menu);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant ID " + restaurantId + "not found"));
    }
}
