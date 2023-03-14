package ru.bip.demo.utils;

import ru.bip.demo.entity.AuthorEntity;
import ru.bip.demo.exception.ValidationExceptionAuthor;

public class AuthorValidationUtils {
    public static void validationAuthor(AuthorEntity data) throws ValidationExceptionAuthor{
        String name = data.getName();
        if(name==null||name.isBlank()){
            throw new ValidationExceptionAuthor("Имя не должно быть пустым!");
        }
        String surname = data.getSurname();
        if(surname==null||surname.isBlank()){
            throw new ValidationExceptionAuthor("Фамилия не должна быть пустой!");
        }
        String lastname = data.getLastname();
        if(lastname==null||lastname.isBlank()){
            throw new ValidationExceptionAuthor("Отчество не должно быть пустым!");
        }
    }
}
