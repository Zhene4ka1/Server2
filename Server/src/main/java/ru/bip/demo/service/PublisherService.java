package ru.bip.demo.service;

import org.springframework.stereotype.Service;
import ru.bip.demo.entity.PublisherEntity;
import ru.bip.demo.exception.ValidationExceptionPublisher;
import ru.bip.demo.repo.PublisherRepo;

@Service
public class PublisherService {
    private final PublisherRepo repo;

    public PublisherService(PublisherRepo repo) {
        this.repo = repo;
    }
    public PublisherEntity save(PublisherEntity publisher) throws ValidationExceptionPublisher{
        return repo.save(publisher);
    }
    public Iterable<PublisherEntity> getAll(){return  repo.findAll();}
    public void delete(Long id){
        repo.deleteById(id);
    }
}
