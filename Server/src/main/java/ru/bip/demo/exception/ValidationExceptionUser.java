package ru.bip.demo.exception;

import javax.validation.ValidationException;

public class ValidationExceptionUser extends ValidationException {
    public ValidationExceptionUser(String message){
        super(message);
    }
}
