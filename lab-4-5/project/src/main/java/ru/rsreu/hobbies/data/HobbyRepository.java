package ru.rsreu.hobbies.data;

import org.springframework.data.repository.CrudRepository;
import ru.rsreu.hobbies.Hobby;

public interface HobbyRepository extends CrudRepository<Hobby, String> {

   }
