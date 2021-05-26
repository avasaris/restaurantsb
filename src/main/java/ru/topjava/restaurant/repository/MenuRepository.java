package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurant.model.Menu;
import ru.topjava.restaurant.to.VoteTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    // TODO return Optional
    List<Menu> findByRestaurantId(Integer restaurantId);

    // TODO return Optional
    Menu findByRestaurantIdAndId(Integer restaurantId, Integer menuId);

    Optional<Menu> findByRestaurantIdAndDate(Integer restaurantId, LocalDate date);

    @Query("SELECT new ru.topjava.restaurant.to.VoteTo(m.restaurant.id, COUNT(v)) FROM Menu m LEFT OUTER JOIN Vote v ON m.id = v.menu.id WHERE m.date = :localDate GROUP BY m.restaurant.id")
    List<VoteTo> findByDate(LocalDate localDate);
}
