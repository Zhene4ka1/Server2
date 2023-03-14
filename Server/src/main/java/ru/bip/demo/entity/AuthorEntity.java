package ru.bip.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле ИМЯ не может быть пустым")
    private String name;
    @NotBlank(message = "Поле ОТЧЕСТВО не может быть пустым")
    private String lastname;
    @NotBlank(message = "Поле ФАМИЛИЯ не может быть пустым")
    private String surname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "author")
    private List<BookEntity> book;


}
