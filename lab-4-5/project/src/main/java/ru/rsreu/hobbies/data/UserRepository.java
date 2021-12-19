package ru.rsreu.hobbies.data;

import org.springframework.data.repository.CrudRepository;
import ru.rsreu.hobbies.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
