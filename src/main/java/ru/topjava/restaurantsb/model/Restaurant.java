package ru.topjava.restaurantsb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Restaurant extends AbstractId {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 100)
    private String name;


    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY) // TODO LAZY & JSON initialisation
    @OnDelete(action = OnDeleteAction.CASCADE)
   // @JsonManagedReference
  //  @JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private Set<Menu> menus;


}
