package com.arianit.restapp.service;

import com.arianit.restapp.domain.Hobby;

import java.util.List;


public interface HobbiesService {

    Iterable<Hobby> list();

    Hobby create(Hobby hobby);

    Hobby readById(long id);

    Hobby findByIdAndUpdate(long id, Hobby updatedHobby);

    void deleteById(long id);

    List<Hobby> findAllOrderedByNameAsc();

    void saveAll(List<Hobby> people);

}