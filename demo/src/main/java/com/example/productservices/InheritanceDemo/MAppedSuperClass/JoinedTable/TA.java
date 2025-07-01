package com.example.productservices.InheritanceDemo.MAppedSuperClass.JoinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_tas")
public class TA extends User{
    private int numberOfSessions;
}
