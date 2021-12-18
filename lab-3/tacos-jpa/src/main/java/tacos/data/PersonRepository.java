package tacos.data;

import org.springframework.data.repository.CrudRepository;

import tacos.Person;

public interface PersonRepository
         extends CrudRepository<Person, Long> {

}
