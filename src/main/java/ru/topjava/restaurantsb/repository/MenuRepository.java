package ru.topjava.restaurantsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurantsb.model.Menu;
import ru.topjava.restaurantsb.to.MenuTo;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RepositoryRestResource(path = "menu")
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    public default List<MenuTo> findAllTo() {
        return findAll().stream().map(MenuTo::new).collect(Collectors.toList());
    }
}
