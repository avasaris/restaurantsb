package ru.topjava.restaurant;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.MenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.repository.UserRepository;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVotingApplication implements ApplicationRunner {
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final DishRepository dishRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(userRepository.findAll());
        System.out.println(userRepository.findByEmailIgnoreCase("admin@yandex.ru"));
        System.out.println(restaurantRepository.findAll());
        System.out.println(menuRepository.findAll());
        System.out.println(dishRepository.findAll());
    }


}
