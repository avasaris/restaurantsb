package ru.topjava.restaurantsb.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="vote")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vote extends AbstractId {

    LocalDate date;
//    int restaurant; // foreign key
//    int user; // foreign key

}
