package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurant.model.Menu;
import ru.topjava.restaurant.to.MenuTo;
import ru.topjava.restaurant.to.VoteTo;

import java.time.LocalDate;
import java.util.Collection;
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

    @Query(value = "SELECT m.RESTAURANT_ID, COUNT(v.ID) FROM MENU AS m LEFT OUTER JOIN VOTE AS v ON m.ID = v.MENU_ID WHERE m.LOCAL_DATE = :localDate GROUP BY m.RESTAURANT_ID", nativeQuery = true)
    List<IVoteProjection> findByDate(LocalDate localDate);
}
