package ru.rsreu.hobbies.data;

import org.springframework.data.repository.CrudRepository;
import ru.rsreu.hobbies.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
