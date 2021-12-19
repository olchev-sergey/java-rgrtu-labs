package com.arianit.restapp.repository;

import com.arianit.restapp.domain.Hobby;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HobbiesRepository extends CrudRepository<Hobby, Long>{

    List<Hobby> findAllByOrderByNameAsc();

}