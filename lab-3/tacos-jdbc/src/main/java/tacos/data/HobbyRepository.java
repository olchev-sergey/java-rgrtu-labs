package tacos.data;

import tacos.Hobby;

public interface HobbyRepository {

  Iterable<Hobby> findAll();
  
  Hobby findById(String id);
  
  Hobby save(Hobby hobby);
  
}
