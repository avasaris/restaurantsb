package ru.topjava.restaurantsb.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="vote", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "restaurant_id", "local_date"}, name = "vote_unique_user_restaurant_date")})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Vote extends AbstractId {

    @Column(name="local_date")
    private LocalDate date;

    @OneToOne
    private User user;

    @OneToOne
    private Restaurant restaurant;

}
