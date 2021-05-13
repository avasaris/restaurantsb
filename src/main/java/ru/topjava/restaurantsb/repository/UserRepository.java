package ru.topjava.restaurantsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurantsb.model.User;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
// https://docs.spring.io/spring-data/rest/docs/current/reference/html/#customizing-sdr.hiding-repository-crud-methods
@RestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Integer> {

    @RestResource(rel = "by-email", path = "by-email")
    // https://www.baeldung.com/spring-data-jpa-query
    @Query("SELECT u FROM User u WHERE u.email = LOWER(:email)")
    Optional<User> findByEmailIgnoreCase(String email);

}
