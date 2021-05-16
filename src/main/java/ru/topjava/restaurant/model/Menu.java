package ru.topjava.restaurant.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "menu",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"restaurant_id", "local_date"},
                name = "menu_unique_restaurant_date")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends AbstractId {

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @Column(name = "local_date", nullable = false)
    @NotNull
    private LocalDate date;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id() +
                ", restaurant_id=" + (restaurant == null ? "null" : restaurant.id()) +
                ", date=" + date +
                '}';
    }
}
