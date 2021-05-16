package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurant.model.Menu;
import ru.topjava.restaurant.to.MenuTo;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    public default List<MenuTo> findAllTo() {
        return findAll().stream().map(MenuTo::new).collect(Collectors.toList());
    }
}
