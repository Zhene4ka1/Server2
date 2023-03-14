package ru.bip.demo.response;


import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.bip.demo.entity.UserEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResponse extends BaseResponse {
    public UserResponse(boolean success, String message, UserEntity user){
        super(success,message);
        this.user=user;
    }
    public UserResponse(UserEntity user){
        super(true,"Данные пользователя");
    }
    private UserEntity user;
}
