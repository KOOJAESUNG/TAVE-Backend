package com.example.tave.domain.admin;

import com.example.tave.domain.team.TeamEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AdminEntity {

    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phoneNumber;

    @OneToMany(mappedBy = "admin")
    private List<TeamEntity> teams = new ArrayList<>();
}
