package ru.topjava.restaurantsb.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.topjava.restaurantsb.error.IllegalRequestDataException;
import ru.topjava.restaurantsb.model.Restaurant;
import ru.topjava.restaurantsb.model.Role;
import ru.topjava.restaurantsb.model.User;
import ru.topjava.restaurantsb.repository.RestaurantRepository;
import ru.topjava.restaurantsb.to.RestaurantTo;
import ru.topjava.restaurantsb.util.ValidationUtil;

import javax.validation.Valid;
import java.net.URI;
import java.util.EnumSet;
import java.util.List;

@RestController
@RequestMapping(value = "/api/restaurant")
@AllArgsConstructor
@Slf4j
public class RestaurantRestController {
    private final RestaurantRepository restaurantRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantTo> getAll() {
        return restaurantRepository.findAllTo();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantTo getById(@PathVariable Integer id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalRequestDataException("Illegal id for restaurant search"));
        return new RestaurantTo(restaurant);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Restaurant> add(@Valid @RequestBody Restaurant restaurant) {
        log.info("add {}", restaurant);
        ValidationUtil.checkNew(restaurant);
        restaurant = restaurantRepository.save(restaurant);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/restaurant")
                .build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(restaurant);
    }
}
