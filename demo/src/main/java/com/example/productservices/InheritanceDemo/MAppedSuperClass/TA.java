package com.example.productservices.InheritanceDemo.MAppedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_ta")
public class TA extends User {
    private String subject;
    private String department;

    // Additional methods or fields can be added here if needed
}
