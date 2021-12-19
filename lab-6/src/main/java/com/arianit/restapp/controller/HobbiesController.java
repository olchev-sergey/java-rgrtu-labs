package com.arianit.restapp.controller;

import com.arianit.restapp.domain.Hobby;
import com.arianit.restapp.service.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/hobbies")
public class HobbiesController {

    @Autowired
    private HobbiesService hobbiesService;


    @RequestMapping( value = "/", method = RequestMethod.GET)
    public Iterable<Hobby> list() {
        return hobbiesService.list();
    }


    @RequestMapping( value = "/", method = RequestMethod.POST)
    public Hobby create(@RequestBody Hobby hobby) {


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSZ");

        Date today = Calendar.getInstance().getTime();


        String createdDate = df.format(today);

        hobby.setTimestamp(createdDate);

        return hobbiesService.create(hobby);
    }


    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public Hobby read(@PathVariable(value="id") long id) {
        return hobbiesService.readById(id);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT)
    public Hobby findByIdAndUpdate(@PathVariable(value="id") long id, @RequestBody Hobby updatedHobby) {
        return hobbiesService.findByIdAndUpdate(id, updatedHobby);
    }



    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value="id") long id) {
        hobbiesService.deleteById(id);
        return "{\"message\": Hobby successfully deleted!}";
    }


    @RequestMapping(value = "/sort/name", method = RequestMethod.GET)
    public Iterable<Hobby> getPeopleOrderedByNameAsc() {
        return hobbiesService.findAllOrderedByNameAsc();
    }
}
