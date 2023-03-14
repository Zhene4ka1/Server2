package ru.bip.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.bip.demo.entity.AuthorEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorListResponse extends  BaseResponse{
    public AuthorListResponse(Iterable<AuthorEntity> data){
        super(true,"Авторы");
        this.data=data;
    }
    private Iterable<AuthorEntity> data;
}
