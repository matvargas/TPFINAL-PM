package com.saracurahc.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Speciality {

    @Id
    @GeneratedValue
    private Integer id;

    private String type;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return type;}

    public void setName(String name) {this.type = type;}
}
