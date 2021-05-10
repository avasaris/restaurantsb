package ru.topjava.restaurantsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurantsb.model.Restaurant;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
