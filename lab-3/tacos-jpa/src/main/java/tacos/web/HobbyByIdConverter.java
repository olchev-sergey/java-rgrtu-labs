package tacos.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Hobby;
import tacos.data.HobbyRepository;

@Component
public class HobbyByIdConverter implements Converter<String, Hobby> {

  private HobbyRepository hobbyRepo;

  @Autowired
  public HobbyByIdConverter(HobbyRepository hobbyRepo) {
    this.hobbyRepo = hobbyRepo;
  }
  
  @Override
  public Hobby convert(String id) {
    Optional<Hobby> optionalHobby = hobbyRepo.findById(id);
	return optionalHobby.isPresent() ?
		   optionalHobby.get() : null;
  }

}
