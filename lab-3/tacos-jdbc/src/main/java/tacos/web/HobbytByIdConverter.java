package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Hobby;
import tacos.data.HobbyRepository;

@Component
public class HobbytByIdConverter implements Converter<String, Hobby> {

  private HobbyRepository hobbyRepo;

  @Autowired
  public HobbytByIdConverter(HobbyRepository hobbyRepo) {
    this.hobbyRepo = hobbyRepo;
  }
  
  @Override
  public Hobby convert(String id) {
    return hobbyRepo.findById(id);
  }

}
