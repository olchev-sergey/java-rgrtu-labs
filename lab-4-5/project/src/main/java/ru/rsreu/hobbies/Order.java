package ru.rsreu.hobbies;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Person_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date placedAt;

    @ManyToOne
    private User user;

    @NotBlank(message="Имя обязательное поле")
    private String deliveryName;

//    @NotBlank(message="State is required")
//    private String state;

//    @NotBlank(message="Zip code is required")
//    private String zip;

    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Формат должен быть MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Неправильный CVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Person.class)
    private List<Person> persons = new ArrayList<>();

    public void addDesign(Person design) {
        this.persons.add(design);
    }

    @PrePersist
    void placedAt(){this.placedAt = new Date();}
}
