package ru.topjava.restaurant.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "dish",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"menu_id", "name", "price"},
                name = "dish_unique_all_fields")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dish extends AbstractId {

    @Column(name = "price", precision = 8, scale = 2, nullable = false)
    @Range(min = 0)
    @NotNull
    BigDecimal price;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Menu menu;

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id() +
                ", menu_id=" + menu.id() +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
