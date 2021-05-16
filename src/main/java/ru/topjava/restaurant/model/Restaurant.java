package ru.topjava.restaurant.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant extends AbstractId {

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    @Size(max = 100)
    private String name;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id() +
                ", name='" + name + '\'' +
                '}';
    }
}
