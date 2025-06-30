package com.example.productservices.InheritanceDemo.MAppedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "msc_instructors")
public class Instructor extends User {
    private String Specialization;
    private Double avgRating;

}
