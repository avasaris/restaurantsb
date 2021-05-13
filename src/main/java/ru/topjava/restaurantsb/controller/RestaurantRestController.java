package ru.topjava.restaurantsb.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.restaurantsb.repository.RestaurantRepository;

@RestController
@RequestMapping(value = "/api/restaurant")
@AllArgsConstructor
@Slf4j
public class RestaurantRestController {
    private final RestaurantRepository restaurantRepository;

}
