package ru.bip.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.bip.demo.entity.BookEntity;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
    Iterable<BookEntity> findDistinctByPublisher_PublisherOrPublisher_City(String publisher, String city);
}
