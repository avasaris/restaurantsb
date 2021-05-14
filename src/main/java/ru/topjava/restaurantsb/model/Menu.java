package ru.topjava.restaurantsb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "local_date"}, name = "menu_unique_restaurant_date")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends AbstractId {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")//, nullable = false)
    //@NotNull
    //@JsonBackReference
    private Restaurant restaurant;

    @Column(name = "local_date", nullable = false)
    @NotNull
    private LocalDate date;

    @OneToMany(mappedBy = "menu")
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonManagedReference
//    @JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
    @RestResource(path = "dish")
    private Set<Dish> dishes;

    @Override
    public String toString() {
        return "Menu{" +
                "restaurant_id=" + restaurant.id() +
                ", date=" + date +
                ", dishes=" + dishes +
                '}';
    }
}
