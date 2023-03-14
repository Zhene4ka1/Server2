package ru.bip.demo.utils;

import ru.bip.demo.entity.BookEntity;
import ru.bip.demo.exception.ValidationExceptionBook;

public class BookValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationExceptionBook {
        String title= book.getTitle();
        if(title==null || title.isBlank() || title.length()<2 || title.length()>50)
            throw new ValidationExceptionBook("Название книги должно быть в пределах от 2 до 50 символов");
        if(book.getAuthor()==null)
            throw new ValidationExceptionBook("Нужно выбрать автора");
        if(book.getPublisher()==null)
            throw new ValidationExceptionBook("Нужно выбрать издательство");
        int year = book.getYear();
        if(year < 1900 || year > 2023)
            throw new ValidationExceptionBook("Год книги должен находиться в переделе от 1900 до 2023 года");
        String kind = book.getKind();
        if(kind==null || kind.isBlank() || kind.length()<2 || kind.length()>50)
            throw new ValidationExceptionBook("Название типа данных должно быть в пределах от 2 до 50 символов");
    }
}