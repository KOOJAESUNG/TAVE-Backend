package com.example.tave.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin {

    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phoneNumber;

    @OneToMany(mappedBy = "admin")
    private List<Team> teams = new ArrayList<>();
}
