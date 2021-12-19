package ru.rsreu.hobbies;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @NotNull
    @Size(min=5, message="Имя должно содержать не менее 5 символов")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity= Hobby.class)
    @Size(min=1, message="Вы должны выбрать как мининимум один вид растения.")
    private List<Hobby> hobbies;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

}
