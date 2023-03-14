package ru.bip.demo.utils;


import ru.bip.demo.entity.PublisherEntity;
import ru.bip.demo.exception.ValidationExceptionPublisher;

public class PublisherValidationUtils {
    public static void validatePub(PublisherEntity pub) throws ValidationExceptionPublisher {
        String publisher = pub.getPublisher();
        if(publisher==null||publisher.isBlank()){
            throw new ValidationExceptionPublisher("У издательства должно быть название");
        }
        String city = pub.getCity();
        if(city==null||city.isBlank()){
            throw new ValidationExceptionPublisher("Введите город, в котором находится издательство");
        }
    }
}