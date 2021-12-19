package ru.rsreu.hobbies.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.rsreu.hobbies.Hobby;
import ru.rsreu.hobbies.data.HobbyRepository;

import java.util.Optional;

@Component
public class HobbiesByIdConverter implements Converter<String, Hobby>  {

    private HobbyRepository hobbyRepo;

    @Autowired
    public HobbiesByIdConverter(HobbyRepository hobbyRepo){
        this.hobbyRepo = hobbyRepo;
    }

    @Override
    public Hobby convert(String id)
    {
        Optional<Hobby> optionalConstituents = hobbyRepo.findById(id);
        return optionalConstituents.isPresent() ?
                optionalConstituents.get() : null;
    }
}
