package ru.topjava.restaurantsb.util;

import lombok.experimental.UtilityClass;
import ru.topjava.restaurantsb.error.IllegalRequestDataException;
import ru.topjava.restaurantsb.model.AbstractId;

@UtilityClass
public class ValidationUtil {

    public static void checkNew(AbstractId entity) {
        if (!entity.isNew()) {
            throw new IllegalRequestDataException(entity.getClass().getSimpleName() + " must be new (id=null)");
        }
    }

    //  Conservative when you reply, but accept liberally (http://stackoverflow.com/a/32728226/548473)
    public static void assureIdConsistent(AbstractId entity, int id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.id() != id) {
            throw new IllegalRequestDataException(entity.getClass().getSimpleName() + " must has id=" + id);
        }
    }
}
