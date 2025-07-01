package com.example.productservices.InheritanceDemo.MAppedSuperClass.JoinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name= "jt_instructors")
public class Instructor extends User {

    private String specialization;
    private Double avgRating;

    // Additional methods or fields can be added here if needed
}
