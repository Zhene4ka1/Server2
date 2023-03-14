package ru.bip.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.bip.demo.entity.AuthorEntity;
import ru.bip.demo.entity.UserEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorResponse extends BaseResponse {
    public AuthorResponse(boolean success, String message, AuthorEntity author){
        super(success,message);
        this.author= author;
    }
    public AuthorResponse(AuthorEntity author){
        super(true,"Данные автора");
    }
    private AuthorEntity author;
}
