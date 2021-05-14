package ru.topjava.restaurantsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurantsb.model.Dish;

@Transactional(readOnly = true)
@RepositoryRestResource(path = "dish")
public interface DishRepository extends JpaRepository<Dish, Integer> {
}
