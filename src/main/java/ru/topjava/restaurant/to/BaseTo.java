package ru.topjava.restaurant.to;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public abstract class BaseTo {
    protected Integer id;
}
