package ru.bip.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.bip.demo.entity.PublisherEntity;

public interface PublisherRepo extends CrudRepository<PublisherEntity, Long> {
}
