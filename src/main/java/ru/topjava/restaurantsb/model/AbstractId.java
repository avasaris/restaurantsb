package ru.topjava.restaurantsb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.domain.Persistable;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;

@MappedSuperclass
//  https://stackoverflow.com/a/6084701/548473
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class AbstractId implements Persistable<Integer> {

    @Id
    // https://stackoverflow.com/questions/39094649/h2-database-null-not-allowed-for-column-id-when-inserting-record-using-jdbcte/54697387#54697387
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

    // https://stackoverflow.com/questions/1638723
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!getClass().equals(ProxyUtils.getUserClass(o))) {
            return false;
        }
        AbstractId that = (AbstractId) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }

    public Integer id(){
        return id;
    }
}
