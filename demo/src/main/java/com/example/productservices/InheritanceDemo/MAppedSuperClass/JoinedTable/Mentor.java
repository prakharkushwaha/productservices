package com.example.productservices.InheritanceDemo.MAppedSuperClass.JoinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jt_mentors")
public class Mentor extends User{
    private String company;

    // Additional methods or fields can be added here if needed
}
