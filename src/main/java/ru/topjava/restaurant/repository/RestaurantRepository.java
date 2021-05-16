package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurant.model.Restaurant;

@Transactional(readOnly = true)
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
