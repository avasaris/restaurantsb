package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurant.model.Menu;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    List<Menu> findByRestaurantId(Integer restaurantId);

    Menu findByRestaurantIdAndId(Integer restaurantId, Integer menuId);
}
