package ru.bip.demo.service;

import org.springframework.stereotype.Service;
import ru.bip.demo.entity.AuthorEntity;
import ru.bip.demo.entity.BookEntity;
import ru.bip.demo.exception.ValidationExceptionAuthor;
import ru.bip.demo.repo.AuthorRepo;

@Service
public class AuthorService {
    private final AuthorRepo repo;

    public AuthorService(AuthorRepo repo) {
        this.repo = repo;
    }
    public AuthorEntity save(AuthorEntity publisher) throws ValidationExceptionAuthor {
        return repo.save(publisher);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Iterable<AuthorEntity> getAll(){return  repo.findAll();}
}
