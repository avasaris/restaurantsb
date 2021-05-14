package ru.topjava.restaurantsb;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.topjava.restaurantsb.repository.DishRepository;
import ru.topjava.restaurantsb.repository.MenuRepository;
import ru.topjava.restaurantsb.repository.RestaurantRepository;
import ru.topjava.restaurantsb.repository.UserRepository;

@SpringBootApplication
@AllArgsConstructor
public class RestaurantVoitingApplication implements ApplicationRunner {
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final DishRepository dishRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(userRepository.findAll());
        System.out.println(userRepository.findByEmailIgnoreCase("admin@yandex.ru"));
        System.out.println(restaurantRepository.findAllTo());
        System.out.println(menuRepository.findAllTo());
        System.out.println(dishRepository.findAll());
    }


}
