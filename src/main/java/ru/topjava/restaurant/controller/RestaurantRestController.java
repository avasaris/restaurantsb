package ru.topjava.restaurant.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.topjava.restaurant.error.IllegalRequestDataException;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.to.MenuTo;
import ru.topjava.restaurant.to.RestaurantTo;
import ru.topjava.restaurant.util.ValidationUtil;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/restaurant")
@AllArgsConstructor
@Slf4j
public class RestaurantRestController {
    private final RestaurantRepository restaurantRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RestaurantTo> getAll() {
        log.info("getAll");
        return restaurantRepository.findAll().stream().map(RestaurantTo::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantTo getById(@PathVariable Integer id) {
        log.info("get {}", id);
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new IllegalRequestDataException("Illegal id for restaurant search"));
        return new RestaurantTo(restaurant);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<RestaurantTo> add(@Valid @RequestBody Restaurant restaurant) {
        log.info("add {}", restaurant);
        ValidationUtil.checkNew(restaurant);
        restaurant = restaurantRepository.save(restaurant);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/restaurant")
                .build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(new RestaurantTo(restaurant));
    }
}
