package ru.topjava.restaurantsb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.topjava.restaurantsb.model.Book;

//@RepositoryRestResource(exported = false)
public interface BookRepository extends CrudRepository<Book, Long> {
}
