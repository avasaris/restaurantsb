package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Menu;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    // TODO return Optional
    List<Dish> findByMenuId(Integer menuId);

    // TODO return Optional
    Menu findByMenuIdAndId(Integer menuId, Integer dishId);
}
