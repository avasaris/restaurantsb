package ru.topjava.restaurant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.topjava.restaurant.model.Library;

@RepositoryRestResource
public interface LibraryRepository extends CrudRepository<Library, Long> {
}
