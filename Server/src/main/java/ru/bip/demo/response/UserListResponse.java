package ru.bip.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.bip.demo.entity.UserEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserListResponse extends  BaseResponse{
    public UserListResponse(Iterable<UserEntity> data){
        super(true,"Авторы");
        this.data=data;
    }
    private Iterable<UserEntity> data;
}
