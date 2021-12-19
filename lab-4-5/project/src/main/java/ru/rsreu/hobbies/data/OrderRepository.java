package ru.rsreu.hobbies.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.rsreu.hobbies.Order;
import ru.rsreu.hobbies.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(
            User user, Pageable pageable);

}
