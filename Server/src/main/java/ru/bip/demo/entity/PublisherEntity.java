package ru.bip.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "publishers")
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String publisher;
    @NotBlank
    private String city;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "publisher")
    private List<BookEntity> book;
}
