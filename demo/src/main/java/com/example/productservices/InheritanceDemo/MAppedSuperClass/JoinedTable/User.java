package com.example.productservices.InheritanceDemo.MAppedSuperClass.JoinedTable;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "jt_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
}
