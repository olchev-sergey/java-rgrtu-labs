package tacos.data;

import org.springframework.data.repository.CrudRepository;

import tacos.Hobby;

public interface HobbyRepository
         extends CrudRepository<Hobby, String> {

}
