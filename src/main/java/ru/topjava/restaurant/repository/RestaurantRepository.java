package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.to.RestaurantTo;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    public default List<RestaurantTo> findAllTo(){
        return findAll().stream().map(RestaurantTo::new).collect(Collectors.toList());
    }
}
