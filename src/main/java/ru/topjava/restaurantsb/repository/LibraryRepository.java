package ru.topjava.restaurantsb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.topjava.restaurantsb.model.Library;

@RepositoryRestResource
public interface LibraryRepository extends CrudRepository<Library, Long> {
}
