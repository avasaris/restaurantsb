package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.topjava.restaurant.model.Menu;
import ru.topjava.restaurant.model.User;
import ru.topjava.restaurant.model.Vote;

import java.time.LocalDate;
import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    Optional<Vote> findByUserAndMenuDate(User user, LocalDate now);
}
