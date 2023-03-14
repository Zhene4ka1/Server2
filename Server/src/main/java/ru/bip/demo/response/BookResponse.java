package ru.bip.demo.response;

import lombok.Data;
import ru.bip.demo.entity.BookEntity;

@Data
public class BookResponse extends BaseResponse{
    private BookEntity book;

   /* public BookResponse(BookEntity data) {
        this.data = data;
    }*/

    public BookResponse(boolean success, String message, BookEntity book) {
        super(success, message);
        this.book = book;
    }
    public BookResponse(BookEntity book){
        super(true,"Данные книги");
    }
}
