package ru.bip.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.bip.demo.entity.AuthorEntity;

public interface AuthorRepo extends CrudRepository<AuthorEntity, Long> {
}
