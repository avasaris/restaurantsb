package ru.topjava.restaurant.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.AuthUser;
import ru.topjava.restaurant.error.IllegalRequestDataException;
import ru.topjava.restaurant.model.Menu;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.Vote;
import ru.topjava.restaurant.repository.MenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.repository.VoteRepository;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/restaurant")
@AllArgsConstructor
@Slf4j
public class VoteRestController {
    private VoteRepository voteRepository;
    private RestaurantRepository restaurantRepository;
    private MenuRepository menuRepository;

    @PostMapping(value = "/{restaurantId}/vote", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void voteForRestaurant(@PathVariable Integer restaurantId, @AuthenticationPrincipal AuthUser authUser) {
        log.info("user {} give vote for restaurant {}", authUser.getUser().getEmail(), restaurantId);

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalRequestDataException("Illegal id for restaurant search"));

        Menu menu = menuRepository.findByRestaurantIdAndDate(restaurant.id(), LocalDate.now())
                .orElseThrow(() -> new IllegalRequestDataException("This restaurant doesn't have menu for today"));

        // TODO Add check if vote exists and allow to save if current time lower than 11:00
        voteRepository.save(new Vote(authUser.getUser(), menu));
    }




}
