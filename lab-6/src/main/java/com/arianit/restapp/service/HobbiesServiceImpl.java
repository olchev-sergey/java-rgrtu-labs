package com.arianit.restapp.service;

import com.arianit.restapp.domain.Hobby;
import com.arianit.restapp.repository.HobbiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbiesServiceImpl implements HobbiesService {

    @Autowired
    private HobbiesRepository hobbiesRepository;

    @Override
    public Iterable<Hobby> list() {
        return hobbiesRepository.findAll();
    }

    @Override
    public Hobby create(Hobby hobby) {
        return hobbiesRepository.save(hobby);
    }

    @Override
    public Hobby readById(long id) {
        return hobbiesRepository.findOne(id);
    }

    @Override
    public Hobby findByIdAndUpdate(long id, Hobby updatedHobby) {
        Hobby hobby = hobbiesRepository.findOne(id);
        if( updatedHobby.getName() != null ) {
            hobby.setName(updatedHobby.getName());
        }
        if( updatedHobby.getInterviewee() != null) {
            hobby.setInterviewee(updatedHobby.getInterviewee());
        }
        if( updatedHobby.getTypeHobby() != null) {
            hobby.setTypeHobby(updatedHobby.getTypeHobby());
        }

        return hobbiesRepository.save(hobby);
    }

    @Override
    public void deleteById(long id) {
        hobbiesRepository.delete(id);
    }

    @Override
    public List<Hobby> findAllOrderedByNameAsc() {
        return hobbiesRepository.findAllByOrderByNameAsc();
    }

    @Override
    public void saveAll(List<Hobby> people) {
        hobbiesRepository.save(people);
    }

}
