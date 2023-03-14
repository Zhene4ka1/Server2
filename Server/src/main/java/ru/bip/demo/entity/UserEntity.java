package ru.bip.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    @NotNull(message = "Имя пользователя не может быть пустым")
    private String name;
    @NotNull(message = "Пароль не может быть пустым")
    private String password;
    @NotNull
    private Boolean role;
}
