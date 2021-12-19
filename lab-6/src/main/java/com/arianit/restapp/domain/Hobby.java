package com.arianit.restapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Hobby {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;
    private String name;
    private String typeHobby;
    private String interviewee;
    private String timestamp;

    public Hobby(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeHobby() {
        return typeHobby;
    }

    public void setTypeHobby(String hobby) {
        this.typeHobby = hobby;
    }

    public String getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(String interviewee) {
        this.interviewee = interviewee;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}