package ru.topjava.restaurant.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.restaurant.repository.DishRepository;

@RestController
@RequestMapping(value = "/api/menu")
@AllArgsConstructor
@Slf4j
public class DishRestController {
    private final DishRepository dishRepository;


}
