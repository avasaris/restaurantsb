package ru.topjava.restaurant.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "dish")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dish extends AbstractId {

    @Column(name = "price", precision = 8, scale = 2, nullable = false)
    @Range(min = 0)
    BigDecimal price;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    //@JsonBackReference
    private Menu menu;

    @Override
    public String toString() {
        return "Dish{" +
                "menu_id=" + menu.id() +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
