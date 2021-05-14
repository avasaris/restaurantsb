package ru.topjava.restaurantsb.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurantsb.model.Restaurant;

import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurantsb.to.RestaurantTo;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RepositoryRestResource//(exported = false)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    public default List<RestaurantTo> findAllTo(){
        return findAll().stream().map(RestaurantTo::new).collect(Collectors.toList());
    }
}
